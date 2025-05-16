package OSM.servlet;

import OSM.models.Report;
import OSM.services.ReportController;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class UpdateReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Report r = new Report();
        r.setId(Integer.parseInt(req.getParameter("id")));
        r.setType(req.getParameter("type"));
        r.setTitle(req.getParameter("title"));
        r.setDetail(req.getParameter("detail"));
        r.setDate(req.getParameter("date"));
        r.setValue(req.getParameter("value"));

        ReportController.updateReport(r);
        res.sendRedirect("ReadReports.jsp");
    }
}
