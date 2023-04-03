package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC_Util;
import model.books;

public class DAObooks implements DAOInterface<books>{
	
	public static DAObooks getInstance() {
		return new DAObooks();
	}

	@Override
	public boolean insert(books t) {
		
		try {
			Connection con = JDBC_Util.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO books (book_name, author, release_date, quantity, borrow_quantity) "+
						 "VALUES ('"+t.getName()+"', '"+t.getAuthor()+"', '"+t.getRelease_date()+"', "+t.getQuantity()+", "+t.getBrr_quantity()+")";
		
			
			int ketQua = st.executeUpdate(sql);
			
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println("Co "+ketQua+" dong bi thay doi!");		
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean update(books t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "UPDATE books "+
						 " SET "+
						 " book_name='" + t.getName()+"'"+
						 " ,author='" + t.getAuthor()+"'"+
						 " ,release_date='" + t.getRelease_date()+"'"+
						 " ,quantity=" + t.getQuantity()+
						 " ,borrow_quantity=" + t.getBrr_quantity()+
						 " WHERE book_id = " + t.getBook_id();	
			
			int ketQua = st.executeUpdate(sql);
			
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println("Co "+ketQua+" dong bi thay doi!");		
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(books t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = " DELETE from books "+
					     " WHERE book_id="+ t.getBook_id();
						
			
			int ketQua = st.executeUpdate(sql);
			
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println("Co "+ketQua+" dong bi thay doi!");		
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public books selectById(books t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<books> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<books> selectByCondition(String con) {
		// TODO Auto-generated method stub
		return null;
	}

}
