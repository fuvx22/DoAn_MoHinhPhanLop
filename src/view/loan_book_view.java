package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.books_controller;
import controller.loan_book_controller;
import model.books;
import model.loan_book;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.ObjDoubleConsumer;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class loan_book_view extends JPanel {
	public JTextField findText;
	public JTextField readerText;
	public JTextField bookText;
	public JTextField quanText;
	public JDateChooser dateText;
	public JTable table;
	
	public Color primaryColor = new Color(155, 250, 184);
	public JPanel dataView;
	
	public JButton find_btn;
	public JButton return_btn;
	public JButton add_btn;
	public DefaultTableModel model;
	String column[]={"STT","Sách","Độc giả","Ngày mượn","Ngày trả","Số lượng"};
	private loan_book_controller control;
	public JButton renew_btn;

	/**
	 * Create the panel.
	 */
	public loan_book_view() {
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		setBounds(0, 0, 946, 663);
		
		JPanel controlView = new JPanel();
		controlView.setBackground(new Color(255, 255, 255));
		controlView.setPreferredSize(new Dimension(1, 150));
		controlView.setSize(WIDTH, 300);
		add(controlView, BorderLayout.NORTH);
		controlView.setLayout(null);
		
		JPanel input_tab = new JPanel();
		input_tab.setOpaque(false);
		input_tab.setBounds(10, 10, 926, 90);
		controlView.add(input_tab);
		input_tab.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(67, 16, 89, 16);
		input_tab.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã độc giả");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(67, 37, 89, 26);
		input_tab.add(lblNewLabel_1);
		
		readerText = new JTextField();
		readerText.setBounds(138, 41, 218, 26);
		readerText.setColumns(10);
		input_tab.add(readerText);
		
		JLabel lblNewLabel_2 = new JLabel("Số lượng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(396, 18, 89, 13);
		input_tab.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày trả");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(396, 41, 89, 26);
		input_tab.add(lblNewLabel_2_1);
		
		bookText = new JTextField();
		bookText.setColumns(10);
		bookText.setBounds(138, 12, 218, 26);
		input_tab.add(bookText);
		
		quanText = new JTextField();
		quanText.setColumns(10);
		quanText.setBounds(458, 12, 218, 26);
		input_tab.add(quanText);
		
		dateText = new JDateChooser();
		dateText.setBounds(458, 43, 218, 26);
		input_tab.add(dateText);
		
		add_btn = new JButton("Mượn sách");
		add_btn.setBounds(736, 36, 125, 33);
		input_tab.add(add_btn);
		add_btn.setBackground(new Color(247, 250, 124));
		add_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add_btn.setPreferredSize(new Dimension(100, 30));
		
		JPanel find_tab = new JPanel();
		find_tab.setOpaque(false);
		find_tab.setBounds(336, 107, 600, 33);
		controlView.add(find_tab);
		find_tab.setLayout(null);
		
		findText = new JTextField();
		findText.setHorizontalAlignment(SwingConstants.LEFT);
		findText.setBounds(24, 1, 249, 33);
		findText.setPreferredSize(new Dimension(200, 22));
		findText.setColumns(10);
		find_tab.add(findText);
		
		find_btn = new JButton("Tìm kiếm");
	
		find_btn.setBackground(new Color(247, 250, 124));
		find_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		find_btn.setPreferredSize(new Dimension(100, 30));
		find_btn.setBounds(new Rectangle(283, 0, 90, 33));
		find_tab.add(find_btn);
		
		JComboBox showOption = new JComboBox();
		showOption.setBounds(388, 1, 202, 33);
		find_tab.add(showOption);
		showOption.setEditable(true);
		
		return_btn = new JButton("Trả sách");
	
		return_btn.setBackground(new Color(247, 250, 124));
		return_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		return_btn.setPreferredSize(new Dimension(100, 30));
		return_btn.setBounds(new Rectangle(220, 5, 90, 20));
		return_btn.setBounds(20, 107, 125, 33);
		controlView.add(return_btn);
		
		renew_btn = new JButton("Gia hạn sách");

		renew_btn.setPreferredSize(new Dimension(100, 30));
		renew_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		renew_btn.setBounds(new Rectangle(220, 5, 90, 20));
		renew_btn.setBackground(new Color(247, 250, 124));
		renew_btn.setBounds(178, 107, 125, 33);
		controlView.add(renew_btn);
		
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
		
		control = new loan_book_controller(this);
		add_btn.addActionListener(control);
		return_btn.addActionListener(control);
		renew_btn.addActionListener(control);
		find_btn.addActionListener(control);
	}
	public void clearText() {
		this.bookText.setText("");
		this.quanText.setText("");
		this.readerText.setText("");
		this.dateText.setDate(null);
	}
	public void loadTable(ArrayList<loan_book> list) {
		model = new DefaultTableModel(null,column);		
		int count = 1;
		for (loan_book row : list) {
			model.addRow(new Object[] {count ,row.getBook_id(),row.getReader_id(),
					row.getLoan_date(),row.getExp_date(),row.getQuantity()});
			++count;
		}
		table.setModel(model);
	}
}
