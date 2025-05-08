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

@WebServlet("/GetAllServlet")
public class readCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Map<String, String>> allpurchase = customerInvoController.getAllPurchase();
		request.setAttribute("allpurchase",allpurchase);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
		dispatcher .forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	

}
