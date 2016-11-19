package Kchung_DTO;

public class Contact {
private String fname;
private String lname;
private String phone;
private String pwd;
public Contact() {
}

public Contact(String fname, String lname, String phone,String pwd) {
	this.fname = fname;
	this.lname = lname;
	this.phone = phone;
	this.pwd= pwd;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPwd(){
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}







}
