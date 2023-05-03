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
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Transparency;

public class home_view extends JFrame {

	private JPanel contentPane;
	ArrayList<JPanel> panelList;
	private JPanel mainPanel;
	private JPanel book_panel;
	private JPanel reader_panel;
	private JPanel loan_panel;
	private JPanel stat_panel;
	private JPanel lib_panel;
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel sideMenu = new JPanel();
		sideMenu.setPreferredSize(new Dimension(150, 10));
		sideMenu.setBackground(new Color(50, 201, 96));
		contentPane.add(sideMenu, BorderLayout.WEST);		
		sideMenu.setLayout(null);
	
		JLabel book_btn = new JLabel("Quản lý sách");
		book_btn.setPreferredSize(new Dimension(150, 0));
		book_btn.setHorizontalAlignment(SwingConstants.LEFT);
		book_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		book_btn.setForeground(new Color(255, 255, 255));
		book_btn.setBounds(0, 60, 150, 35);
		book_btn.setName("book_btn");
		sideMenu.add(book_btn);
		
		JLabel reader_btn = new JLabel("Quản lý độc giả");
		reader_btn.setPreferredSize(new Dimension(150, 0));
		reader_btn.setHorizontalAlignment(SwingConstants.LEFT);
		reader_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		reader_btn.setForeground(new Color(255, 255, 255));
		reader_btn.setBounds(0, 130, 150, 35);
		reader_btn.setName("reader_btn");
		sideMenu.add(reader_btn);
		
		JLabel loan_btn = new JLabel("Quản lý mượn sách");
		loan_btn.setPreferredSize(new Dimension(150, 0));
		loan_btn.setHorizontalAlignment(SwingConstants.LEFT);
		loan_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		loan_btn.setForeground(new Color(255, 255, 255));
		loan_btn.setBounds(0, 95, 150, 35);
		loan_btn.setName("loan_btn");
		sideMenu.add(loan_btn);
		
		JLabel stat_btn = new JLabel("Thống kê");
		stat_btn.setPreferredSize(new Dimension(150, 0));
		stat_btn.setHorizontalAlignment(SwingConstants.LEFT);
		stat_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		stat_btn.setForeground(new Color(255, 255, 255));
		stat_btn.setBounds(0, 165, 150, 35);
		stat_btn.setName("stat_btn");
		sideMenu.add(stat_btn);
		
		JLabel logout_btn = new JLabel("Đăng xuất");
		logout_btn.setPreferredSize(new Dimension(150, 0));
		logout_btn.setHorizontalAlignment(SwingConstants.LEFT);
		logout_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		logout_btn.setForeground(new Color(255, 255, 255));
		logout_btn.setBounds(0, 615, 150, 35);
		logout_btn.setName("logout_btn");
		sideMenu.add(logout_btn);
		
		JLabel lib_btn = new JLabel("Quản lý thủ thư");
		lib_btn.setPreferredSize(new Dimension(150, 0));
		lib_btn.setHorizontalAlignment(SwingConstants.LEFT);
		lib_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lib_btn.setForeground(new Color(255, 255, 255));
		lib_btn.setBounds(0, 580, 150, 35);
		lib_btn.setName("lib_btn");
		sideMenu.add(lib_btn);
		
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(240, 240, 240));
		contentPane.add(mainPanel);
		
		card = new CardLayout(0, 0);
		mainPanel.setLayout(card);
		
		book_panel = new books_view();
		mainPanel.add(book_panel, "book_btn");
		
		reader_panel = new readers_view();
		mainPanel.add(reader_panel, "reader_btn");
		
		loan_panel = new loan_book_view();
		mainPanel.add(loan_panel, "loan_btn");
		
		stat_panel = new JPanel();
		stat_panel.setBackground(new Color(128, 128, 64));
		mainPanel.add(stat_panel, "stat_btn");
		
		lib_panel = new librarians_view();
		mainPanel.add(lib_panel, "lib_btn");
		
		homeView_controller control = new homeView_controller(this);
		book_btn.addMouseListener(control);
		reader_btn.addMouseListener(control);
		loan_btn.addMouseListener(control);
		stat_btn.addMouseListener(control);
		logout_btn.addMouseListener(control);
		lib_btn.addMouseListener(control);
			
	}

	public void changePanel(String name) {
		card.show(mainPanel, name);
	}

	public void hoverEffect(JLabel source) {
		source.setOpaque(true);
		source.setBackground(new Color(20, 181, 69));
	}

	public void exitHover(JLabel source) {
		source.setBackground(new Color(50, 201, 96));
	}
	public static void warning(String message) {
		JOptionPane.showMessageDialog(null,message,"LƯU Ý!!!",
		        JOptionPane.WARNING_MESSAGE);
	}
	public static void notify(String message) {
		JOptionPane.showMessageDialog(null,message,"thông báo",
		        JOptionPane.PLAIN_MESSAGE);
	}
}
