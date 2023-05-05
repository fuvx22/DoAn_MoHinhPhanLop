package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import test.test;
import view.home_view;
import view.login_view;

public class homeView_controller implements MouseListener{
	
	private home_view view;
	
	public  homeView_controller(home_view v) {
		view = v;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	view.changePanel(e.getComponent().getName());
	
	if (e.getSource().equals(view.logout_btn)) {
			
			int dialogResult = JOptionPane.showConfirmDialog 
					(view, "Bạn muốn đăng xuất?","Cảnh báo",JOptionPane.YES_NO_OPTION);
			
			if(dialogResult == 0){
				view.dispose();
				test.rerun();
			} else {
				return;
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		view.hoverEffect((JLabel) e.getSource());
	}
	@Override
	public void mouseExited(MouseEvent e) {
		view.exitHover((JLabel) e.getSource());
	}

}
