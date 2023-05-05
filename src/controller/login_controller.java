package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.JDBC_Util;
import model.librarian;
import resource.converter;
import view.home_view;
import view.login_view;

public class login_controller implements ActionListener{
	
	login_view context;
	public static librarian currentUser;
	
	public login_controller(login_view context) {
		this.context = context;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(context.btn)) {
			try {
				String userName = context.getUserName();
				String passwrd 	= context.getPassword(); 
				if (userName.length() == 0) return;
				if (passwrd.length() == 0) return;
				
				String hashPass =  converter.hashPassword(passwrd);
				
				if (loginAuthen(userName, hashPass) && currentUser !=null) {
				
					home_view frame = new home_view();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					
					context.setVisible(false);
					
				}else {
					context.showThongBaoLoi();
				}
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	private boolean loginAuthen(String userName, String password) {
		
		Connection con = JDBC_Util.getConnection();
		
		try {

			String sql = "SELECT * FROM librarian WHERE log_name =? AND log_pw =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				this.currentUser = new librarian(rs.getInt("id"), rs.getString("name"),
						rs.getString("address"), rs.getString("log_name"), rs.getString("log_pw"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		JDBC_Util.closeConnection(con);	
		return true;
	}
	
}
