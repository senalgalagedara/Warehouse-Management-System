package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.customerInvoController;

@WebServlet("/UpdateServlet")
public class updateCustomer<StockModel> extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String detail_id =request.getParameter("detail_id");
		String purchase_id = request.getParameter("purchase_id");
		String product_id = request.getParameter("product_id");
		String quantity = request.getParameter("quantity");
		String price_per_unit = request.getParameter("price_per_unit");
		String purchase_date = request.getParameter("purchase_date");
		
		boolean isTrue;
		isTrue = customerInvoController.updateData(purchase_date, purchase_id, product_id, quantity, price_per_unit, purchase_date);
		 if(isTrue == true) {
			   List<Map<String, String>> purchasedetail =customerInvoController.getById(detail_id);
			   request.setAttribute("purchasedetails",purchasedetail);
			   
	    	   String alertMessage = "Data update Successful";
	    	   response.getWriter().println("<script> alert('"+alertMessage+"'); window.location,href='GetAllServlet'</script>");
	       }
	       else {
	    	   RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
	    	   dis2.forward(request, response);
	       }

	}

}
