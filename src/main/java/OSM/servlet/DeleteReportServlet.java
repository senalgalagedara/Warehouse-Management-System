package OSM.servlet;

import OSM.services.ReportController;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteReportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ReportController.deleteReport(id);
        res.sendRedirect("ReadReports.jsp");
    }
}