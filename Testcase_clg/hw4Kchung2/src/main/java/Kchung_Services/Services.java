package Kchung_Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Kchung_DTO.Contact;
import Kchung_DTO.Product;
import Kchung_DTO.SubProduct;

public class Services {

	public static Connection databaseconnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yelp", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
	
	public static boolean AddConatct(Contact contact) {
		String sql = "insert into contact(fname,lname,phone,pwd) values (?,?,?,?)";
		PreparedStatement ps;
		try {
					ps = (PreparedStatement) databaseconnection().prepareStatement(sql);
			ps.setString(1, contact.getFname());
			ps.setString(2, contact.getLname());
			ps.setString(3, contact.getPhone());
			ps.setString(4, contact.getPwd());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	
	
	public static ArrayList<Contact> SerchContact(Contact firstnameandpwd) {
		Contact con= null;
		ArrayList<Contact> contactlist = new ArrayList<Contact>();
		String sql = "select * from contact where fname=? and pwd=?";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) databaseconnection().prepareStatement(sql);
			ps.setString(1,firstnameandpwd.getFname());
			ps.setString(2,firstnameandpwd.getPwd());
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()){
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String phone = rs.getString("phone");
				String pwd = rs.getString("pwd");
				
				con = new Contact(fname, lname, phone,pwd);
				contactlist.add(con);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return contactlist;
	}

	
	public static ArrayList<Product> Allproduct(){
		String sql="select * from products ";
		
		Product pro= null;
		ArrayList<Product> productlist = new ArrayList<Product>();
		PreparedStatement ps;
		try {
			ps = (PreparedStatement)databaseconnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				pro = new Product(product_id, product_name);
				productlist.add(pro);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return productlist;
	}
	
	
	public static ArrayList<SubProduct> Subproduct(int productid){
		String sql="select * from subproduct where product_id =? ";
		
		SubProduct pro= null;
		ArrayList<SubProduct> subproductlist = new ArrayList<SubProduct>();
		PreparedStatement ps;
		try {
			ps = (PreparedStatement)databaseconnection().prepareStatement(sql);
			ps.setInt(1,productid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			int	product_id= rs.getInt("product_id");
			int	subid= rs.getInt("subid");
			String productname = rs.getString("productname");
			String	details = rs.getString("details");
			int	productrate = rs.getInt("productrate");
			String extra = rs.getString("extra");
				pro = new SubProduct(product_id, subid, productname, details, productrate, extra);
				subproductlist.add(pro);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return subproductlist;
	}
	

	
	public static SubProduct FindSubproduct(int subproductid){
		String sql="select * from subproduct where subid =? ";
		
		SubProduct pro= null;
		ArrayList<SubProduct> subproductlist = new ArrayList<SubProduct>();
		PreparedStatement ps;
		PreparedStatement ps1 ;
		try {
			ps = (PreparedStatement)databaseconnection().prepareStatement(sql);
			
			ps.setInt(1,subproductid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
			int	product_id= rs.getInt("product_id");
			int	subid= rs.getInt("subid");
			String productname = rs.getString("productname");
			String	details = rs.getString("details");
			int	productrate = rs.getInt("productrate");
			String extra = rs.getString("extra");
			
			pro = new SubProduct(product_id, subid, productname, details, productrate, extra);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return pro;
	}

	
	
	public static boolean CartDetails(SubProduct pro){
	
		
		String sql = "insert into cart(product_id,subid,productname,details,productrate,extra) values (?,?,?,?,?,?)";
		PreparedStatement ps1 ;
		try {
					ps1 = (PreparedStatement) databaseconnection().prepareStatement(sql);
					
					ps1.setInt(1,pro.getProduct_id());
					ps1.setInt(2,pro.getSubid());
					ps1.setString(3,pro.getProductname());
					ps1.setString(4,pro.getDetails());
					ps1.setInt(5,pro.getProductrate());
					ps1.setString(6,pro.getExtra());
					ps1.executeUpdate();
				
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<SubProduct> CartDetails( ){
		String sql="select * from cart";
		
		SubProduct pro= null;
		ArrayList<SubProduct> subproductlist = new ArrayList<SubProduct>();
		PreparedStatement ps;
		try {
			ps = (PreparedStatement)databaseconnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			int	product_id= rs.getInt("product_id");
			int	subid= rs.getInt("subid");
			String productname = rs.getString("productname");
			String	details = rs.getString("details");
			int	productrate = rs.getInt("productrate");
			String extra = rs.getString("extra");
				pro = new SubProduct(product_id, subid, productname, details, productrate, extra);
				subproductlist.add(pro);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return subproductlist;
	
	}
}
