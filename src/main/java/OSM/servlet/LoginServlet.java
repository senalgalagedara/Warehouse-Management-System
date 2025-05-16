package OSM.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Replace with real DB authentication (for now using dummy users)
        String role = null;

        if (email.equals("admin@example.com") && password.equals("admin123")) {
            role = "Admin";
        } else if (email.equals("driver@example.com") && password.equals("driver123")) {
            role = "DriverManager";
        } else if (email.equals("warehouse@example.com") && password.equals("warehouse123")) {
            role = "WarehouseManager";
        } else if (email.equals("sales@example.com") && password.equals("sales123")) {
            role = "SalesManager";
        }

        if (role != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userRole", role);
            session.setAttribute("email", email);

            switch (role) {
                case "Admin":
                    response.sendRedirect("ReadReports.jsp");
                    break;
                case "DriverManager":
                    response.sendRedirect("insertDriver.jsp");
                    break;
                case "WarehouseManager":
                    response.sendRedirect("StockDashboard.jsp");
                    break;
                case "SalesManager":
                    response.sendRedirect("InsertSales.jsp");
                    break;
            }
        } else {
            request.setAttribute("error", "Invalid credentials");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}
