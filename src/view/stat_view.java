package view;

import javax.swing.JPanel;

import dao.DAOback_book;
import dao.DAObooks;
import dao.DAOreaders;
import model.back_book;
import model.books;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class stat_view extends JPanel {

	private JLabel sachText;
	private JLabel userText;
	private JLabel muonText;
	private JLabel traText;

	/**
	 * Create the panel.
	 */
	public stat_view() {
		setBackground(new Color(255, 255, 191));
		setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel tongSach = new JPanel();
		tongSach.setOpaque(false);
		add(tongSach);
		tongSach.setLayout(new BorderLayout(70, 70));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		tongSach.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 70));
		
		JLabel lblNewLabel = new JLabel("Tổng số sách:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		sachText = new JLabel("New label");
		sachText.setFont(new Font("Tahoma", Font.BOLD, 14));
		sachText.setForeground(new Color(255, 255, 255));
		panel.add(sachText);
		
		JPanel panel_2_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2_1.getLayout();
		flowLayout_1.setVgap(0);
		panel_2_1.setOpaque(false);
		tongSach.add(panel_2_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setPreferredSize(new Dimension(46, 23));
		panel_2_1.add(lblNewLabel_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setOpaque(false);
		tongSach.add(panel_2_2, BorderLayout.SOUTH);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setOpaque(false);
		tongSach.add(panel_2_3, BorderLayout.WEST);
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.setOpaque(false);
		tongSach.add(panel_2_4, BorderLayout.EAST);
		
		JPanel tongUser = new JPanel();
		tongUser.setOpaque(false);
		add(tongUser);
		tongUser.setLayout(new BorderLayout(70, 70));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 0));
		tongUser.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 70));
		
		JLabel lblNewLabel_2 = new JLabel("Tổng độc giả:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_2);
		
		userText = new JLabel("New label");
		userText.setFont(new Font("Tahoma", Font.BOLD, 14));
		userText.setForeground(new Color(255, 255, 255));
		panel_1.add(userText);
		
		JPanel panel_2_1_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2_1_1.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setVgap(0);
		flowLayout.setAlignment(FlowLayout.TRAILING);
		panel_2_1_1.setOpaque(false);
		tongUser.add(panel_2_1_1, BorderLayout.NORTH);
		
		JButton refresh_btn = new JButton("Làm mới");
		
		refresh_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		refresh_btn.setForeground(new Color(255, 179, 217));
		refresh_btn.setBackground(new Color(255, 0, 128));
		panel_2_1_1.add(refresh_btn);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setOpaque(false);
		tongUser.add(panel_2_2_1, BorderLayout.EAST);
		
		JPanel panel_2_3_1 = new JPanel();
		panel_2_3_1.setOpaque(false);
		tongUser.add(panel_2_3_1, BorderLayout.WEST);
		
		JPanel panel_2_4_1 = new JPanel();
		panel_2_4_1.setOpaque(false);
		tongUser.add(panel_2_4_1, BorderLayout.SOUTH);
		
		JPanel tongMuon = new JPanel();
		tongMuon.setOpaque(false);
		add(tongMuon);
		tongMuon.setLayout(new BorderLayout(70, 70));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(128, 0, 255));
		tongMuon.add(panel_1_1, BorderLayout.CENTER);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 70));
		
		JLabel lblNewLabel_2_1 = new JLabel("Tổng đang mượn:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1_1.add(lblNewLabel_2_1);
		
		muonText = new JLabel("New label");
		muonText.setForeground(Color.WHITE);
		muonText.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1_1.add(muonText);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setOpaque(false);
		tongMuon.add(panel_2_1_1_1, BorderLayout.SOUTH);
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setOpaque(false);
		tongMuon.add(panel_2_2_1_1, BorderLayout.WEST);
		
		JPanel panel_2_3_1_1 = new JPanel();
		panel_2_3_1_1.setOpaque(false);
		tongMuon.add(panel_2_3_1_1, BorderLayout.EAST);
		
		JPanel panel_2_4_1_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2_4_1_1.getLayout();
		flowLayout_2.setVgap(0);
		panel_2_4_1_1.setOpaque(false);
		tongMuon.add(panel_2_4_1_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setPreferredSize(new Dimension(46, 23));
		panel_2_4_1_1.add(lblNewLabel_1_1);
		
		JPanel tongTra = new JPanel();
		tongTra.setOpaque(false);
		add(tongTra);
		tongTra.setLayout(new BorderLayout(70, 70));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(64, 128, 128));
		tongTra.add(panel_1_2, BorderLayout.CENTER);
		panel_1_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 70));
		
		JLabel lblNewLabel_2_2 = new JLabel("Tổng đã trả:");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1_2.add(lblNewLabel_2_2);
		
		traText = new JLabel("New label");
		traText.setForeground(Color.WHITE);
		traText.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1_2.add(traText);
		
		JPanel panel_2_1_1_2 = new JPanel();
		panel_2_1_1_2.setOpaque(false);
		tongTra.add(panel_2_1_1_2, BorderLayout.SOUTH);
		
		JPanel panel_2_2_1_2 = new JPanel();
		panel_2_2_1_2.setOpaque(false);
		tongTra.add(panel_2_2_1_2, BorderLayout.WEST);
		
		JPanel panel_2_3_1_2 = new JPanel();
		panel_2_3_1_2.setOpaque(false);
		tongTra.add(panel_2_3_1_2, BorderLayout.EAST);
		
		JPanel panel_2_4_1_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2_4_1_2.getLayout();
		flowLayout_3.setVgap(0);
		panel_2_4_1_2.setOpaque(false);
		tongTra.add(panel_2_4_1_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setPreferredSize(new Dimension(46, 23));
		panel_2_4_1_2.add(lblNewLabel_1_2);
		
		controller();
		
		refresh_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller();
			}
		});
		
	}
	public void setText(int book, int user, int muon, int tra) {
		this.sachText.setText(book+"");
		this.userText.setText(user+"");
		this.muonText.setText(muon+"");
		this.traText.setText(tra+"");
	}
	public void controller() {
		int soLuongSach = 0;
		int soLuongUser = 0;
		int soLuongDangMuon = 0;
		int soLuongDaTra = 0;
		
		soLuongUser = DAOreaders.getInstance().getAll().size();
		for ( books book : DAObooks.getInstance().getAll()) {
					soLuongSach += book.getQuantity();
					soLuongDangMuon += book.getBrr_quantity();
		}
		for ( back_book b : DAOback_book.getInstance().getAll()) {
			soLuongDaTra += b.getQuantity();
		}
		
		setText(soLuongSach, soLuongUser, soLuongDangMuon, soLuongDaTra);
	}
}
