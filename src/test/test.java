package test;

import java.sql.Date;

import dao.DAObooks;
import dao.DAOlibrarian;
import dao.DAOloan_book;
import dao.DAOreaders;
import model.books;
import model.librarian;
import model.loan_book;
import model.readers;
import view.login_view;

public class test {
	static login_view frame;
	
	public static void main(String[] args) {
			frame = new login_view();
			frame.setVisible(true);
	}
	
	public static void rerun() {
		frame.setVisible(true);
	}
}
