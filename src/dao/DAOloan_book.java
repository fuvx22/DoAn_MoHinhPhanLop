package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC_Util;
import model.loan_book;

public class DAOloan_book implements DAOInterface<loan_book>{
	
	ArrayList<loan_book> ketQua = new ArrayList<>();
	
	public static DAOloan_book getInstance() {
		return new DAOloan_book();
	}

	@Override
	public boolean insert(loan_book t) {
		
		try {
			Connection con = JDBC_Util.getConnection();
			
			String sql = "INSERT INTO loan_book (book_id, reader_id, quantity, loan_date, exp_date, lib_id, state) "+
						 "VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getBook_id());
			st.setInt(2, t.getReader_id());
			st.setInt(3, t.getQuantity());
			st.setDate(4, t.getLoan_date());
			st.setDate(5, t.getExp_date());
			st.setInt(6, t.getLib_id());
			st.setBoolean(7, t.isState());
				
			st.executeUpdate();
					
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean update(loan_book t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			
			String sql = "UPDATE loan_book "+
						 " SET "+
						 " book_id=?"+
						 " ,reader_id=?"+
						 " ,quantity=?"+
						 " ,loan_date=?"+
						 " ,exp_date=?"+
						 " ,lib_id=";	
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getBook_id());
			st.setInt(2, t.getReader_id());
			st.setInt(3, t.getQuantity());
			st.setDate(4, t.getLoan_date());
			st.setDate(5, t.getExp_date());
			st.setInt(6, t.getLib_id());
			
			st.executeUpdate();
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(loan_book t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			
			String sql = " DELETE from loan_book "+
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
	public loan_book selectById(int id) {
		// TODO Auto-generated method stub
		loan_book found = null;
		
		Connection con = JDBC_Util.getConnection();
		
		try {

			String sql = "SELECT * FROM loan_book WHERE book_id =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				found = new loan_book(rs.getInt("id"), 
						rs.getInt("book_id"), 
						rs.getInt("reader_id"), 
						rs.getInt("quantity"),
						rs.getDate("loan_date"),
						rs.getDate("exp_date"),
						rs.getInt("lib_id"),
						rs.getBoolean("state"));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBC_Util.closeConnection(con);
		
		return found;
	}
	
	@Override
	public ArrayList<loan_book> getAll() {
		// TODO Auto-generated method stub
		Connection con = JDBC_Util.getConnection();
		
		try {
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM loan_book";					 
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				loan_book b = new loan_book(rs.getInt("id"), 
						rs.getInt("book_id"), 
						rs.getInt("reader_id"), 
						rs.getInt("quantity"),
						rs.getDate("loan_date"),
						rs.getDate("exp_date"),
						rs.getInt("lib_id"),
						rs.getBoolean("state"));
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
	public ArrayList<loan_book> selectByCondition(String con) {
		// TODO Auto-generated method stub
		return null;
	}

}
