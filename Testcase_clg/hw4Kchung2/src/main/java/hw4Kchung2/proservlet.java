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
 * Servlet implementation class proservlet
 */
public class proservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public proservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);

				String subid = request.getParameter("subproductid");
				// System.out.println("subid" +subid);
				int subproductid = Integer.parseInt(subid);

				SubProduct sub = Services.FindSubproduct(subproductid);
				boolean  res = Services.CartDetails(sub);
				
				System.out.println(res);
				ArrayList<SubProduct> cartlist = Services.CartDetails();
				


				for(SubProduct pc : cartlist){
					System.out.println(pc);
				}
				
				HttpSession session = request.getSession();

				session.setAttribute("subproductlist", subproductid);
				session.setAttribute("cartlist", cartlist);

				RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
				rd.include(request, response);


	}

}
