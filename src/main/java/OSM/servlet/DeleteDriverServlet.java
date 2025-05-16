package OSM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OSM.services.DriverController;
import OSM.models.DriverModel;

@WebServlet("/DeleteDriverServlet")
public class DeleteDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteDriverServlet() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id =request.getParameter("id");
		boolean isTrue;
		isTrue=DriverController.deletedata(id);
		if(isTrue==true) {
			String alertMessage="Data Delete Succesfull";
			response.getWriter().println("<script> alert('"+alertMessage+"');"+"window.location.href='GetAllDriverServlet';</script>");
		}
		else {
			List<DriverModel> driverDetails =DriverController.getByid(id);
			request.setAttribute("driverDetails",driverDetails);
			RequestDispatcher dispacher=request.getRequestDispatcher("wrong.jsp");
			dispacher.forward(request, response);
		}
		
	}

}
