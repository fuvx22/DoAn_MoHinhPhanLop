package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class books {
	private int book_id;
	private String name;
	private String author;
	private Date rel_date;
	private int quantity;
	private int brr_quan = 0;

	public books() {
		super();
	}
	
	public books(String name, String author, Date release_date, int quantity) {
		super();
		this.name = name;
		this.author = author;
		this.rel_date = release_date;
		this.quantity = quantity;
	}
	
	public books(int id, String name, String author, Date release_date, int quantity) {
		super();
		this.book_id = id;
		this.name = name;
		this.author = author;
		this.rel_date = release_date;
		this.quantity = quantity;
	}

	public books(int book_id, String name, String author, Date release_date, int quantity, int brr_quantity) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.author = author;
		this.rel_date = release_date;
		this.quantity = quantity;
		this.brr_quan = brr_quantity;
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
		return rel_date;
	}

	public void setRelease_date(Date release_date) {
		this.rel_date = release_date;
	}
	
	public int getBrr_quantity() {
		return brr_quan;
	}
	
	public void setBrr_quantity(int brr_quantity) {
		this.brr_quan = brr_quantity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+this.getBook_id()+this.getName()+this.getAuthor()+this.getRelease_date()+this.getQuantity()+"]";
	}
	
	public void setProperty(String name, String author, int quantity, java.util.Date release_date) {		
		String rel_date = new SimpleDateFormat("yyyy-MM-dd").format(release_date);
		this.setName(name.trim());
		this.setAuthor(author.trim());
		this.setQuantity(quantity);
		this.setRelease_date(Date.valueOf(rel_date));
	}
	public boolean compare(books other) {
		if (this.toString().equals(other.toString())) {
			return true;
		}
		else return false;
	}
}
