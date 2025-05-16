package OSM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OSM.services.SalesController;
import OSM.models.SalesModel;

@WebServlet("/DeleteSalesServlet")
public class DeleteSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String detail_id = request.getParameter("detail_id");
		boolean isTrue;
		isTrue = SalesController.deletedata(detail_id);
		if(	isTrue == true) {
			String alertMessage = "Data Delete Successful";
			response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='GetAllSalesServlet';</script>");
			
			
		}
		else {
			List<SalesModel> StockDetail = SalesController.getById(detail_id);
			request.setAttribute("StockDetail", StockDetail);
			
			RequestDispatcher dispacher = request.getRequestDispatcher("wrong.jsp");
			dispacher.forward(request, response);
		}
	}

}
