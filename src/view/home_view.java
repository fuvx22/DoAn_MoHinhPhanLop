package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.homeView_controller;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class home_view extends JFrame {

	private JPanel contentPane;
	ArrayList<JPanel> panelList;
	private JPanel mainPanel;
	private JPanel home_panel;
	private JPanel book_panel;
	private JPanel reader_panel;
	private JPanel loan_panel;
	private JPanel back_panel;
	private JPanel stat_panel;
	private JPanel lib_panel;
	private JLabel home_btn;
	private CardLayout card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home_view frame = new home_view();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public home_view() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBounds(0, 0, 134, 663);
		sideMenu.setMinimumSize(new Dimension(300, 10));
		sideMenu.setBackground(new Color(50, 201, 96));
		contentPane.add(sideMenu);
		
		sideMenu.setLayout(null);
		
		home_btn = new JLabel("Trang chủ");
		home_btn.setHorizontalAlignment(SwingConstants.LEFT);
		
		home_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		home_btn.setForeground(new Color(255, 255, 255));
		home_btn.setBounds(0, 11, 141, 35);
		home_btn.setName("home_btn");
		sideMenu.add(home_btn);
		
		
		
		JLabel book_btn = new JLabel("Quản lý sách");
		book_btn.setHorizontalAlignment(SwingConstants.LEFT);
		book_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		book_btn.setForeground(new Color(255, 255, 255));
		book_btn.setBounds(0, 57, 141, 35);
		book_btn.setName("book_btn");
		sideMenu.add(book_btn);
		
		JLabel reader_btn = new JLabel("Quản lý độc giả");
		reader_btn.setHorizontalAlignment(SwingConstants.LEFT);
		reader_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		reader_btn.setForeground(new Color(255, 255, 255));
		reader_btn.setBounds(0, 103, 141, 35);
		reader_btn.setName("reader_btn");
		sideMenu.add(reader_btn);
		
		JLabel loan_btn = new JLabel("Quản lý mượn sách");
		loan_btn.setHorizontalAlignment(SwingConstants.LEFT);
		loan_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		loan_btn.setForeground(new Color(255, 255, 255));
		loan_btn.setBounds(0, 149, 141, 35);
		loan_btn.setName("loan_btn");
		sideMenu.add(loan_btn);
		
		JLabel back_btn = new JLabel("Quản lý trả sách");
		back_btn.setHorizontalAlignment(SwingConstants.LEFT);
		back_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		back_btn.setForeground(new Color(255, 255, 255));
		back_btn.setBounds(0, 195, 141, 35);
		back_btn.setName("back_btn");
		sideMenu.add(back_btn);
		
		JLabel stat_btn = new JLabel("Thống kê");
		stat_btn.setHorizontalAlignment(SwingConstants.LEFT);
		stat_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		stat_btn.setForeground(new Color(255, 255, 255));
		stat_btn.setBounds(0, 241, 141, 35);
		stat_btn.setName("stat_btn");
		sideMenu.add(stat_btn);
		
		JLabel logout_btn = new JLabel("Đăng xuất");
		logout_btn.setHorizontalAlignment(SwingConstants.LEFT);
		logout_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		logout_btn.setForeground(new Color(255, 255, 255));
		logout_btn.setBounds(0, 615, 141, 35);
		logout_btn.setName("logout_btn");
		sideMenu.add(logout_btn);
		
		JLabel lib_btn = new JLabel("Quản lý thủ thư");
		lib_btn.setHorizontalAlignment(SwingConstants.LEFT);
		lib_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lib_btn.setForeground(new Color(255, 255, 255));
		lib_btn.setBounds(0, 569, 141, 35);
		lib_btn.setName("lib_btn");
		sideMenu.add(lib_btn);
		
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(240, 240, 240));
		mainPanel.setBounds(144, 10, 932, 643);
		contentPane.add(mainPanel);
		
		card = new CardLayout(0, 0);
		mainPanel.setLayout(card);
		
		// Thêm panel vào các tab 
		
		home_panel = new JPanel();
		home_panel.setBackground(new Color(04, 67, 78));
		mainPanel.add(home_panel, "home_btn");
		
		book_panel = new books_view();

		mainPanel.add(book_panel, "book_btn");
		
		reader_panel = new JPanel();
		reader_panel.setBackground(new Color(0, 255, 0));
		mainPanel.add(reader_panel, "reader_btn");
		
		loan_panel = new JPanel();
		loan_panel.setBackground(new Color(0, 128, 0));
		mainPanel.add(loan_panel, "loan_btn");
		
		back_panel = new JPanel();
		back_panel.setBackground(new Color(0, 64, 0));
		mainPanel.add(back_panel, "back_btn");
		
		stat_panel = new JPanel();
		stat_panel.setBackground(new Color(128, 128, 64));
		mainPanel.add(stat_panel, "stat_btn");
		
		lib_panel = new JPanel();
		lib_panel.setBackground(new Color(0, 128, 128));
		mainPanel.add(lib_panel, "lib_btn");
		
		homeView_controller control = new homeView_controller(this);
		
		home_btn.addMouseListener(control);
		book_btn.addMouseListener(control);
		reader_btn.addMouseListener(control);
		loan_btn.addMouseListener(control);
		back_btn.addMouseListener(control);
		stat_btn.addMouseListener(control);
		logout_btn.addMouseListener(control);
		lib_btn.addMouseListener(control);
			
	}

	public void changePanel(String name) {
		card.show(mainPanel, name);
	}

	public void hoverEffect(JLabel label) {
//		if(label.getText() == home_btn.getText()) {
//			home_btn.setBackground(Color.YELLOW);
//			System.out.println("hi");
//			label.setOpaque(true);
//		}
	}
}