package model;

import java.sql.Date;

public class books {
	private int book_id;
	private String name;
	private String author;
	private Date release_date;
	private int quantity;
	private int brr_quantity = 0;

	public books() {
		super();
	}
	
	public books(String name, String author, Date release_date, int quantity) {
		super();
		this.name = name;
		this.author = author;
		this.release_date = release_date;
		this.quantity = quantity;
	}
	
	public books(int id, String name, String author, Date release_date, int quantity) {
		super();
		this.book_id = id;
		this.name = name;
		this.author = author;
		this.release_date = release_date;
		this.quantity = quantity;
	}

	public books(int book_id, String name, String author, Date release_date, int quantity, int brr_quantity) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.author = author;
		this.release_date = release_date;
		this.quantity = quantity;
		this.brr_quantity = brr_quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	
	public int getBrr_quantity() {
		return brr_quantity;
	}
	
	public void setBrr_quantity(int brr_quantity) {
		this.brr_quantity = brr_quantity;
	}
	
}
