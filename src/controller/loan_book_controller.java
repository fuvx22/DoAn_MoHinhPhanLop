package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Date;

import dao.DAObooks;
import dao.DAOloan_book;
import model.loan_book;
import resource.converter;
import view.back_book_view;
import view.home_view;
import view.loan_book_view;

public class loan_book_controller implements ActionListener{
	loan_book_view context;
	ArrayList<loan_book> list;
	int selectRow = -1;
	loan_book loan_bookDTO;
	
	public loan_book_controller(loan_book_view context) {
		this.context = context;
		list = DAOloan_book.getInstance().getAll();
		context.loadTable(list);
		this.initTableListener();
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
				list.add(loan_bookDTO);
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
			new back_book_view(loan_bookDTO);
		}
		
		
	}
	private void initTableListener() {
		context.table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = context.table.getSelectedRow();
				loan_bookDTO = new loan_book(list.get(selectRow));
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

}