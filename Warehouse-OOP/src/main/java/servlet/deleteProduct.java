// servlet/deleteProduct.java
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import services.ProductService;

@WebServlet("/deleteProduct")
public class deleteProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("productId"));
        new ProductService().deleteProduct(id);
        RequestDispatcher rd = request.getRequestDispatcher("adminProduct");
        rd.forward(request, response);
    }
}
