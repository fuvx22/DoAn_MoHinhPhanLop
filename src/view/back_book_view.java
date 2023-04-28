package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.back_book_controller;

import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.DAObooks;
import dao.DAOloan_book;
import dao.DAOreaders;
import model.books;
import model.loan_book;
import model.readers;

public class back_book_view extends JFrame {

	public JPanel contentPane;
	public JButton return_btn;
	public JTextField quantityText;
	public JLabel bookText;
	public JLabel readerText;
	public JLabel returnDateText;
	public loan_book loan_bookDTO;
	private back_book_controller control;

	/**
	 * Create the frame.
	 */
	public back_book_view(loan_book loan_bookDTO) {
		this.loan_bookDTO = loan_bookDTO;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 290, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 255, 207));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		return_btn = new JButton("Trả sách");
		return_btn.setBounds(74, 206, 122, 30);
		return_btn.setBackground(new Color(247, 250, 124));
		return_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		return_btn.setPreferredSize(new Dimension(100, 30));
		getContentPane().add(return_btn);
		
		JLabel lblNewLabel = new JLabel("Sách:");
		lblNewLabel.setSize(new Dimension(20, 0));
		lblNewLabel.setBounds(31, 30, 77, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblcGi = new JLabel("Độc giả:");
		lblcGi.setSize(new Dimension(20, 0));
		lblcGi.setBounds(31, 60, 77, 20);
		contentPane.add(lblcGi);
		
		JLabel lblSLngTr = new JLabel("Số lượng trả:");
		lblSLngTr.setSize(new Dimension(20, 0));
		lblSLngTr.setBounds(31, 90, 77, 20);
		contentPane.add(lblSLngTr);
		
		bookText = new JLabel("New label");
		bookText.setBounds(115, 30, 122, 20);
		contentPane.add(bookText);
		
		readerText = new JLabel("New label");
		readerText.setBounds(115, 60, 122, 20);
		contentPane.add(readerText);
		
		quantityText = new JTextField();
		quantityText.setBounds(115, 91, 56, 19);
		contentPane.add(quantityText);
		quantityText.setColumns(10);
		
		JLabel lblNgyTr = new JLabel("Ngày trả:");
		lblNgyTr.setSize(new Dimension(20, 0));
		lblNgyTr.setBounds(31, 120, 77, 20);
		contentPane.add(lblNgyTr);
		
		returnDateText = new JLabel("New label");
		returnDateText.setBounds(115, 120, 122, 20);
		contentPane.add(returnDateText);
		
		control = new back_book_controller(this);
		
		return_btn.addActionListener(control);
		setReturnInfo();
		
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	private void setReturnInfo() {
		books book = DAObooks.getInstance().selectById(loan_bookDTO.getBook_id());
		readers reader = DAOreaders.getInstance().selectById(loan_bookDTO.getReader_id());
		
		bookText.setText(book.getName());
		readerText.setText(reader.getName());
		String rtDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		returnDateText.setText(rtDate);	
	}
	public void close() {
		this.dispose();
	}
}
