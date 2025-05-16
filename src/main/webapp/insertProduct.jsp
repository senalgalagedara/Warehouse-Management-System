<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eafaf1;
            margin: 0;
            padding: 0;
        }

        .form-container {
            background: #ffffff;
            max-width: 500px;
            margin: 60px auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 128, 0, 0.1);
        }

        h2 {
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

        .error-msg {
            color: red;
            font-size: 14px;
            margin-top: 5px;
        }
    </style>

    <script>
        function validateForm() {
            const pid = document.getElementById("productID").value;
            const pname = document.getElementById("productName").value;
            const qty = document.getElementById("quantity").value;
            const price = document.getElementById("price").value;
            const date = document.getElementByID("manufacturedDate").value;
            const today = new Date().toISOString().split("T")[0];


            if (pid.trim() === "" || pname.trim() === "" || qty.trim() === "" || price.trim() === "") {
                alert("Please fill in all required fields.");
                return false;
            }

            if (qty < 0) {
                alert("Quantity must be a positive number.");
                return false;
            }

            if (price < 0) {
                alert("Price must be a positive number.");
                return false;
            }
            if (date > today) {
                alert("Manufacture date cannot be in the future.");
                return false;
              }
            return true;
        }
    </script>
</head>
<body>

<div class="form-container">
    <h2>Add New Product</h2>
    <form name="addProductForm" action="AddMeterials" method="post" onsubmit="return validateForm();">
        <label>Product ID:</label>
        <input type="text" id="productID" name="productID" required/>

        <label>Name:</label>
        <input type="text" id="productName" name="productName" required/>

        <label>Brand:</label>
        <input type="text" id="brand" name="brand"/>

        <label>Quantity:</label>
        <input type="number" id="quantity" name="quantity" required/>

        <label>Price:</label>
        <input type="text" id="price" name="price" required/>

        <label>Manufactured Date:</label>
        <input type="date" id="manufacturedDate" name="manufacturedDate"/>

        <label>Expired Date:</label>
        <input type="date" id="expiredDate" name="expiredDate"/>

        <button type="submit">Add Product</button>
    </form>
</div>

</body>
</html>
