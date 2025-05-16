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

@WebServlet("/GetAllDriverServlet")
public class GetAllDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		List <DriverModel> alldrivers= DriverController.getAllDriver();
		request.setAttribute("alldrivers",alldrivers);
		RequestDispatcher dispatcher =request.getRequestDispatcher("displayDriver.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
}

}
