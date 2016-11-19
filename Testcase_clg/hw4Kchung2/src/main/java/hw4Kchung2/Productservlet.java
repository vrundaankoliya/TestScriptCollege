package hw4Kchung2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Kchung_DTO.SubProduct;
import Kchung_Services.Services;

/**
 * Servlet implementation class Productservlet
 */
public class Productservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String product_id = request.getParameter("productid");
		System.out.println(product_id);
		int pid = Integer.parseInt(product_id);	
		
		ArrayList<SubProduct> subproductlist =  Services.Subproduct(pid);
		 HttpSession session = request.getSession();
	     session.setAttribute("subproductlist",subproductlist);
		 RequestDispatcher rd=request.getRequestDispatcher("/orderpage.jsp");
		 rd.include(request, response);
		
		
	
	}

}
