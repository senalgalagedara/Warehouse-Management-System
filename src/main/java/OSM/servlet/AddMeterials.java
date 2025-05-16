package OSM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OSM.models.Product;
import OSM.services.ProductController;

@WebServlet("/AddMeterials")
public class AddMeterials extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddMeterials() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String brand = request.getParameter("brand");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String manufacturedDate = request.getParameter("manufacturedDate");
        String expiredDate = request.getParameter("expiredDate");

        Product product = new Product();
        product.setProductID(productID);
        product.setProductName(productName);
        product.setBrand(brand);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setManufacturedDate(java.sql.Date.valueOf(manufacturedDate));
        product.setExpiredDate(java.sql.Date.valueOf(expiredDate));

        boolean isTrue = ProductController.addProduct(product);

        if (isTrue) {
            String alertMessage = "Product Added Successfully!";
            response.getWriter().println("<script>alert('" + alertMessage + "'); window.location.href='StockDashboard.jsp';</script>");
        } else {
            RequestDispatcher dis = request.getRequestDispatcher("error.jsp");
            dis.forward(request, response);
        }
    }
}
