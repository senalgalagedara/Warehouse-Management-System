<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="OSM.models.Product, OSM.services.ProductController" %>
<%
    String id = request.getParameter("id");
    Product p = null;

    try {
        for (Product prod : ProductController.getAllProducts()) {
            if (prod.getProductID().equals(id)) {
                p = prod;
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    if (p == null) {
%>
    <h2 style="color:red; text-align:center;">Product not found for ID: <%= id %></h2>
    <div style="text-align:center;"><a href="ViewMeterials">Back to Product List</a></div>
<%
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eafaf1;
            margin: 0;
            padding: 0;
        }

        .form {
            background: #ffffff;
            max-width: 500px;
            margin: 60px auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 128, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #2e7d32;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #2e7d32;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        button {
            margin-top: 20px;
            width: 100%;
            background-color: #43a047;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #388e3c;
        }

        .cancelBtn {
            background-color: #999;
        }

        .cancelBtn:hover {
            background-color: #666;
        }
    </style>

    <script>
        function validateEditForm() {
            let pid = document.getElementById("productID").value;
            let pname = document.getElementById("productName").value;
            let qty = document.getElementById("quantity").value;
            let price = document.getElementById("price").value;

            if (pid.trim() === "" || pname.trim() === "" || qty.trim() === "" || price.trim() === "") {
                alert("Please fill in all required fields.");
                return false;
            }

            if (isNaN(qty) || parseInt(qty) <= 0) {
                alert("Quantity must be a positive number.");
                return false;
            }

            if (isNaN(price) || parseFloat(price) <= 0) {
                alert("Price must be a positive number.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <div class="form">
        <header><h1>Edit Product</h1></header>
        <form action="UpdateMaterials" method="post" onsubmit="return validateEditForm();">
            <label>Product ID:</label>
            <input type="text" id="productID" name="productID" value="<%= p.getProductID() %>" readonly />

            <label>Name:</label>
            <input type="text" id="productName" name="productName" value="<%= p.getProductName() %>" required />

            <label>Brand:</label>
            <input type="text" id="brand" name="brand" value="<%= p.getBrand() %>" required />

            <label>Quantity:</label>
            <input type="number" id="quantity" name="quantity" value="<%= p.getQuantity() %>" required />

            <label>Price:</label>
            <input type="text" id="price" name="price" value="<%= p.getPrice() %>" required />

            <label>Manufactured Date:</label>
            <input type="date" id="manufacturedDate" name="manufacturedDate" value="<%= p.getManufacturedDate() %>" required />

            <label>Expired Date:</label>
            <input type="date" id="expiredDate" name="expiredDate" value="<%= p.getExpiredDate() %>" required />

            <button type="submit" class="updateBtn">Update</button>
            <a href="ViewMeterials"><button type="button" class="cancelBtn">Cancel</button></a>
        </form>
    </div>
</body>
</html>
