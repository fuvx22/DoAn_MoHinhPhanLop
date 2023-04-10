package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import view.home_view;

public class homeView_controller implements MouseListener{
	
	private home_view view;
	
	public  homeView_controller(home_view v) {
		view = v;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		view.changePanel(e.getComponent().getName());
		
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
		view.hoverEffect((JLabel) e.getComponent());
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		view.hoverEffect((JLabel) e.getComponent());
	}

}
