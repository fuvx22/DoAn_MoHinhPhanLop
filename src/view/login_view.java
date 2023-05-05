package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.login_controller;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class login_view extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField userNameText;
	private JTextField passwordText;

	private JLabel lblMtKhu;
	private JLabel logo;
	private JLabel thongbaoloi;
	public JButton btn;

	/**
	 * Create the frame.
	 */
	public login_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(179, 255, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn = new JButton("Đăng nhập");
		btn.setForeground(new Color(255, 255, 255));
		btn.setBackground(new Color(0, 128, 0));
		btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn.setBounds(33, 280, 216, 23);
		contentPane.add(btn);
		
		userNameText = new JTextField();
		userNameText.setBounds(33, 192, 216, 20);
		contentPane.add(userNameText);
		userNameText.setColumns(10);
		
		lblNewLabel = new JLabel("Tên đăng nhập:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(33, 175, 97, 14);
		contentPane.add(lblNewLabel);
		
		passwordText = new JTextField();
		passwordText.setColumns(10);
		passwordText.setBounds(33, 240, 216, 20);
		contentPane.add(passwordText);
		
		lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMtKhu.setBounds(33, 223, 97, 14);
		contentPane.add(lblMtKhu);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(login_view.class.getResource("/resource/logo.png")));
		logo.setBounds(90, 57, 103, 107);
		contentPane.add(logo);
		
		thongbaoloi = new JLabel("Thông tin đăng nhập không hợp lệ!");
		thongbaoloi.setVisible(false);
		thongbaoloi.setForeground(new Color(255, 0, 0));
		thongbaoloi.setHorizontalAlignment(SwingConstants.CENTER);
		thongbaoloi.setBounds(33, 262, 216, 14);
		contentPane.add(thongbaoloi);
		
		login_controller control = new login_controller(this);
		btn.addActionListener(control);
		getRootPane().setDefaultButton(btn);

	}
	public String getUserName() {
		return userNameText.getText();
	}
	public String getPassword() {
		return passwordText.getText();
	}
	public void showThongBaoLoi() {
		this.thongbaoloi.setVisible(true);
		userNameText.selectAll();
		userNameText.requestFocus();
		
		TimerTask task = new TimerTask() {

			public void run() {
				thongbaoloi.setVisible(false);
				
			}
			
		};
		Timer timer = new Timer();
		long delay = 3000L;
		timer.schedule(task, delay);
	}
}
