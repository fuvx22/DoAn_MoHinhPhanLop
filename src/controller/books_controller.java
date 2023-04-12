package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.DAObooks;
import database.JDBC_Util;
import model.books;
import view.books_view;

public class books_controller implements ActionListener{

	books_view context;
	
	public books_controller(books_view context) {
		this.context = context;
	}
	public void actionPerformed(ActionEvent e) {
		e.getSource();
	}
	public ArrayList<books> getBooksList(){
//		return DAObooks.getInstance().getAll();
		return null;
	}

}
