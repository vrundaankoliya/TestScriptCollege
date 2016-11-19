package Kchung_DTO;

public class SubProduct {

private int product_id;
private int subid;
private String productname;
private String details;
private int productrate;
private String extra;




public SubProduct() {
	//super();
}


public SubProduct(int product_id, int subid, String productname, String details, int productrate, String extra) {
	super();
	this.product_id = product_id;
	this.subid = subid;
	this.productname = productname;
	this.details = details;
	this.productrate = productrate;
	this.extra = extra;
}


public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public int getSubid() {
	return subid;
}
public void setSubid(int subid) {
	this.subid = subid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public int getProductrate() {
	return productrate;
}
public void setProductrate(int productrate) {
	this.productrate = productrate;
}
public String getExtra() {
	return extra;
}
public void setExtra(String extra) {
	this.extra = extra;
}




}


