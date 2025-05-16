<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Driver Registration</title>
    <style>
        body {
            font-family: sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .form-container {
            width: 400px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 6px;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input, textarea {
            width: 100%;
            padding: 8px;
            margin-top: 4px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        button {
            margin-top: 15px;
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="form-container">


    <h2>Driver Registration</h2>
    
    <form action="InsertDriverServlet" id="insertForm" method="post" style="padding:20px 20px;
    																		margin:auto;
    																		padding-right:30px">
    

        
        <label for="name">Name</label>
        <input type="text" id="name" name="name"  required>
        
        <label for="address">Address</label>
        <textarea id="address" name="address" rows="2" required></textarea>
        
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
        
        
        <label for="phone_number">Phone Number</label>
		<input type="text" id="phone_number" name="phone_number" pattern="\d{10}" required>

        <label for="license_number">License Number</label>
        <input type="text" id="license_number" name="license_number" required>

         <label for="vehicle_type">Vehicle Type</label>
        <select id="vehicle_type" name="vehicle_type" required>
            <option value="" disabled selected>Select your vehicle type</option>
            <option value="car">Car</option>
            <option value="truck">Truck</option>
            <option value="motorcycle">Motorcycle</option>
            <option value="van">Van</option>
           
        </select>
     
        <button type="submit">Submit</button>
    </form>
</div>
<script>
    document.getElementById("insertForm").addEventListener("submit", function(event) {
        const phoneInput = document.getElementById("phone_number");
        const phoneNumber = phoneInput.value.trim();
        const phoneRegex = /^\d{10}$/; // Exactly 10 digits

        if (!phoneRegex.test(phoneNumber)) {
            alert("Please enter a valid 10-digit phone number.");
            event.preventDefault();
        }
    });
</script>


</body>
</html>
