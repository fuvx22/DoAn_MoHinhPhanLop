package test;


import java.sql.Connection;
import java.sql.Date;

import dao.DAObooks;
import database.JDBC_Util;
import model.books;

public class test {
	public static void main(String[] args) {
		
		books book1 = new books("How to become rich 2","Michel Nguyen", new Date(0), 30);
		books book2 = new books("Python","Kenrick Jr", new Date(1), 15);
		books book3 = new books(22,"C#","Harry Kane", new Date(1), 30);
		
		//test insert
		
//		DAObooks.getInstance().insert(book1);
//		DAObooks.getInstance().insert(book2);
		
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
