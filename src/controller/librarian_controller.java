package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.DAOlibrarian;
import model.librarian;
import view.home_view;
import view.librarians_view;


public class librarian_controller implements ActionListener{
	
	private String librarianName;
	private String librarianAddress;
	private String username;
	private String password;
	private librarian librarianDTO;
	
	librarians_view context;
	ArrayList<librarian> librarian_list;
	private int selectRow = -1;
	
	
	public librarian_controller(librarians_view context) {	
		this.context = context;
		librarian_list = DAOlibrarian.getInstance().getAll();
		context.loadTable(librarian_list);
		initTableControl();
	}
	
	public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodehash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        
        StringBuilder hexString = new StringBuilder(2*encodehash.length);
        for(int i = 0; i< encodehash.length; i++) {
        	String hex = Integer.toHexString(0xff & encodehash[i]);
        	if (hex.length() == 1) {
				hexString.append('0');
			}
        	hexString.append(hex);
        }
        return hexString.toString();
    }
	
	
	public void actionPerformed(ActionEvent e) {
		// Xử lý thêm thủ thư
		if(e.getSource().equals(context.add_btn)) {	
			try {
				librarianName = context.nameText.getText();
				librarianAddress = context.addressText.getText();
				username = context.userText.getText();
				password = context.passwordText.getText() ;
				
				
				if(librarianName.isBlank() || librarianAddress.isBlank() || username.isBlank() || password.isBlank()) {
					JOptionPane.showMessageDialog(context, "Vui lòng không bỏ trống thông tin", "WARN", JOptionPane.WARNING_MESSAGE);
				} else {
					librarianDTO = new librarian(librarianName, librarianAddress, username, hashPassword(context.passwordText.getText()));
					DAOlibrarian.getInstance().insert(librarianDTO);
					librarian_list.add(librarianDTO);				
					context.loadTable(DAOlibrarian.getInstance().getAll());
					context.clearText();
					home_view.notify("Thêm thủ thư thành công!");
				}
			} catch (NumberFormatException e1) {	
				home_view.warning("Vui lòng không bỏ trống hoặc nhập đúng định dạng!");
				context.nameText.requestFocus();
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		// Xử lý xóa thủ thư
		if (e.getSource().equals(context.del_btn)) {
			
			if (selectRow != -1) {
				librarianDTO = new librarian();
				librarianDTO.setId(librarian_list.get(selectRow).getId());
				DAOlibrarian.getInstance().delete(librarianDTO);
				librarian_list.remove(selectRow);
				context.loadTable(librarian_list);
				context.clearText();
				home_view.notify("Xóa thử thư thành công!");
			}
			return;
		}
		
		
		// Xử lý sửa thông tin thủ thư
		if (e.getSource().equals(context.edit_btn)) {
			if (selectRow != -1) {
				
				librarianDTO = new librarian();
				librarianDTO.setId(librarian_list.get(selectRow).getId());
				librarianDTO.setProperty(context.nameText.getText(), context.addressText.getText(), context.userText.getText(), context.passwordText.getText());
				
				if (librarianDTO.compare(librarian_list.get(selectRow))) {
					home_view.warning("Thông tin thủ thư chưa được thay đổi");
				} else {
					DAOlibrarian.getInstance().update(librarianDTO);
					librarian_list.set(selectRow, librarianDTO);
					context.loadTable(DAOlibrarian.getInstance().getAll());
					context.clearText();
					home_view.notify("Sửa thông tin thành công");
				}
			}
			return;
		}
		
		
		// Tìm kiếm thủ thư
		if(e.getSource().equals(context.refresh_btn)) {
			context.loadTable(DAOlibrarian.getInstance().getAll());
			context.tableSearch("");
			context.clearText();
		}
		
		if (e.getSource().equals(context.find_btn)) {
			context.tableSearch(context.findText.getText());
			context.findText.setText("");
		}
		
	}

	
	
	
	private void initTableControl() {
		context.table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				selectRow = context.table.getSelectedRow();
				librarian selectLibrarian =  librarian_list.get(selectRow);
				context.setText(selectLibrarian.getName(), selectLibrarian.getAddress(),
						selectLibrarian.getLogin_name(), selectLibrarian.getLogin_pw());
			}
		});
	}
}
