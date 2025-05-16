<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*, OSM.services.ProductController, OSM.models.Product"%>
<%@ page session="true" %>
<%
    String role = (String) session.getAttribute("userRole");
    if (role == null || !role.equals("WarehouseManager")) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Warehouse Manager - Warehouse Management System </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHqT94m8bMN1F+TyHqOw+Y9ev0Hz5xAB/l9EfuSh2MLpue2RRGR0q1UG8+MFGKjohP+iPluQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
	<header>
        <div class="title">Online Warehouse Management System</div>
        <a href="LogoutServlet" style="text-decoration:none; color:green;">Logout</a>
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
                    <h1>Product List</h1>
                    <a href = "insertProduct.jsp" style ="text-decoration:none;"><button id="addMaterial"><i class="fas fa-plus"></i>Add Driver</button></a>
                </div>
                <section class="product-list">
			<table class="report-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Manufactured Date</th>
						<th>Expired Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Product> products = ProductController.getAllProducts();
					if (products != null && !products.isEmpty()) {
						for (Product p : products) {
					%>
					<tr>
						<td><%= p.getProductID() %></td>
						<td><%= p.getProductName() %></td>
						<td><%= p.getBrand() %></td>
						<td><%= p.getQuantity() %></td>
						<td><%= p.getPrice() %></td>
						<td><%= p.getManufacturedDate() %></td>
						<td><%= p.getExpiredDate() %></td>
						<td style="display:flex; width:120px; margin:auto !important;">
							<a href="editMeterial.jsp?id=<%=p.getProductID()%>" style="text-decoration:none;">
							<span class="btn-up"><i class="fas fa-pen" style="padding:0px !important;"></i></span>
							</a>
							
							<form action="DeleteMeterials" method="post">
							  <input type="hidden" name="productID" value="<%= p.getProductID()%>" />
							  <button class="btn-del" style="margin-left:20px; padding:10px;"> <i class="fas fa-trash"></i></button>
							</form>						
						</td>
					</tr>
					<%
						}
					} else {
					%>
					<tr>
						<td colspan="8">No products found.</td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</main>
	</div>
</body>
</html>
