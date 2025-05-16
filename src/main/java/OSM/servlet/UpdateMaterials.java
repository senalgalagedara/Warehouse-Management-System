package OSM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import OSM.models.Product;
import OSM.services.ProductController;

@WebServlet("/UpdateMaterials")
public class UpdateMaterials extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateMaterials() {
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

        boolean isTrue = ProductController.updateProduct(product);

        if (isTrue) {
            List<Product> productDetails = ProductController.getById(productID);
            request.setAttribute("productDetails", productDetails);

            String alertMessage = "Product Updated Successfully!";
            response.getWriter().println("<script>alert('" + alertMessage + "'); window.location.href='GetAllProductsServlet';</script>");
        } else {
            RequestDispatcher dis = request.getRequestDispatcher("wrong.jsp");
            dis.forward(request, response);
        }
    }
}
