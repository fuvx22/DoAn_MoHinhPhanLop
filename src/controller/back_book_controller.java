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

public class back_book_controller implements ActionListener{

	back_book_view context;
	back_book DTO;
	
	public back_book_controller(back_book_view _context) {
		this.context = _context;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(context.return_btn)) {
			try {
				int bookID = context.loan_bookDTO.getBook_id();
				int readerID = context.loan_bookDTO.getReader_id();
				int brQuantity = context.loan_bookDTO.getQuantity();
				int returnQuantity = Integer.valueOf(context.quantityText.getText());
				int libID = login_controller.currentUser.getId();
				
				if (brQuantity != returnQuantity) {
					home_view.warning("Số lượng trả phải bằng số lượng mượn!");
					return;
				}
				
				DTO = new back_book(bookID, readerID, returnQuantity, 
						converter.toSQLDate(new Date()), libID);
				
				DAOback_book.getInstance().insert(DTO);
				DAObooks.getInstance().updateBrrQuantity(bookID, -returnQuantity);
			
				context.loan_bookDTO.setState("returned");
				DAOloan_book.getInstance().update(context.loan_bookDTO);
				
				context.dispose();
				home_view.notify("Trả sách thành công");
				
			} catch (NumberFormatException e1) {
				home_view.warning("Vui lòng không bỏ trống hoặc nhập sai định dạng!");
			}
		}
		
	}

}
