<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Purchase Details</title>
 <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      padding: 40px;
    }

    form {
      max-width: 500px;
      margin: auto;
      padding: 20px;
      background-color: white;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
    text-align: center;
    color: #333;
    margin-top: 20px;
    margin-bottom: 10px;
    font-size: 20px;
    border-bottom: 2px solid green;
    padding-bottom: 5px;
    }
    

    label {
      display: block;
      margin-top: 10px;
      font-weight: bold;
    }

    input[type="text"],
    input[type="number"],
    input[type="date"] {
      width: 100%;
      padding: 8px;
      margin-top: 5px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: green;
      color: white;
      font-size: 16px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: green;
    }
  </style>

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
</head>
<body>


<form action="InsertSalesServlet" method="post" onsubmit="return validateForm();" style="padding:20px 20px;
    																		margin:auto;
    																		padding-right:30px">

  <h2>Enter purchase Details</h2>
  <label for="purchase_id">Purchase ID:</label>
  <input type="text" id="purchase_id" name="purchase_id" required>

  <label for="product_id">Product ID:</label>
  <input type="text" id="product_id" name="product_id" required>

  <label for="quantity">Quantity:</label>
  <input type="number" id="quantity" name="quantity" min="1" required>

  <label for="price_per_unit">Price per Unit:</label>
  <input type="number" step="0.01" id="price_per_unit" name="price_per_unit" min="0.01" required>

  <label for="purchase_date">Purchase Date:</label>
  <input type="date" id="purchase_date" name="purchase_date" required>

  <input type="submit" value="Add Purchase Detail" style="margin:auto !important; displau:block;">
</form>

</body>
</html>
