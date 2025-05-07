<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<html>
<head><title>Products</title></head>
<body>
<h2>Product Inventory</h2>
<p><a href="ProductController?action=new">Add New Product</a></p>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th><th>Name</th><th>Brand</th><th>Qty</th>
        <th>Price</th><th>Manuf. Date</th><th>Exp. Date</th><th>Actions</th>
    </tr>
    <%
        List<Product> list = (List<Product>)request.getAttribute("listProducts");
        for(Product p : list) {
    %>
    <tr>
        <td><%=p.getProductID()%></td>
        <td><%=p.getProductName()%></td>
        <td><%=p.getBrand()%></td>
        <td><%=p.getQuantity()%></td>
        <td><%=p.getPrice()%></td>
        <td><%=p.getManufacturedDate()%></td>
        <td><%=p.getExpiredDate()%></td>
        <td>
            <a href="ProductController?action=edit&productID=<%=p.getProductID()%>">Edit</a>
            |
            <a href="ProductController?action=delete&productID=<%=p.getProductID()%>"
               onclick="return confirm('Delete this product?');">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
