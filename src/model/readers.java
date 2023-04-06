package model;

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
	
	
}
