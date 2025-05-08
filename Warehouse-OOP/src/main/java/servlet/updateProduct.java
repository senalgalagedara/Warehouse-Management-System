// servlet/updateProduct.java
package servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import model.Product;
import services.ProductController;

@WebServlet("/updateProduct")
public class updateProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Product p = new Product();
        p.setProductID(request.getParameter("productId"));
        p.setProductName(request.getParameter("productName"));
        p.setBrand(request.getParameter("brand"));
        p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setManufacturedDate(Date.valueOf(request.getParameter("manufacturedDate")));
        p.setExpiredDate(Date.valueOf(request.getParameter("expiredDate")));

        new ProductController().updateProduct(p);
        RequestDispatcher rd = request.getRequestDispatcher("adminProduct");
        rd.forward(request, response);
    }
}
