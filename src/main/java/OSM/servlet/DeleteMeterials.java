package OSM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import OSM.services.ProductController;
import OSM.models.Product;

@WebServlet("/DeleteMeterials")
public class DeleteMeterials extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteMeterials() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productID = request.getParameter("productID");
        boolean isTrue = ProductController.deleteProduct(productID);

        if (isTrue) {
            String alertMessage = "Product Deleted Successfully!";
            response.getWriter().println("<script>alert('" + alertMessage + "'); window.location.href='GetAllProductsServlet';</script>");
        } else {
            List<Product> productDetails = ProductController.getById(productID);
            request.setAttribute("productDetails", productDetails);
            RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
            dispatcher.forward(request, response);
        }
    }
}
