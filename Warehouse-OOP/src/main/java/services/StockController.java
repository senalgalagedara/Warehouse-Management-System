package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import utils.DBConnection;

public class StockController {

    /** Returns true if we successfully inserted one row into purchase_details */
    public static boolean insertData(String purchase_id,
                                     String product_id,
                                     String quantity,
                                     String price_per_unit,
                                     String purchase_date) {
        boolean success = false;
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            String sql = String.join(" ",
                "INSERT INTO purchase_details",
                "(purchase_id, product_id, quantity, price_per_unit, purchase_date)",
                "VALUES",
                "('"+purchase_id+"','"+
                      product_id+"','"+
                      quantity+"','"+
                      price_per_unit+"','"+
                      purchase_date+"')"
            );

            int rows = stmt.executeUpdate(sql);
            success = (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    /** Fetch by detail_id: returns a List of Maps (columnName → value) */
    public static List<Map<String,String>> getById(String id) {
        List<Map<String,String>> results = new ArrayList<>();
        String sql = "SELECT detail_id, purchase_id, product_id, quantity, price_per_unit, purchase_date "
                   + "FROM purchase_details WHERE detail_id = " + Integer.parseInt(id);

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String,String> row = new HashMap<>();
                row.put("detail_id",    Integer.toString(rs.getInt("detail_id")));
                row.put("purchase_id",  rs.getString("purchase_id"));
                row.put("product_id",   rs.getString("product_id"));
                row.put("quantity",     rs.getString("quantity"));
                row.put("price_per_unit", rs.getString("price_per_unit"));
                row.put("purchase_date", rs.getString("purchase_date"));
                results.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    /** Fetch all purchase_details */
    public static List<Map<String,String>> getAllPurchase() {
        List<Map<String,String>> results = new ArrayList<>();
        String sql = "SELECT detail_id, purchase_id, product_id, quantity, price_per_unit, purchase_date "
                   + "FROM purchase_details";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String,String> row = new HashMap<>();
                row.put("detail_id",     Integer.toString(rs.getInt("detail_id")));
                row.put("purchase_id",   rs.getString("purchase_id"));
                row.put("product_id",    rs.getString("product_id"));
                row.put("quantity",      rs.getString("quantity"));
                row.put("price_per_unit", rs.getString("price_per_unit"));
                row.put("purchase_date",  rs.getString("purchase_date"));
                results.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    /** Update purchase_details row by detail_id */
    public static boolean updateData(String detail_id,
                                     String purchase_id,
                                     String product_id,
                                     String quantity,
                                     String price_per_unit,
                                     String purchase_date) {
        boolean success = false;
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            String sql = String.join(" ",
                "UPDATE purchase_details SET",
                "purchase_id    = '"+purchase_id+"',",
                "product_id     = '"+product_id+"',",
                "quantity       = '"+quantity+"',",
                "price_per_unit = '"+price_per_unit+"',",
                "purchase_date  = '"+purchase_date+"'",
                "WHERE detail_id = " + Integer.parseInt(detail_id)
            );

            int rows = stmt.executeUpdate(sql);
            success = (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
