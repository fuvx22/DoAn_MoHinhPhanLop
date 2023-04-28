package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC_Util;
import model.readers;

public class DAOreaders implements DAOInterface<readers>{
	
	ArrayList<readers> ketQua = new ArrayList<>();
	
	public static DAOreaders getInstance() {
		return new DAOreaders();
	}

	@Override
	public boolean insert(readers t) {
		
		try {
			Connection con = JDBC_Util.getConnection();
			
			String sql = "INSERT INTO readers (name, phone_number, address) "+
						 "VALUES (?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setString(2, t.getPhone_number());
			st.setString(3, t.getAddress());
		
				
			st.executeUpdate();
					
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean update(readers t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			
			String sql = "UPDATE readers "+
						 " SET "+
						 " name=?"+
						 " ,phone_number=?"+
						 " ,address=";	
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setString(2, t.getPhone_number());
			st.setString(3, t.getAddress());
			
			st.executeUpdate();
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(readers t) {
		try {
			Connection con = JDBC_Util.getConnection();
			
			
			String sql = " DELETE from readers "+
					     " WHERE id=?";
						
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getReader_id());
			
			st.executeUpdate();
			
			JDBC_Util.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public readers selectById(int id) {
		// TODO Auto-generated method stub
		readers found = null;
		
		Connection con = JDBC_Util.getConnection();
		
		try {

			String sql = "SELECT * FROM readers WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				found = new readers(rs.getInt("id"), rs.getString("name"),
						rs.getString("phone_number"), rs.getString("address"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBC_Util.closeConnection(con);
		
		return found;
	}
	
	@Override
	public ArrayList<readers> getAll() {
		// TODO Auto-generated method stub
		Connection con = JDBC_Util.getConnection();
		
		try {
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM readers";					 
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				readers b = new readers(rs.getInt("id"), rs.getString("name"),
						rs.getString("phone_number"), rs.getString("address"));
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
	public ArrayList<readers> selectByCondition(String con) {
		// TODO Auto-generated method stub
		return null;
	}

}
