<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Purchase Details</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 40px;
  }

  h2 {
    text-align: center;
    color: #333;
  }

  form {
    max-width: 500px;
    margin: auto;
    padding: 20px;
    background-color: white;
    border-radius: 8px;
    box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  }

  label {
    display: block;
    margin-bottom: 6px;
    font-weight: bold;
    color: #555;
  }

  input[type="text"],
  input[type="number"],
  input[type="date"] {
    width: 100%;
    padding: 8px;
    margin-bottom: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: green;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: green;
  }
</style>
</head>
<body>

<%
  String detail_id = request.getParameter("detail_id");
  String purchase_id = request.getParameter("purchase_id");
  String product_id = request.getParameter("product_id");
  String quantity = request.getParameter("quantity");
  String price_per_unit = request.getParameter("price_per_unit");
  String purchase_date = request.getParameter("purchase_date");
%>

<h2>Update Purchase Details</h2>

<form action="UpdateSalesServlet" method="post"  onsubmit="return validateForm()" style="padding:20px 20px;
    																		margin:auto;
    																		padding-right:30px">

    <label for="detail_id">Detail ID:</label>
    <input type="text" id="detail_id" name="detail_id" value="<%=detail_id%>" readonly>

    <label for="purchase_id">Purchase ID:</label>
    <input type="text" id="purchase_id" name="purchase_id" value="<%=purchase_id%>" required>

    <label for="product_id">Product ID:</label>
    <input type="text" id="product_id" name="product_id" value="<%=product_id%>" required>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" value="<%=quantity%>" required>

    <label for="price_per_unit">Price per Unit:</label>
    <input type="number" step="0.01" id="price_per_unit" name="price_per_unit" value="<%=price_per_unit%>" required>

    <label for="purchase_date">Purchase Date:</label>
    <input type="date" id="purchase_date" name="purchase_date" value="<%=purchase_date%>" required>

    <input type="submit" value="Update">
</form>
<script>
    function validateForm() {
      const quantity = document.getElementById("quantity").value;
      const price = document.getElementById("price_per_unit").value;
      const date = document.getElementById("purchase_date").value;
      const today = new Date().toISOString().split("T")[0];

      if (quantity <= 0) {
        alert("Quantity must be greater than 0.");
        return false;
      }

      if (price <= 0) {
        alert("Price per unit must be greater than 0.");
        return false;
      }

      if (date > today) {
        alert("Purchase date cannot be in the future.");
        return false;
      }

      return true;
    }
  </script>
</body>
</html>
