package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC_Util;
import model.librarian;

public class DAOlibrarian implements DAOInterface<librarian>{
	
	ArrayList<librarian> ketQua = new ArrayList<>();
	
	public static DAOlibrarian getInstance() {
		return new DAOlibrarian();
	}

	@Override
	public boolean insert(librarian t) {
		
		try {
			Connection con = JDBC_Util.getConnection();
			
			String sql = "INSERT INTO librarian (name, address, log_name, log_pw) "+
						 "VALUES (?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setString(2, t.getAddress());
			st.setString(3, t.getLogin_name());
			st.setString(4, t.getLogin_pw());
		
				
			st.executeUpdate();
					
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean update(librarian t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			
			String sql = "UPDATE librarian "+
						 " SET "+
						 " name=?"+
						 " ,address=?"+
						 " ,log_name=?"+
						 " ,log_pw=?";	
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setString(2, t.getAddress());
			st.setString(3, t.getLogin_name());
			st.setString(4, t.getLogin_pw());
			
			st.executeUpdate();
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(librarian t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			
			String sql = " DELETE from librarian "+
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
	public librarian selectById(int id) {
		// TODO Auto-generated method stub
		librarian found = null;
		
		Connection con = JDBC_Util.getConnection();
		
		try {

			String sql = "SELECT * FROM librarian WHERE book_id =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				found = new librarian(rs.getInt("id"), rs.getString("name"),
						rs.getString("address"), rs.getString("log_name"), rs.getString("log_pw"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBC_Util.closeConnection(con);
		
		return found;
	}
	
	@Override
	public ArrayList<librarian> getAll() {
		// TODO Auto-generated method stub
		Connection con = JDBC_Util.getConnection();
		
		try {
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM librarian";					 
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				librarian b = new librarian(rs.getInt("id"), rs.getString("name"),
						rs.getString("address"), rs.getString("log_name"), rs.getString("log_pw"));
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
	public ArrayList<librarian> selectByCondition(String con) {
		// TODO Auto-generated method stub
		return null;
	}

}
