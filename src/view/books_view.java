package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class books_view extends JPanel {
	private JTextField textField;
	private JTextField authorText;
	private JTextField dateText;
	private JTextField nameText;
	private JTextField quanText;
	private JTable table;
	
	private Color primaryColor = new Color(155, 250, 184);
	

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
		
		dateText = new JTextField();
		dateText.setBounds(545, 39, 218, 26);
		dateText.setColumns(10);
		input_tab.add(dateText);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(166, 10, 218, 26);
		input_tab.add(nameText);
		
		quanText = new JTextField();
		quanText.setColumns(10);
		quanText.setBounds(545, 10, 218, 26);
		input_tab.add(quanText);
		
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
		
		JButton find_btn = new JButton("Tìm kiếm");
		find_btn.setBackground(new Color(247, 250, 124));
		find_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		find_btn.setPreferredSize(new Dimension(100, 30));
		find_btn.setBounds(new Rectangle(456, 0, 100, 33));
		find_tab.add(find_btn);
		
		JButton edit_btn = new JButton("Sửa");
		edit_btn.setBackground(new Color(247, 250, 124));
		edit_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edit_btn.setPreferredSize(new Dimension(100, 30));
		edit_btn.setBounds(new Rectangle(220, 5, 90, 20));
		edit_btn.setBounds(239, 87, 105, 33);
		controlView.add(edit_btn);
		
		JButton add_btn = new JButton("Thêm");
		add_btn.setBackground(new Color(247, 250, 124));
		add_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add_btn.setPreferredSize(new Dimension(100, 30));
		add_btn.setBounds(new Rectangle(30, 5, 90, 20));
		add_btn.setBounds(10, 87, 105, 33);
		controlView.add(add_btn);
		
		JButton del_btn = new JButton("Xóa");
		del_btn.setBackground(new Color(247, 250, 124));
		del_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		del_btn.setPreferredSize(new Dimension(100, 30));
		del_btn.setBounds(new Rectangle(125, 5, 90, 20));
		del_btn.setBounds(125, 87, 104, 33);
		controlView.add(del_btn);
		
		JPanel dataView = new JPanel();
		dataView.setBackground(new Color(255, 255, 255));
		add(dataView, BorderLayout.CENTER);
		dataView.setLayout(new BorderLayout(0, 0));
		
		// Tạo bảng hiển thị dữ liệu
		String column[]={"ID","Tên sách","Tác giả","NXB","Số lượng","Số lượng đang mượn"}; 
		
		table = new JTable(null, column);
		table.setBackground(primaryColor);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setBackground(primaryColor);
		
		DefaultTableModel model = new DefaultTableModel(null,column);	
		
		model.addRow(new Object[] {"11","How to become rich","Phúc Ng","29/02/2023","20","0"});
		
		table.setModel(model);
		
		dataView.add(scrollPane, BorderLayout.CENTER);
		
		
	}
}
