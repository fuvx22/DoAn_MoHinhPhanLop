package view;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import controller.renew_book_controller;
import dao.DAObooks;
import dao.DAOreaders;
import model.books;
import model.loan_book;
import model.readers;

import javax.swing.JButton;

public class renew_book_view extends JFrame {

	public JPanel contentPane;
	public JDateChooser dateText;
	public JLabel bookText;
	public JLabel readerText;
	public JLabel expDateText;
	public JButton renew_btn;
	public loan_book loan_bookDTO;
	private renew_book_controller control;

	/**
	 * Create the frame.
	 */
	public renew_book_view(loan_book loan_bookDTO) {
		this.loan_bookDTO = loan_bookDTO;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Độc giả mượn:");
		lblNewLabel.setBounds(10, 71, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sách: ");
		lblNewLabel_1.setBounds(10, 46, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHnTrC = new JLabel("Hạn trả cũ:");
		lblHnTrC.setBounds(10, 96, 75, 14);
		contentPane.add(lblHnTrC);
		
		JLabel lblHnTrMi = new JLabel("Hạn trả mới:");
		lblHnTrMi.setBounds(10, 121, 95, 14);
		contentPane.add(lblHnTrMi);
		
		dateText = new JDateChooser();
		dateText.setBounds(115, 121, 106, 20);
		contentPane.add(dateText);
		
		bookText = new JLabel("Sách: ");
		bookText.setBounds(115, 46, 95, 14);
		contentPane.add(bookText);
		
		readerText = new JLabel("Độc giả mượn:");
		readerText.setBounds(115, 71, 95, 14);
		contentPane.add(readerText);
		
		expDateText = new JLabel("Hạn trả cũ:");
		expDateText.setBounds(115, 96, 95, 14);
		contentPane.add(expDateText);
		
		renew_btn = new JButton("Gia hạn");
		renew_btn.setBounds(88, 186, 106, 23);
		contentPane.add(renew_btn);
		
		setRenewInfo();
		control = new renew_book_controller(this);
		renew_btn.addActionListener(control);
}
	private void setRenewInfo() {
		books book = DAObooks.getInstance().selectById(loan_bookDTO.getBook_id());
		readers reader = DAOreaders.getInstance().selectById(loan_bookDTO.getReader_id());
		Date expDate = loan_bookDTO.getExp_date();
		
		
		bookText.setText(book.getName());
		readerText.setText(reader.getName());
		expDateText.setText(new SimpleDateFormat("dd/MM/yyyy").format(expDate));
		
	}
	public void close() {
		this.dispose();
	}
	
	
}
