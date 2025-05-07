<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>purchase Details</title>
</head>
<body>
<h2>purchase Details Table</h2>
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
     
     <td>${stock.detail_id }</td>
     <td>${stock.purchase_id }</td>
     <td>${stock.product_id}</td>
     <td>${stock.quantity}</td>
     <td>${stock.price_per_unit }</td>
     <td>${stock.purchase_date}</td>
     
     <td>
        <a href="update.jsp?detail_id=${stock.detail_id}&purchase_id=${stock.purchase_id}&Product_id=${stock.Product id}&quantity=${stock.quantity}&price_per_unit=${stock.price_per_unit}&purchase_date=${stock.purchase_date}">
        
        <button>Update</button>
        
        </a>
     </td>
     
     </tr>s
     </c:forEach>


</table>

</body>
</html>