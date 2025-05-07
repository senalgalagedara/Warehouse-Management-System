<%@ page import="model.Product" %>
<%
    Product p = (Product) request.getAttribute("product");
%>
<html>
<head><title>Edit Product</title></head>
<body>
<h2>Edit Product</h2>
<form action="ProductController" method="post">
    <input type="hidden" name="action"      value="update"/>
    <input type="hidden" name="productID"   value="<%=p.getProductID()%>"/>
    Name:       <input type="text" name="productName"       value="<%=p.getProductName()%>" required/><br/>
    Brand:      <input type="text" name="brand"             value="<%=p.getBrand()%>"/><br/>
    Quantity:   <input type="number" name="quantity"        value="<%=p.getQuantity()%>"/><br/>
    Price:      <input type="text" name="price"             value="<%=p.getPrice()%>"/><br/>
    Manufactured Date: <input type="date" name="manufacturedDate"
                              value="<%=p.getManufacturedDate()%>"/><br/>
    Expired Date:      <input type="date" name="expiredDate"
                              value="<%=p.getExpiredDate()%>"/><br/><br/>
    <input type="submit" value="Update Product"/>
</form>
<p><a href="ProductController">← Back to Product List</a></p>
</body>
</html>
