package OSM.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import OSM.models.Product;
import OSM.util.DBConnection;

public class ProductController { 

	public static boolean addProduct(Product p) {
	    boolean isSuccess = false;

	    try {
	        Connection conn = DBConnection.getConnection();
	        String sql = "INSERT INTO product(productID, productName, brand, quantity, price, manufacturedDate, expiredDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, p.getProductID());
	        ps.setString(2, p.getProductName());
	        ps.setString(3, p.getBrand());
	        ps.setInt(4, p.getQuantity());
	        ps.setDouble(5, p.getPrice());
	        ps.setDate(6, new java.sql.Date(p.getManufacturedDate().getTime()));
	        ps.setDate(7, new java.sql.Date(p.getExpiredDate().getTime()));

	        int rowsInserted = ps.executeUpdate();
	        if (rowsInserted > 0) {
	            isSuccess = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	}

	public static List<Product> getAllProducts() {
	    List<Product> productList = new ArrayList<>();

	    try {
	        Connection conn = DBConnection.getConnection();
	        String sql = "SELECT * FROM product order by productID ASC";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Product p = new Product();
	            p.setProductID(rs.getString("productID"));
	            p.setProductName(rs.getString("productName"));
	            p.setBrand(rs.getString("brand"));
	            p.setQuantity(rs.getInt("quantity"));
	            p.setPrice(rs.getDouble("price"));
	            p.setManufacturedDate(rs.getDate("manufacturedDate"));
	            p.setExpiredDate(rs.getDate("expiredDate"));

	            productList.add(p);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return productList;
	}

	public static boolean updateProduct(Product p) {
	    boolean isSuccess = false;

	    try {
	        Connection conn = DBConnection.getConnection();
	        String sql = "UPDATE product SET productName=?, brand=?, quantity=?, price=?, manufacturedDate=?, expiredDate=? WHERE productID=?";
	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, p.getProductName());
	        ps.setString(2, p.getBrand());
	        ps.setInt(3, p.getQuantity());
	        ps.setDouble(4, p.getPrice());
	        ps.setDate(5, new java.sql.Date(p.getManufacturedDate().getTime()));
	        ps.setDate(6, new java.sql.Date(p.getExpiredDate().getTime()));
	        ps.setString(7, p.getProductID());

	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            isSuccess = true;
	        }

	    } catch (Exception e) {
	        System.err.println("Error updating product: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return isSuccess;
	}
	public static List<Product> getById(String productID) {
	    ArrayList<Product> productList = new ArrayList<>();

	    try {
	        Connection conn = DBConnection.getConnection();
	        Statement stmt = conn.createStatement();

	        String sql = "SELECT * FROM product WHERE productID = '" + productID + "'";
	        ResultSet rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	            String id = rs.getString("productID");
	            String name = rs.getString("productName");
	            String brand = rs.getString("brand");
	            int quantity = rs.getInt("quantity");
	            double price = rs.getDouble("price");
	            java.sql.Date manufacturedDate = rs.getDate("manufacturedDate");
	            java.sql.Date expiredDate = rs.getDate("expiredDate");

	            Product product = new Product();
	            product.setProductID(id);
	            product.setProductName(name);
	            product.setBrand(brand);
	            product.setQuantity(quantity);
	            product.setPrice(price);
	            product.setManufacturedDate(manufacturedDate);
	            product.setExpiredDate(expiredDate);

	            productList.add(product);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return productList;
	}


	public static boolean deleteProduct(String productID) {
	    boolean isSuccess = false;

	    try {
	        Connection conn = DBConnection.getConnection();
	        Statement stmt = conn.createStatement();

	        String sql = "DELETE FROM product WHERE productID = '" + productID + "'";
	        int rowsAffected = stmt.executeUpdate(sql);

	        if (rowsAffected > 0) {
	            isSuccess = true;
	        }

	    } catch (Exception e) {
	        System.err.println("Error deleting product: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

}
