package model;

import java.sql.Date;

public class back_book {
	private int id;
	private int book_id;
	private int reader_id;
	private int quantity;
	private Date back_date;
	private int lib_id;
	
	public back_book() {
		super();
	}

	public back_book(int book_id, int reader_id, int quantity, Date back_date, int lib_id) {
		super();
		this.book_id = book_id;
		this.reader_id = reader_id;
		this.quantity = quantity;
		this.back_date = back_date;
		this.lib_id = lib_id;
	}

	public back_book(int id, int book_id, int reader_id, int quantity, Date back_date, int lib_id) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.reader_id = reader_id;
		this.quantity = quantity;
		this.back_date = back_date;
		this.lib_id = lib_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getReader_id() {
		return reader_id;
	}

	public void setReader_id(int reader_id) {
		this.reader_id = reader_id;
	}

	public Date getBack_date() {
		return back_date;
	}

	public void setBack_date(Date back_date) {
		this.back_date = back_date;
	}

	public int getLib_id() {
		return lib_id;
	}

	public void setLib_id(int lib_id) {
		this.lib_id = lib_id;
	}
	
	
}
