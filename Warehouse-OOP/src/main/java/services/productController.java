package services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import utils.DBConnection;

public class ProductController { 

    public static boolean addProduct(Product p) {
        String sql = """
            INSERT INTO product
              (product_id, product_name, brand, quantity, price, manufactured_date, expired_date)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getProductID());
            ps.setString(2, p.getProductName());
            ps.setString(3, p.getBrand());
            ps.setInt   (4, p.getQuantity());
            ps.setDouble(5, p.getPrice());
            ps.setDate  (6, new java.sql.Date(p.getManufacturedDate().getTime()));
            ps.setDate  (7, new java.sql.Date(p.getExpiredDate().getTime()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error adding product: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        List<Product> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product();
                p.setProductID       (rs.getString("product_id"));
                p.setProductName     (rs.getString("product_name"));
                p.setBrand           (rs.getString("brand"));
                p.setQuantity        (rs.getInt   ("quantity"));
                p.setPrice           (rs.getDouble("price"));
                p.setManufacturedDate(rs.getDate  ("manufactured_date"));
                p.setExpiredDate     (rs.getDate  ("expired_date"));
                list.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching products: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public static boolean updateProduct(Product p) {
        String sql = """
            UPDATE product SET
              product_name      = ?,
              brand             = ?,
              quantity          = ?,
              price             = ?,
              manufactured_date = ?,
              expired_date      = ?
            WHERE product_id = ?
            """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getProductName());
            ps.setString(2, p.getBrand());
            ps.setInt   (3, p.getQuantity());
            ps.setDouble(4, p.getPrice());
            ps.setDate  (5, new java.sql.Date(p.getManufacturedDate().getTime()));
            ps.setDate  (6, new java.sql.Date(p.getExpiredDate().getTime()));
            ps.setString(7, p.getProductID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error updating product: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteProduct(String productId) {
        String sql = "DELETE FROM product WHERE product_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, productId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
