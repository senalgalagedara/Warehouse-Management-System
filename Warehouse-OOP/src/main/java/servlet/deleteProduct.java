// servlet/deleteProduct.java
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import services.ProductController;

@WebServlet("/deleteProduct")
public class deleteProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("productId");
        new ProductController();
		ProductController.deleteProduct(id);
        RequestDispatcher rd = request.getRequestDispatcher("adminProduct");
        rd.forward(request, response);
    }
}
