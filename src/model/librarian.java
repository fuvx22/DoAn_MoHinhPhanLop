package model;

public class librarian {
	private int id;
	private String name;
	private String address;
	private String login_name;
	private String login_pw;
	
	public librarian() {
		super();
	}
	
	public librarian(String name, String address, String login_name, String login_pw) {
		super();
		this.name = name;
		this.address = address;
		this.login_name = login_name;
		this.login_pw = login_pw;
	}
	
	public librarian(int id, String name, String address, String login_name, String login_pw) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.login_name = login_name;
		this.login_pw = login_pw;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_pw() {
		return login_pw;
	}
	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}

	
	
	
	@Override
	public String toString() {
		return "librarian [id=" + id + ", name=" + name + ", address=" + address + ", login_name=" + login_name
				+ ", login_pw=" + login_pw + "]";
	}
	
	public void setProperty(String librarianName, String librarianAddress, String username, String password) {	
		this.setName(librarianName.trim());
		this.setAddress(librarianAddress.trim());
		this.setLogin_name(username.trim());
		this.setLogin_pw(password.trim());
	}
	public boolean compare(librarian other) {
		if (this.toString().equals(other.toString())) {
			return true;
		}
		else return false;
	}
	
}
