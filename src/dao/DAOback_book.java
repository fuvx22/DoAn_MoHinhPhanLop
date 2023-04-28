package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC_Util;
import model.back_book;

public class DAOback_book implements DAOInterface<back_book>{
	
	ArrayList<back_book> ketQua = new ArrayList<>();
	
	public static DAOback_book getInstance() {
		return new DAOback_book();
	}

	@Override
	public boolean insert(back_book t) {
		
		try {
			Connection con = JDBC_Util.getConnection();
			
			String sql = "INSERT INTO back_book (book_id, reader_id, quantity, back_date, lib_id) "+
						 "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getBook_id());
			st.setInt(2, t.getReader_id());
			st.setInt(3, t.getQuantity());
			st.setDate(4, t.getBack_date());
			st.setInt(5, t.getLib_id());
				
			st.executeUpdate();
					
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean update(back_book t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			
			String sql = "UPDATE back_book "+
						 " SET "+
						 " book_id=?"+
						 " ,reader_id=?"+
						 " ,quantity=?"+
						 " ,back_date=?"+
						 " ,lib_id=";	
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getBook_id());
			st.setInt(2, t.getReader_id());
			st.setInt(3, t.getQuantity());
			st.setDate(4, t.getBack_date());
			st.setInt(5, t.getLib_id());
			
			st.executeUpdate();
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(back_book t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			
			String sql = " DELETE from back_book "+
					     " WHERE id=?";
						
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			st.executeUpdate();
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public back_book selectById(int id) {
		// TODO Auto-generated method stub
		back_book found = null;
		
		Connection con = JDBC_Util.getConnection();
		
		try {

			String sql = "SELECT * FROM back_book WHERE id =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				found = new back_book(rs.getInt("id"), 
						rs.getInt("book_id"), 
						rs.getInt("reader_id"), 
						rs.getInt("quantity"),
						rs.getDate("back_date"),		
						rs.getInt("lib_id"));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBC_Util.closeConnection(con);
		
		return found;
	}
	
	@Override
	public ArrayList<back_book> getAll() {
		// TODO Auto-generated method stub
		Connection con = JDBC_Util.getConnection();
		
		try {
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM back_book";					 
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				back_book b = new back_book(rs.getInt("id"), 
						rs.getInt("book_id"), 
						rs.getInt("reader_id"), 
						rs.getInt("quantity"),
						rs.getDate("back_date"),		
						rs.getInt("lib_id"));
				ketQua.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBC_Util.closeConnection(con);
		
		return ketQua;
		
	}

	@Override
	public ArrayList<back_book> selectByCondition(String con) {
		// TODO Auto-generated method stub
		return null;
	}

}
