package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.DAOloan_book;
import model.loan_book;
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
	
		if(e.getSource().equals(context.add_btn)) {
			try {
//				int bookID = Integer.valueOf(context.bookText.getText());
//				int readerID = Integer.valueOf(context.readerText.getText());
//				int quantity = Integer.valueOf(context.quanText.getText());
				Date returnDate = context.dateText.getDate();
				
				Date loanDate = new Date();
				if(returnDate.compareTo(loanDate) < 0 ) {
					System.out.println("1 > 2");
				}
				else {
					System.out.println("2 > 1");
				}
				
			} catch (NumberFormatException e1) {
				home_view.warning("Vui lòng không bỏ trống hoặc nhập sai định dạng!");
			}
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