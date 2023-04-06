package model;

import java.sql.Date;

public class loan_book {
	private int id;
	private int book_id;
	private int reader_id;
	private int quantity;
	private Date loan_date;
	private Date exp_date;
	private int lib_id;
	private boolean state = true;
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public loan_book() {
		super();
	}

	public loan_book(int book_id, int reader_id, int quantity, Date loan_date, Date exp_date, int lib_id, boolean s) {
		super();
		this.book_id = book_id;
		this.reader_id = reader_id;
		this.quantity = quantity;
		this.loan_date = loan_date;
		this.exp_date = exp_date;
		this.lib_id = lib_id;
		this.state = s;
	}
	
	public loan_book(int id, int book_id, int reader_id, int quantity, Date loan_date, Date exp_date, int lib_id, boolean s) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.reader_id = reader_id;
		this.quantity = quantity;
		this.loan_date = loan_date;
		this.exp_date = exp_date;
		this.lib_id = lib_id;
		this.state = s;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(Date loan_date) {
		this.loan_date = loan_date;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public int getLib_id() {
		return lib_id;
	}

	public void setLib_id(int lib_id) {
		this.lib_id = lib_id;
	}
	
	
	
}
