package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import dao.DAObooks;
import dao.DAOloan_book;
import model.loan_book;
import resource.converter;
import view.back_book_view;
import view.home_view;
import view.loan_book_view;
import view.renew_book_view;

public class loan_book_controller implements ActionListener{
	loan_book_view context;
	ArrayList<loan_book> list;
	int selectRow = -1;
	loan_book loan_bookDTO;
	
	public loan_book_controller(loan_book_view context) {
		checkForOverDue();
		this.context = context;
		list = DAOloan_book.getInstance().getAll();
		context.loadTable(list);
		this.initTableListener();
		this.initOptionfilter();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
//		 Xử lý thêm mới phiếu mượn
		if(e.getSource().equals(context.add_btn)) {
			try {
				int bookID = Integer.valueOf(context.bookText.getText());
				int readerID = Integer.valueOf(context.readerText.getText());
				int Brrquantity = Integer.valueOf(context.quanText.getText());
				Date expDate = context.dateText.getDate();
				Date loanDate = new Date();
				int libId = 1;
				
				if(expDate.compareTo(loanDate) < 0) {
					home_view.warning("Hạn trả sách không hợp lệ!");
					context.dateText.requestFocus();
					return;
				}
				
				loan_bookDTO = new loan_book(bookID, readerID, 
					 	 Brrquantity, converter.toSQLDate(loanDate),converter.toSQLDate(expDate), libId);
					
				if (!DAOloan_book.getInstance().insert(loan_bookDTO)) {
					home_view.warning("mã sách hoặc độc giả không tồn tại!");
					return;
				}
				
				int bookQuantity = DAObooks.getInstance().selectById(bookID).getQuantity();
				int currentBrr = DAObooks.getInstance().selectById(bookID).getBrr_quantity();
				
				int totalBrrQuan = currentBrr+Brrquantity;
				
				if (totalBrrQuan > bookQuantity) {
					home_view.warning("Không đủ số lượng sách để mượn");
					return;
				}
				
				DAObooks.getInstance().updateBrrQuantity(bookID, Brrquantity);
				list = DAOloan_book.getInstance().getAll();
				context.loadTable(list);
				context.clearText();
				
				home_view.notify("Mượn sách thành công :)");
				return;
				
			} catch (NumberFormatException e1) {
				home_view.warning("Vui lòng không bỏ trống hoặc nhập sai định dạng!");
			} catch (NullPointerException e2) {
				context.dateText.requestFocus();
				home_view.warning("Vui lòng không bỏ trống Hạn trả sách");
			} 
		}
//		Xử lý trả phiếu mượn
		
		if (e.getSource().equals(context.return_btn)) {
			if (selectRow == -1) {
				home_view.warning("Vui lòng chọn phiếu mượn để thực hiện trả!");
				return;
			}
			new back_book_view(loan_bookDTO).setLocationRelativeTo(context);
		
		}
		
//		Xử lý gia hạn phiếu mượn
		
		if (e.getSource().equals(context.renew_btn)) {
			
			if (selectRow == -1) {
				home_view.warning("Vui lòng chọn phiếu mượn để thực hiện gia hạn!");
				return;
			}
			renew_book_view view = new renew_book_view(loan_bookDTO);
			view.setLocationRelativeTo(context);
			view.setVisible(true);
		}
		
		if(e.getSource().equals(context.refresh_btn)) {
			context.loadTable(DAOloan_book.getInstance().getAll());
			context.tableSearch("");
		}
		
		if (e.getSource().equals(context.find_btn)) {
			context.tableSearch(context.findText.getText());
			context.findText.setText("");
		}
		
	}
	private void initTableListener() {
		context.table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = context.table.getSelectedRow();
				loan_bookDTO = new loan_book(list.get(selectRow));
				canReturnAndRenewVerify();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});	
	}

	private void initOptionfilter() {
		context.showOption.addItem("Tất cả");
		context.showOption.addItem("Đang mượn");
		context.showOption.addItem("Quá hạn");
		context.showOption.addItem("Đã trả");
		
		context.showOption.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {			
				 if (e.getStateChange() == ItemEvent.SELECTED) {
			         Object item = e.getItem();
	
			         if (item.equals("Tất cả")) {
			        	 context.tableSearch("");
			         }else if (item.equals("Đang mượn")) {
			        	 context.tableSearch("active");
			        	 
			         }else if (item.equals("Quá hạn")) {
			        	 context.tableSearch("overdue");
			        	 
			         }else if (item.equals("Đã trả")) {
			        	 context.tableSearch("returned");
			        	 
			         }		         
			       }
			}
		});
		
	}
	public void canReturnAndRenewVerify() {
		
		if (loan_bookDTO.getState().equals("returned") || loan_bookDTO.getState().equals("overdue")) {
			context.return_btn.setEnabled(false);
			context.renew_btn.setEnabled(false);
		} else {
			context.return_btn.setEnabled(true);
			context.renew_btn.setEnabled(true);
		}
	}
	public void checkForOverDue() {
		java.sql.Date currentDate = java.sql.Date.valueOf(LocalDate.now());
		for (loan_book row : DAOloan_book.getInstance().getAll()) {
			if (row.getExp_date().compareTo(currentDate) <= -1 && row.getState().equals("active")) {
				row.setState("overdue");
				DAOloan_book.getInstance().update(row);
			}
			else {
			}
		}
	}

}