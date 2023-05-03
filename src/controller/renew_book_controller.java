package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import dao.DAOback_book;
import dao.DAObooks;
import dao.DAOloan_book;
import model.back_book;
import model.loan_book;
import resource.converter;
import view.back_book_view;
import view.home_view;
import view.renew_book_view;

public class renew_book_controller implements ActionListener{

	renew_book_view context;
	private Date renewDate;
	
	public renew_book_controller(renew_book_view _context) {
		this.context = _context;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(context.renew_btn)) {
			
			renewDate = context.dateText.getDate();
			
			if (renewDate == null) return;
			
			if (context.loan_bookDTO.getExp_date().compareTo(renewDate) < 0) {		
				context.loan_bookDTO.setExp_date(converter.toSQLDate(renewDate));
				DAOloan_book.getInstance().update(context.loan_bookDTO);
				
				context.dispose();
				home_view.notify("Gia hạn sách thành công");
			} else {
				home_view.warning("Ngày gia hạn không được bé hơn hạn trả cũ!");
			}
		}
		
	}

}
