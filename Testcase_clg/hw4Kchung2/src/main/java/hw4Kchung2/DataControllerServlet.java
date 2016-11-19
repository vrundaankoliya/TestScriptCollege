package hw4Kchung2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Kchung_DTO.Contact;
import Kchung_DTO.Product;
import Kchung_Services.Services;

public class DataControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		//System.out.println(fname+" "+lname+" "+phone);
		if(fname.length()>15 && lname.length()>15 && phone.length()>10){
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	
		Contact con = new Contact(fname, lname, phone,pwd);
		Services.AddConatct(con);
		//RequestDispatcher rd = request.getRequestDispatcher("/thankyou.jsp").include(request, response);
		
	     ArrayList<Product> Productlist =	Services.Allproduct();
	     HttpSession session = request.getSession();
	     session.setAttribute("productlist",Productlist);
		 RequestDispatcher rd=request.getRequestDispatcher("/Productpage.jsp");
		 rd.include(request, response);		
	}

}
