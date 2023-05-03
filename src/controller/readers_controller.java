package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.DAObooks;
import dao.DAOreaders;
import model.books;
import model.readers;
import view.home_view;
import view.readers_view;

public class readers_controller implements ActionListener{
	
	private String readerName;
	private String readerPhone;
	private String readerAddress;
	private readers readerDTO;
	
	readers_view context;
	ArrayList<readers> reader_list;
	private int selectRow = -1;
	
	
	public readers_controller(readers_view context) {	
		this.context = context;
		reader_list = DAOreaders.getInstance().getAll();
		context.loadTable(reader_list);
		initTableControl();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// Xử lý thêm độc giả
		if(e.getSource().equals(context.add_btn)) {	
			try {
				readerName= context.readerName.getText();
				readerPhone = context.readerPhone.getText();
				readerAddress = context.readerAddress.getText();
				
				if(readerName.isBlank() || readerPhone.isBlank() || readerAddress.isBlank()) {
					JOptionPane.showMessageDialog(context, "Vui lòng không bỏ trống thông tin", "WARN", JOptionPane.WARNING_MESSAGE);
				} else {
					readerDTO = new readers(readerName, readerPhone, readerAddress);
					DAOreaders.getInstance().insert(readerDTO);
					reader_list.add(readerDTO);				
					context.loadTable(DAOreaders.getInstance().getAll());
					context.clearText();
					home_view.notify("Thêm độc giả thành công!");
				}
			} catch (NumberFormatException e1) {	
				home_view.warning("Vui lòng không bỏ trống hoặc nhập đúng định dạng!");
				context.readerName.requestFocus();
			}
			
		}
		
		
		// Xử lý xóa độc giả
		if (e.getSource().equals(context.del_btn)) {
			
			if (selectRow != -1) {
				readerDTO = new readers();
				readerDTO.setReader_id(reader_list.get(selectRow).getReader_id());
				DAOreaders.getInstance().delete(readerDTO);
				reader_list.remove(selectRow);
				context.loadTable(reader_list);
				context.clearText();
				home_view.notify("Xóa sách thành công!");
			}
			return;
		}
		
		
		// Xử lý sửa thông tin độc giả
		if (e.getSource().equals(context.edit_btn)) {
			if (selectRow != -1) {
				
				readerDTO = new readers();
				readerDTO.setReader_id(reader_list.get(selectRow).getReader_id());
				readerDTO.setProperty(context.readerName.getText(), context.readerPhone.getText(), context.readerAddress.getText());
				
				if (readerDTO.compare(reader_list.get(selectRow))) {
					home_view.warning("Thông tin độc giả chưa được thay đổi");
				} else {
					DAOreaders.getInstance().update(readerDTO);
					reader_list.set(selectRow, readerDTO);
					context.loadTable(DAOreaders.getInstance().getAll());
					context.clearText();
					home_view.notify("Sửa thông tin thành công");
				}
			}
			return;
		}
		
		
		// Tìm kiếm độc giả
		if(e.getSource().equals(context.refresh_btn)) {
			context.loadTable(DAOreaders.getInstance().getAll());
			context.tableSearch("");
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
				readers selectReader =  reader_list.get(selectRow);
				context.setText(selectReader.getName(), selectReader.getPhone_number(),
						selectReader.getAddress());
			}
		});
	}
}
