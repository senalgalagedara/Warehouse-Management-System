<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer purchase Details</title>
</head>
<body>
<h2>Enter Purchase Details</h2>

<form action="InsertServlet" method="post">
    <label for="purchase_id">Purchase ID:</label><br>
    <input type="text" id="purchase_id" name="purchase_id" required><br><br>

    <label for="product_id">Product ID:</label><br>
    <input type="text" id="product_id" name="product_id" required><br><br>

    <label for="quantity">Quantity:</label><br>
    <input type="number" id="quantity" name="quantity" required><br><br>

    <label for="price_per_unit">Price per Unit:</label><br>
    <input type="number" step="0.01" id="price_per_unit" name="price_per_unit" required><br><br>

    <label for="purchase_date">Purchase Date:</label><br>
    <input type="date" id="purchase_date" name="purchase_date" required><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>