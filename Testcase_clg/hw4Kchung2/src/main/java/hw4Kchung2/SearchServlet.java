package hw4Kchung2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Kchung_DTO.Contact;
import Kchung_DTO.Product;
import Kchung_Services.*;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 RequestDispatcher rd=request.getRequestDispatcher("/ExsitingCust.jsp");
		 rd.include(request, response);

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String pwd = request.getParameter("pwd");
		
		Contact con = new Contact(fname,"","", pwd);
		
		HttpSession session = request.getSession();
		ArrayList<Contact> contactlist	=	Services.SerchContact(con);
		if(contactlist.isEmpty()){
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User or password incorrect');");
			out.println("location='cust_login.jsp';");
			out.println("</script>");
			
		}
		else{
			session.setAttribute("contactdto",contactlist);

			
			ArrayList<Product> Productlist =	Services.Allproduct();
		     session.setAttribute("productlist",Productlist);
			 RequestDispatcher rd=request.getRequestDispatcher("/Productpage.jsp");
			 rd.include(request, response);
	
		}
				
	}

}
