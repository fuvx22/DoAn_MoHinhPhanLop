package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class readers {
	private int reader_id;
	private String name;
	private String phone_number;
	private String address;
	
	public readers() {
		super();
	}

	public readers(String name, String phone_number, String address) {
		super();
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
	}
	
	public readers(int reader_id, String name, String phone_number, String address) {
		super();
		this.reader_id = reader_id;
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
	}

	public int getReader_id() {
		return reader_id;
	}

	public void setReader_id(int reader_id) {
		this.reader_id = reader_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	@Override
	public String toString() {
		return "readers [reader_id=" + reader_id + ", name=" + name + ", phone_number=" + phone_number + ", address="
				+ address + "]";
	}

	public void setProperty(String readerName, String readerPhone, String readerAddress ) {	
		this.setName(readerName.trim());
		this.setPhone_number(readerPhone.trim());
		this.setAddress(readerAddress.trim());
	}
	public boolean compare(readers other) {
		if (this.toString().equals(other.toString())) {
			return true;
		}
		else return false;
	}
}
