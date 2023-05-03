package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.readers_controller;
import model.readers;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.util.ArrayList;
import java.util.Date;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class readers_view extends JPanel {
	public JTextField readerPhone;
	public JTextField readerName;
	public JTextField readerAddress;
	public JTable table;
	
	public Color primaryColor = new Color(155, 250, 184);
	public JPanel dataView;
	
	public JButton find_btn;
	public JButton edit_btn;
	public JButton add_btn;
	public JButton del_btn;
	public DefaultTableModel model;
	String column[]={"ID","Tên độc giả","Số điện thoại","Địa chỉ"};
	private readers_controller controller;
	public JButton refresh_btn;
	public JTextField findText;

	/**
	 * Create the panel.
	 */
	
	
	public readers_view() {
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
		
		JLabel lblNewLabel = new JLabel("Tên độc giả");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(67, 15, 89, 16);
		input_tab.add(lblNewLabel);
		
		readerPhone = new JTextField();
		readerPhone.setBounds(166, 39, 218, 26);
		readerPhone.setColumns(10);
		input_tab.add(readerPhone);
		
		JLabel lblNewLabel_1 = new JLabel("Số điện thoại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(67, 37, 89, 26);
		input_tab.add(lblNewLabel_1);
		
		readerName = new JTextField();
		readerName.setColumns(10);
		readerName.setBounds(166, 10, 218, 26);
		input_tab.add(readerName);
		
		JLabel lblNewLabel_2 = new JLabel("Địa chỉ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(446, 18, 89, 13);
		input_tab.add(lblNewLabel_2);
		
		readerAddress = new JTextField();
		readerAddress.setColumns(10);
		readerAddress.setBounds(545, 10, 324, 26);
		input_tab.add(readerAddress);
		
		
		
		JPanel find_tab = new JPanel();
		find_tab.setOpaque(false);
		find_tab.setBounds(370, 87, 566, 33);
		controlView.add(find_tab);
		find_tab.setLayout(null);
		
		findText = new JTextField();
		findText.setPreferredSize(new Dimension(200, 22));
		findText.setHorizontalAlignment(SwingConstants.LEFT);
		findText.setColumns(10);
		findText.setBounds(0, 0, 360, 33);
		find_tab.add(findText);
		
		find_btn = new JButton("Tìm kiếm");
		find_btn.setBackground(new Color(247, 250, 124));
		find_btn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		find_btn.setPreferredSize(new Dimension(100, 30));
		find_btn.setBounds(new Rectangle(365, 0, 100, 33));
		find_tab.add(find_btn);
		
		refresh_btn = new JButton("Làm mới");
		refresh_btn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		refresh_btn.setBackground(new Color(247, 250, 124));
		refresh_btn.setBounds(467, 0, 100, 33);
		find_tab.add(refresh_btn);
		
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
		//table.setEnabled(false);
		table.setBackground(new Color(208, 253, 218));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setBackground(primaryColor);	
		dataView.add(scrollPane, BorderLayout.CENTER);
		
	
		controller = new readers_controller(this);
		add_btn.addActionListener(controller);
		del_btn.addActionListener(controller);
		edit_btn.addActionListener(controller);
		find_btn.addActionListener(controller);
		refresh_btn.addActionListener(controller);
		
	}
	public void loadTable(ArrayList<readers> list) {
		model = new DefaultTableModel(null,column);		
		for (readers reader : list) {
			model.addRow(new Object[] {
					reader.getReader_id(),
					reader.getName(),
					reader.getPhone_number(),
					reader.getAddress(),
			});
		}
		table.setModel(model);	
	}
	public void clearText() {
		this.readerPhone.setText("");
		this.readerName.setText("");
		this.readerAddress.setText("");
	}
	
	public void setText(String name, String phonenumber, String address) {
		this.readerName.setText(name);
		this.readerPhone.setText(phonenumber);
		this.readerAddress.setText(address);
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
