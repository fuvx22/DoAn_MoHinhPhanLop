package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import dao.DAObooks;
import database.JDBC_Util;
import model.books;
import view.books_view;
import view.home_view;

public class books_controller implements ActionListener{

	books_view context;
	ArrayList<books> book_list;		
	private String book_name;
	private String author;
	private int quantity;
	private String rel_date;
	private int selectRow = -1;
	private books bookDTO;
	
	public books_controller(books_view context) {	
		this.context = context;
		book_list = DAObooks.getInstance().getAll();
		context.loadTable(book_list);
		initTableControl();
	}
	public void actionPerformed(ActionEvent e) {
		
		
//		Xử lý thêm sách
		
		if(e.getSource().equals(context.add_btn)) {	
			try {
				
				book_name = context.nameText.getText();
				author = context.authorText.getText();
				quantity = Integer.valueOf(context.quanText.getText());
				rel_date = new SimpleDateFormat("yyyy-MM-dd").format(context.dateText.getDate());
				
				bookDTO = new books(book_name, author,Date.valueOf(rel_date), quantity);
				DAObooks.getInstance().insert(bookDTO);
				book_list.add(bookDTO);				
				context.loadTable(DAObooks.getInstance().getAll());
				context.clearText();
				home_view.notify("Thêm sách thành công!");
				
			} catch (NumberFormatException e1) {	
				home_view.warning("Vui lòng không bỏ trống hoặc nhập đúng định dạng!");
				context.nameText.requestFocus();
			}
			
		}
		
//		Xử lý sửa sách		
		if (e.getSource().equals(context.edit_btn)) {
			if (selectRow != -1) {
				
				bookDTO = new books();
				bookDTO.setBook_id(book_list.get(selectRow).getBook_id());
				bookDTO.setProperty(context.nameText.getText(), context.authorText.getText()
						, Integer.valueOf(context.quanText.getText()), context.dateText.getDate());
				
				if(bookDTO.compare(book_list.get(selectRow))) {
					home_view.warning("Thông tin sách không bị thay đổi !!!");
				}
				else {
					DAObooks.getInstance().update(bookDTO);
					book_list.set(selectRow, bookDTO);
					context.loadTable(DAObooks.getInstance().getAll());
					context.clearText();
					home_view.notify("Sửa đổi thông tin sách thành công!");
				}
			}
			return;
		}
		
//		Xử lý xóa sách	
		if (e.getSource().equals(context.del_btn)) {
			
			if (selectRow != -1) {
				bookDTO = new books();
				bookDTO.setBook_id(book_list.get(selectRow).getBook_id());
				DAObooks.getInstance().delete(bookDTO);
				book_list.remove(selectRow);
				context.loadTable(book_list);
				context.clearText();
				home_view.notify("Xóa sách thành công!");
			}
			return;
		}
		
		if(e.getSource().equals(context.refresh_btn)) {
			context.loadTable(DAObooks.getInstance().getAll());
		}
		
	}
	private void initTableControl() {
		context.table.addMouseListener(new MouseListener() {	
		
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = context.table.getSelectedRow();
				books selectBook =  book_list.get(selectRow);
				context.setText(selectBook.getName(), selectBook.getQuantity(),
						selectBook.getAuthor(), selectBook.getRelease_date());
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
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	
}
