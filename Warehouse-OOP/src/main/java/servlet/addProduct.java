// servlet/addProduct.java
package servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Product;
import services.ProductService;

@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Product p = new Product();
        p.setProductId(Integer.parseInt(request.getParameter("productId")));
        p.setProductName(request.getParameter("productName"));
        p.setBrand(request.getParameter("brand"));
        p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setManufacturedDate(Date.valueOf(request.getParameter("manufacturedDate")));
        p.setExpiredDate(Date.valueOf(request.getParameter("expiredDate")));

        new ProductService().addProduct(p);
        response.sendRedirect("adminProduct");
    }
}
