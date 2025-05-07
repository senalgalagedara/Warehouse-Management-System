<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String detail_id = request.getParameter("detail_id");
  String purchase_id  = request.getParameter("purchase_id ");
  String product_id = request.getParameter("product_id ");
  String quantity = request.getParameter("quantity ");
  String price_per_unit = request.getParameter("price_per_unit");
  String purchase_date = request.getParameter("purchase_date");
  
  


%>

<h2>Enter Purchase Details</h2>

<form action="UpdateServlet" method="post">

    <label for="detail_id">detail_id:</label><br>
    <input type="text" id="detail_id" name="detail_id" value="<%=detail_id %>" readonly><br><br>

    <label for="purchase_id">Purchase ID:</label><br>
    <input type="text" id="purchase_id" name="purchase_id" value="<%=purchase_id %>"required><br><br>

    <label for="product_id">Product ID:</label><br>
    <input type="text" id="product_id" name="product_id" value="<%=product_id %>"required><br><br>

    <label for="quantity">Quantity:</label><br>
    <input type="number" id="quantity" name="quantity" value="<%=quantity %>" required><br><br>

    <label for="price_per_unit">Price per Unit:</label><br>
    <input type="number" step="0.01" id="price_per_unit" name="price_per_unit" value="<%=price_per_unit%>"required><br><br>

    <label for="purchase_date">Purchase Date:</label><br>
    <input type="date" id="purchase_date" name="purchase_date" value="<%=purchase_date%>"required><br><br>

    <input type="submit" value="Submit">
</form>


</body>
</html>