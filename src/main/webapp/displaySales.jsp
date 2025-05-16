<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<%
    String role = (String) session.getAttribute("userRole");
    if (role == null || !role.equals("SalesManager")) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Driver Maneger - Warehouse Management System</title>
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
                    <h1>Sales List</h1>
                    <a href = "InsertSales.jsp" style ="text-decoration:none;"><button id="addMaterial"><i class="fas fa-plus"></i>New Sale</button></a>
                </div>
                <section class="product-list">
<table>
  <tr>
    <th>Detail ID</th>
    <th>Purchase ID</th>
    <th>Product ID</th>
    <th>Quantity</th>
    <th>Price per unit</th>
    <th>Date</th>
    <th>Action</th>
  </tr>

  <c:forEach var="stock" items ="${allpurchase}">
    <tr>
      <td>${stock.detail_id}</td>
      <td>${stock.purchase_id}</td>
      <td>${stock.product_id}</td>
      <td>${stock.quantity}</td>
      <td>${stock.price_per_unit}</td>
      <td>${stock.purchase_date}</td>
      <td style = " display:flex;">
        <a style = "text-decoration:none;" href="updateSales.jsp?detail_id=${stock.detail_id}&purchase_id=${stock.purchase_id}&product_id=${stock.product_id}&quantity=${stock.quantity}&price_per_unit=${stock.price_per_unit}&purchase_date=${stock.purchase_date}">
          <button class="btn-up" ><i class="fas fa-pen"></i></button>
        </a>
        <form action="DeleteSalesServlet" method="post" style="margin-left:10px;">
          <input type="hidden" name="detail_id" value="${stock.detail_id}" />
          <button class="btn-del"><i class="fas fa-trash"></i></button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
