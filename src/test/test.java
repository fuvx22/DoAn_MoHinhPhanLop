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

public class test {
	public static void main(String[] args) {
		
		books book1 = new books("How to become rich 2","Michel Nguyen", new Date(0), 30);
		books book2 = new books("Python","Kenrick Jr", new Date(1), 15);
		books book3 = new books(22,"C#","Harry Kane", new Date(1), 30);
		
		//test insert
		
//		DAObooks.getInstance().insert(book1);
//		DAObooks.getInstance().insert(book2);
		
//		DAOloan_book.getInstance().insert(new loan_book(14,1,2,new Date(0),new Date(0),1));
		
		DAOlibrarian.getInstance().insert(new librarian("Nguyen Van A", "69 Nguyen Trai","admin","123"))
		
		//test update
		
//		DAObooks.getInstance().update(book3);
		
		//test delete
		
//		for (int i = 1; i < 6  ;i++) {
//			books sach = new books();
//			sach.setBook_id(i);
//			DAObooks.getInstance().delete(book3);
//		}
		
//		DAObooks.getInstance().getAll();
		
//		String result = DAObooks.getInstance().selectById(14).toString();
//		System.out.println(result);
		
;	}
}
