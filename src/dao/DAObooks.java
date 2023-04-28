package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC_Util;
import model.books;

public class DAObooks implements DAOInterface<books>{
	
	ArrayList<books> ketQua = new ArrayList<>();
	
	public static DAObooks getInstance() {
		return new DAObooks();
	}

	@Override
	public boolean insert(books t) {
		
		try {
			Connection con = JDBC_Util.getConnection();
			
			String sql = "INSERT INTO books (book_name, author, release_date, quantity, borrow_quantity) "+
						 "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setString(2, t.getAuthor());
			st.setDate(3, t.getRelease_date());
			st.setInt(4, t.getQuantity());
			st.setInt(5, t.getBrr_quantity());
					
			st.executeUpdate();
					
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
			
			
			String sql = "UPDATE books "+
						 " SET "+
						 " book_name=?"+
						 " ,author=?"+
						 " ,release_date=?"+
						 " ,quantity=?"+
						 " WHERE book_id =?";	
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setString(2, t.getAuthor());
			st.setDate(3, t.getRelease_date());
			st.setInt(4, t.getQuantity());
			st.setInt(5, t.getBook_id());
			
			st.executeUpdate();
			
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
			
			
			String sql = " DELETE from books "+
					     " WHERE book_id=?";
						
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getBook_id());
			
			st.executeUpdate();
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public books selectById(int id) {
		// TODO Auto-generated method stub
		books found = null;
		
		Connection con = JDBC_Util.getConnection();
		
		try {

			String sql = "SELECT * FROM books WHERE book_id =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				found = new books(rs.getInt("book_id"), rs.getString("book_name"),
						rs.getString("author"), rs.getDate("release_date"), 
						rs.getInt("quantity"), rs.getInt("borrow_quantity"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBC_Util.closeConnection(con);
		
		return found;
	}
	
	@Override
	public ArrayList<books> getAll() {
		// TODO Auto-generated method stub
		Connection con = JDBC_Util.getConnection();
		
		try {
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM books";					 
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				books b = new books(rs.getInt("book_id"), rs.getString("book_name"),
						rs.getString("author"), rs.getDate("release_date"), rs.getInt("quantity"),
						rs.getInt("borrow_quantity"));
				ketQua.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBC_Util.closeConnection(con);
		
		return ketQua;
		
	}
	
	public boolean updateBrrQuantity(int id, int quantity) {
		try {
			
			Connection con = JDBC_Util.getConnection();
				
			String sql = "UPDATE books "+
						 " SET "+
						 " borrow_quantity= borrow_quantity + ?"+
						 " WHERE book_id = ?";	
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, quantity);
			st.setInt(2, id);
			
			st.executeUpdate();
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<books> selectByCondition(String con) {
		// TODO Auto-generated method stub
		return null;
	}

}
