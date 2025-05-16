package OSM.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import OSM.models.Report;
import OSM.services.ReportController;



public class InsertReportServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String type = req.getParameter("type");
        String title = req.getParameter("title");
        String detail = req.getParameter("detail");
        String date = req.getParameter("date");
        String value = req.getParameter("value");

        Report r = new Report();
        r.setType(type);
        r.setTitle(title);
        r.setDetail(detail);
        r.setDate(date);
        r.setValue(value);

        ReportController.insertReport(r);

        res.sendRedirect("ReadReports.jsp");
    }
}
