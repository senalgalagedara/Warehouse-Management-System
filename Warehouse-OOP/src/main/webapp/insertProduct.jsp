<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Add Product</title></head>
<body>
<h2>Add New Product</h2>
<form action="${pageContext.request.contextPath}/addProduct" method="post">
    <input type="hidden" name="action" value="insert"/>
    Product ID: <input type="text" name="productID" required/><br/>
    Name:       <input type="text" name="productName" required/><br/>
    Brand:      <input type="text" name="brand"/><br/>
    Quantity:   <input type="number" name="quantity"/><br/>
    Price:      <input type="text" name="price"/><br/>
    Manufactured Date: <input type="date" name="manufacturedDate"/><br/>
    Expired Date:      <input type="date" name="expiredDate"/><br/><br/>
    <input type="submit" value="Add Product"/>
</form>
</body>
</html>
