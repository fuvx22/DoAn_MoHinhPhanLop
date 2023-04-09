package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class books_view extends JPanel {
	private JTextField textName;
	private JTextField textAuthor;
	private JTextField textQuan;
	private JTextField textNXB;

	/**
	 * Create the panel.
	 */
	public books_view() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel inputTab = new JPanel();
		inputTab.setPreferredSize(new Dimension(WIDTH, 150));
		inputTab.setSize(WIDTH, 300);
		add(inputTab, BorderLayout.NORTH);
		inputTab.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên sách");
		lblNewLabel.setBounds(10, 10, 82, 22);
		inputTab.add(lblNewLabel);
		
		textName = new JTextField();
		textName.setBounds(102, 12, 113, 20);
		inputTab.add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tác giả");
		lblNewLabel_1.setBounds(10, 42, 82, 22);
		inputTab.add(lblNewLabel_1);
		
		textAuthor = new JTextField();
		textAuthor.setColumns(10);
		textAuthor.setBounds(102, 44, 113, 20);
		inputTab.add(textAuthor);
		
		JLabel lblNewLabel_2 = new JLabel("Số lượng");
		lblNewLabel_2.setBounds(227, 42, 82, 22);
		inputTab.add(lblNewLabel_2);
		
		textQuan = new JTextField();
		textQuan.setColumns(10);
		textQuan.setBounds(319, 44, 113, 20);
		inputTab.add(textQuan);
		
		textNXB = new JTextField();
		textNXB.setColumns(10);
		textNXB.setBounds(319, 12, 113, 20);
		inputTab.add(textNXB);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày xuất bản");
		lblNewLabel_2_1.setBounds(227, 10, 82, 22);
		inputTab.add(lblNewLabel_2_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 88, 723, 62);
		inputTab.add(panel);
		
		JPanel dataView = new JPanel();
		add(dataView, BorderLayout.CENTER);

	}
}
