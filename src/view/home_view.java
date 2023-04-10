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
	private CardLayout card;
	public int x = 1;
	private JLabel home_btn;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBounds(0, 0, 141, 663);
		sideMenu.setMinimumSize(new Dimension(300, 10));
		sideMenu.setBackground(new Color(128, 128, 255));
		contentPane.add(sideMenu);
		
		sideMenu.setLayout(null);
		
		home_btn = new JLabel("Trang chủ");
		
		home_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		home_btn.setForeground(new Color(255, 255, 255));
		home_btn.setBounds(10, 11, 131, 35);
		home_btn.setName("home_btn");
		sideMenu.add(home_btn);
		
		
		
		JLabel book_btn = new JLabel("Quản lý sách");
		book_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		book_btn.setForeground(new Color(255, 255, 255));
		book_btn.setBounds(10, 57, 131, 35);
		book_btn.setName("book_btn");
		sideMenu.add(book_btn);
		
		JLabel reader_btn = new JLabel("Quản lý độc giả");
		reader_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		reader_btn.setForeground(new Color(255, 255, 255));
		reader_btn.setBounds(10, 103, 131, 35);
		reader_btn.setName("reader_btn");
		sideMenu.add(reader_btn);
		
		JLabel loan_btn = new JLabel("Quản lý mượn sách");
		loan_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		loan_btn.setForeground(new Color(255, 255, 255));
		loan_btn.setBounds(10, 149, 131, 35);
		loan_btn.setName("loan_btn");
		sideMenu.add(loan_btn);
		
		JLabel back_btn = new JLabel("Quản lý trả sách");
		back_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		back_btn.setForeground(new Color(255, 255, 255));
		back_btn.setBounds(10, 195, 131, 35);
		back_btn.setName("back_btn");
		sideMenu.add(back_btn);
		
		JLabel stat_btn = new JLabel("Thống kê");
		stat_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		stat_btn.setForeground(new Color(255, 255, 255));
		stat_btn.setBounds(10, 241, 131, 35);
		stat_btn.setName("stat_btn");
		sideMenu.add(stat_btn);
		
		JLabel logout_btn = new JLabel("Đăng xuất");
		logout_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		logout_btn.setForeground(new Color(255, 255, 255));
		logout_btn.setBounds(10, 615, 131, 35);
		logout_btn.setName("logout_btn");
		sideMenu.add(logout_btn);
		
		JLabel lib_btn = new JLabel("Quản lý thủ thư");
		lib_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lib_btn.setForeground(new Color(255, 255, 255));
		lib_btn.setBounds(10, 569, 131, 35);
		lib_btn.setName("lib_btn");
		sideMenu.add(lib_btn);
		
		
		mainPanel = new JPanel();
		mainPanel.setBounds(140, 0, 946, 663);
		contentPane.add(mainPanel);
		
		card = new CardLayout(0, 0);
		mainPanel.setLayout(card);
		
		home_panel = new JPanel();
		home_panel.setBackground(new Color(128, 255, 128));
		mainPanel.add(home_panel, "home_btn");
		
		book_panel = new JPanel();
		book_panel.setBackground(new Color(128, 255, 0));
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
		
		panelList = new ArrayList<>();
		
		panelList.add(home_panel);
		panelList.add(book_panel);
		panelList.add(reader_panel);
		panelList.add(loan_panel);
		panelList.add(back_panel);
		panelList.add(stat_panel);
		panelList.add(lib_panel);
		
		
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
