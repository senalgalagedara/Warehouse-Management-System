<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="OSM.models.Report, OSM.services.ReportController"%>
<%
int id = Integer.parseInt(request.getParameter("id"));
Report r = null;
for (Report report : ReportController.getAllReports()) {
	if (report.getId() == id) {
		r = report;
		break;
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Report</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="form">
		<header>
			<h1>Edit Report</h1>
		</header>
		<form action="UpdateReportServlet" method="post">
			<input type="hidden" name="id" value="<%=r.getId()%>" /> <label>Type:</label>
			<input type="text" name="type" value="<%=r.getType()%>" required />

			<label>Title:</label> <input type="text" name="title"
				value="<%=r.getTitle()%>" required /> <label>Detail:</label>
			<textarea name="detail" rows="3" required><%=r.getDetail()%></textarea>

			<label>Date:</label> <input type="date" name="date"
				value="<%=r.getDate()%>" required /> <label>Value:</label> <input
				type="text" name="value" value="<%=r.getValue()%>" required />

			<button type="submit" class="updateBtn">Update</button>
			 <a href="ReadReports.jsp"
				onclick="return confirm('Are you sure?')"><button type="button"
					class="cancelBtn">Cancel</button></a>

		</form>
	</div>
</body>
</html>
