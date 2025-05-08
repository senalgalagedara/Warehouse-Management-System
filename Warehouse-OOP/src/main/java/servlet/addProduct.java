package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import services.ProductController;
import model.Product;

@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String brand = request.getParameter("brand");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        String manufacturedDate = request.getParameter("manufacturedDate");
        String expiredDate = request.getParameter("expiredDate");

        Product product = new Product();
        product.setProductID(productId);
        product.setProductName(productName);
        product.setBrand(brand);
        product.setQuantity(Integer.parseInt(quantity)); 
        product.setPrice(Double.parseDouble(price)); 
        product.setManufacturedDate(java.sql.Date.valueOf(manufacturedDate)); 
        product.setExpiredDate(java.sql.Date.valueOf(expiredDate)); 

        boolean isAdded = ProductController.addProduct(product);

        if (isAdded) {
            String alertMessage = "Product Added Successfully!";
            response.getWriter().println("<script> alert('" + alertMessage + "'); window.location.href='adminProduct';</script>");
        } else {
            RequestDispatcher dis = request.getRequestDispatcher("error.jsp");    
            dis.forward(request, response);
        }
    }
}
