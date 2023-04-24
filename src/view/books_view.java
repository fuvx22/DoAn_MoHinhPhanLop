package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.books_controller;
import model.books;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.util.ArrayList;
import java.util.logging.SimpleFormatter;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class books_view extends JPanel {
	public JTextField textField;
	public JTextField authorText;
	public JTextField nameText;
	public JTextField quanText;
	public JDateChooser dateText;
	public JTable table;
	
	public Color primaryColor = new Color(155, 250, 184);
	public JPanel dataView;
	
	public JButton find_btn;
	public JButton edit_btn;
	public JButton add_btn;
	public JComponent del_btn;
	public DefaultTableModel model;
	String column[]={"ID","Tên sách","Tác giả","NXB","Số lượng","Số lượng đang mượn"};

	/**
	 * Create the panel.
	 */
	public books_view() {
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
		
		JLabel lblNewLabel = new JLabel("Tên sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(67, 15, 89, 16);
		input_tab.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tác giả");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(67, 37, 89, 26);
		input_tab.add(lblNewLabel_1);
		
		authorText = new JTextField();
		authorText.setBounds(166, 39, 218, 26);
		authorText.setColumns(10);
		input_tab.add(authorText);
		
		JLabel lblNewLabel_2 = new JLabel("Số lượng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(446, 18, 89, 13);
		input_tab.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày xuất bản");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(446, 41, 89, 26);
		input_tab.add(lblNewLabel_2_1);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(166, 10, 218, 26);
		input_tab.add(nameText);
		
		quanText = new JTextField();
		quanText.setColumns(10);
		quanText.setBounds(545, 10, 218, 26);
		input_tab.add(quanText);
		
		dateText = new JDateChooser();
		dateText.setBounds(545, 41, 218, 24);
		input_tab.add(dateText);
		
		JPanel find_tab = new JPanel();
		find_tab.setOpaque(false);
		find_tab.setBounds(370, 87, 566, 33);
		controlView.add(find_tab);
		find_tab.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(0, 1, 446, 33);
		textField.setPreferredSize(new Dimension(200, 22));
		textField.setColumns(10);
		find_tab.add(textField);
		
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
		
		books_controller control = new books_controller(this);
		add_btn.addActionListener(control);
		
	}
	public void loadTable(ArrayList<books> list) {
		String rel_date;
		model = new DefaultTableModel(null,column);		
		for (books book : list) {
			try {
				rel_date = new SimpleDateFormat("dd/MM/yyyy").format(book.getRelease_date());
			} catch (Exception e) {
				rel_date = "NULL";
			}
			model.addRow(new Object[] {book.getBook_id(),book.getName(),
					book.getAuthor(),rel_date,book.getQuantity(),book.getBrr_quantity()});
		}
		table.setModel(model);	
	}
	public void clearText() {
		this.nameText.setText("");
		this.quanText.setText("");
		this.authorText.setText("");
		this.dateText.setDateFormatString("");
	}
}
