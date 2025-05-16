package OSM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OSM.services.DriverController;

@WebServlet("/InsertDriverServlet")
public class InsertDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertDriverServlet() {
        super();

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String license_number=request.getParameter("license_number");
		String address=request.getParameter("address");
		String phone_number=request.getParameter("phone_number");
		String vehicle_type=request.getParameter("vehicle_type");
		String email=request.getParameter("email");
		
		boolean isTrue;
		isTrue = DriverController.insertdata(name,license_number,address,phone_number,vehicle_type,email);
		
		if(isTrue==true) {
			String alertMessage="Data Insert Succesful";
			response.getWriter().println("<script> alert('"+alertMessage+"');window.location.href='GetAllDriverServlet'</script>");
		}
		else {
			RequestDispatcher dis2=request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
		}
		
	}

}
