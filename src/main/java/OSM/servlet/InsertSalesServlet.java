package OSM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OSM.services.SalesController;
@WebServlet("/InsertSalesServlet")
public class InsertSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String purchase_id = request.getParameter("purchase_id");
		String product_id = request.getParameter("product_id");
		String quantity = request.getParameter("quantity");
		String price_per_unit = request.getParameter("price_per_unit");
		String purchase_date = request.getParameter("purchase_date");
	
       boolean isTrue;
       
       isTrue = SalesController.insertdata(purchase_id, product_id, quantity, price_per_unit, purchase_date);
    	   
       if(isTrue == true) {
    	   String alertMessage = "Data Insert Successful";
    	   response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='GetAllSalesServlet';</script>");

       }
       else {
    	   RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
    	   dis2.forward(request, response);
       }

	}
}