package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
	private books bookDTO;
	
	public books_controller(books_view context) {	
		this.context = context;
		book_list = DAObooks.getInstance().getAll();
		context.loadTable(book_list);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(context.add_btn)) {	
			try {
				
				book_name = context.nameText.getText();
				author = context.authorText.getText();
				quantity = Integer.valueOf(context.quanText.getText());
				rel_date = new SimpleDateFormat("yyyy-MM-dd").format(context.dateText.getDate());
				bookDTO = new books(book_name, author,Date.valueOf(rel_date), quantity);
				DAObooks.getInstance().insert(bookDTO);
				
				book_list.add(bookDTO);
				context.loadTable(book_list);
				context.clearText();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
				home_view.warning("Vui lòng không bỏ trống hoặc nhập đúng định dạng!");
			}
			
		}
	}
	
}
