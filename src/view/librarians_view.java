package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.books_controller;
import controller.librarian_controller;
import model.books;
import model.librarian;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class librarians_view extends JPanel {
	public JTextField findText;
	public JTextField addressText;
	public JTextField nameText;
	public JTextField userText;
	public JTextField passwordText;
	public JTable table;
	
	public Color primaryColor = new Color(155, 250, 184);
	public JPanel dataView;
	
	public JButton find_btn;
	public JButton edit_btn;
	public JButton add_btn;
	public JButton del_btn;
	public DefaultTableModel model;
	String column[]={"ID","Tên thủ thư","Địa chỉ","Username","Password"};
	private librarian_controller control;
	public JButton refresh_btn;
	

	/**
	 * Create the panel.
	 */
	public librarians_view() {
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 10));
		setBounds(0, 0, 946, 663);
		
		JPanel controlView = new JPanel();
		controlView.setBackground(new Color(255, 255, 255));
		controlView.setPreferredSize(new Dimension(1, 120));
		controlView.setSize(WIDTH, 300);
		add(controlView, BorderLayout.NORTH);
		controlView.setLayout(null);
		
		JPanel input_tab = new JPanel();
		input_tab.setOpaque(false);
		input_tab.setBounds(10, 10, 926, 67);
		controlView.add(input_tab);
		input_tab.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên thủ thư");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(67, 15, 89, 16);
		input_tab.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Địa chỉ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(67, 37, 89, 26);
		input_tab.add(lblNewLabel_1);
		
		addressText = new JTextField();
		addressText.setBounds(166, 39, 218, 26);
		addressText.setColumns(10);
		input_tab.add(addressText);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(446, 18, 89, 13);
		input_tab.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(446, 41, 89, 26);
		input_tab.add(lblNewLabel_2_1);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(166, 10, 218, 26);
		input_tab.add(nameText);
		
		userText = new JTextField();
		userText.setColumns(10);
		userText.setBounds(545, 10, 218, 26);
		input_tab.add(userText);
		
		passwordText = new JTextField();
		passwordText.setBounds(545, 38, 218, 26);
		input_tab.add(passwordText);
		passwordText.setColumns(10);
		
		refresh_btn = new JButton("làm mới");
		refresh_btn.setPreferredSize(new Dimension(100, 30));
		refresh_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		refresh_btn.setBounds(new Rectangle(220, 5, 90, 20));
		refresh_btn.setBackground(new Color(247, 250, 124));
		refresh_btn.setBounds(829, 41, 76, 26);
		input_tab.add(refresh_btn);
		
		JPanel find_tab = new JPanel();
		find_tab.setOpaque(false);
		find_tab.setBounds(370, 87, 566, 33);
		controlView.add(find_tab);
		find_tab.setLayout(null);
		
		findText = new JTextField();
		findText.setHorizontalAlignment(SwingConstants.LEFT);
		findText.setBounds(0, 1, 446, 33);
		findText.setPreferredSize(new Dimension(200, 22));
		findText.setColumns(10);
		find_tab.add(findText);
		
		find_btn = new JButton("Tìm kiếm");
		find_btn.setBackground(new Color(247, 250, 124));
		find_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		find_btn.setPreferredSize(new Dimension(100, 30));
		find_btn.setBounds(new Rectangle(456, 0, 100, 33));
		find_tab.add(find_btn);
		
		edit_btn = new JButton("Sửa");
		edit_btn.setBackground(new Color(247, 250, 124));
		edit_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edit_btn.setPreferredSize(new Dimension(100, 30));
		edit_btn.setBounds(new Rectangle(220, 5, 90, 20));
		edit_btn.setBounds(239, 87, 105, 33);
		controlView.add(edit_btn);
		
		add_btn = new JButton("Thêm");
		add_btn.setBackground(new Color(247, 250, 124));
		add_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add_btn.setPreferredSize(new Dimension(100, 30));
		add_btn.setBounds(new Rectangle(30, 5, 90, 20));
		add_btn.setBounds(10, 87, 105, 33);
		controlView.add(add_btn);
		
		del_btn = new JButton("Xóa");
		del_btn.setBackground(new Color(247, 250, 124));
		del_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		del_btn.setPreferredSize(new Dimension(100, 30));
		del_btn.setBounds(new Rectangle(125, 5, 90, 20));
		del_btn.setBounds(125, 87, 104, 33);
		controlView.add(del_btn);
		
		dataView = new JPanel();
		dataView.setBackground(new Color(255, 255, 255));
		add(dataView, BorderLayout.CENTER);
		dataView.setLayout(new BorderLayout(0, 0));
		
		// Tạo bảng hiển thị dữ liệu
		 
		
		table = new JTable();
		table.setBackground(new Color(208, 253, 218));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setBackground(primaryColor);	
		dataView.add(scrollPane, BorderLayout.CENTER);
		
		control = new librarian_controller(this);
		
		add_btn.addActionListener(control);
		del_btn.addActionListener(control);
		edit_btn.addActionListener(control);
		find_btn.addActionListener(control);
		refresh_btn.addActionListener(control);
		
	}
	public void loadTable(ArrayList<librarian> list) {
		model = new DefaultTableModel(null,column);		
		for (librarian l : list) {
			model.addRow(new Object[] {l.getId() ,l.getName(), l.getAddress(), l.getLogin_name(), l.getLogin_pw()});
		}
		table.setModel(model);	
	}
	public void clearText() {
		this.nameText.setText("");
		this.userText.setText("");
		this.addressText.setText("");
		this.passwordText.setText("");
	}
	public void setText(String librarianName, String librarianAddress, String username, String password) {
		this.nameText.setText(librarianName);
		this.addressText.setText(librarianAddress);
		this.userText.setText(username);
		this.passwordText.setText(password);
	}
	public void tableSearch(String text) {
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		
		if (text.trim().length() == 0) {
			sorter.setRowFilter(null);
		} else {
			ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
			sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		}
	}
}
