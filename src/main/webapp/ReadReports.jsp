<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="java.util.*, OSM.models.Report, OSM.services.ReportController"%>
<%@ page session="true" %>
<%
    String role = (String) session.getAttribute("userRole");
    if (role == null || !role.equals("Admin")) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<h2>Welcome Admin</h2>
<a href="LogoutServlet">Logout</a>
<html>
<head>
  <title>Admin Dashboard - Warehouse Management System<</title>
  <link rel="stylesheet" href="css/style.css">
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHqT94m8bMN1F+TyHqOw+Y9ev0Hz5xAB/l9EfuSh2MLpue2RRGR0q1UG8+MFGKjohP+iPluQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
  
</head>
<body>
<div class="container">
  <aside class="sidebar">
    <header>
        <div class="title">Online Warehouse Management System</div>
       
    </header>
    <div class="alldiv">
        <div class="container-fluid">
                <div class="col-md-2 sidebar">
                    <a href="displaySales.jsp"><i class="fas fa-users me-2"></i> Sales Management</a>
                    <a href="displayDriver.jsp"><i class="fas fa-truck me-2"></i> Driver Management</a>
                    <a href="StockDashboard.jsp"><i class="fas fa-boxes me-2"></i> Warehouse Management</a>
                    <a href="ReadReports.jsp"><i class="fas fa-building me-2"></i>Admin Dashboard</a>
                </div>
        </div>
<div class="container">
        <div class="sidebyside">
            <div class="allblock" >
                <div>
                    <h1>Report List</h1>
                     <a href="createReport.jsp" class = "text-decoration:none;"><button id="addMaterial"><i class="fas fa-plus"></i>
					Create New Report</button></a>
                </div>
                <section class="product-list">
			<table>
				<thead>
					<tr>
						<th>Type</th>
						<th>Title</th>
						<th>Detail</th>
						<th>Date</th>
						<th>Value</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Report> reports = ReportController.getAllReports();
					for (Report r : reports) {
					%>
					<tr>
						<td><%=r.getType()%></td>
						<td><%=r.getTitle()%></td>
						<td><%=r.getDetail()%></td>
						<td><%=r.getDate()%></td>
						<td><%=r.getValue()%></td>
						<td style="display:flex;"><a href="editReport.jsp?id=<%=r.getId()%>"
							class="btn-up" ><i class="fas fa-pen"></i></a> 
						<a href="DeleteReportServlet?id=<%=r.getId()%>"
							onclick="return confirm('Are you sure?')" class="btn-del"><i class="fas fa-trash"></i></a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
	</div>
</body>
</html>
