package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class home_view extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home_view frame = new home_view();
					frame.setVisible(true);
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBackground(new Color(128, 128, 255));
		contentPane.add(sideMenu, BorderLayout.WEST);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBackground(new Color(128, 0, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBackground(new Color(128, 0, 255));
		
		JButton btnNewButton_2_2 = new JButton("New button");
		btnNewButton_2_2.setBackground(new Color(128, 0, 255));
		
		JButton btnNewButton_2_3 = new JButton("New button");
		btnNewButton_2_3.setBackground(new Color(128, 0, 255));
		
		GroupLayout gl_sideMenu = new GroupLayout(sideMenu);
		gl_sideMenu.setHorizontalGroup(
			gl_sideMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sideMenu.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_sideMenu.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2_3)
						.addComponent(btnNewButton_2_2)
						.addComponent(btnNewButton_2_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_sideMenu.setVerticalGroup(
			gl_sideMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sideMenu.createSequentialGroup()
					.addGap(32)
					.addComponent(btnNewButton_2_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2_3)
					.addContainerGap(529, Short.MAX_VALUE))
		);
		sideMenu.setLayout(gl_sideMenu);
		
		JPanel home = new JPanel();
		contentPane.add(home, BorderLayout.CENTER);
		home.setLayout(new CardLayout(0, 0));
	}
}
