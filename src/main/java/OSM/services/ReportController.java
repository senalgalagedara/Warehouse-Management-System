package OSM.services;

import java.sql.*;
import java.util.*;

import OSM.models.Report;
import OSM.util.DBConnection;

public class ReportController {

    public static List<Report> getAllReports() {
        List<Report> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.prepareStatement("SELECT * FROM reports").executeQuery();
            while (rs.next()) {
                Report r = new Report();
                r.setId(rs.getInt("id"));
                r.setType(rs.getString("type"));
                r.setTitle(rs.getString("title"));
                r.setDetail(rs.getString("detail"));
                r.setDate(rs.getString("date"));
                r.setValue(rs.getString("value"));
                list.add(r);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

   
    public static void insertReport(Report r) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO reports (type, title, detail, date, value) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, r.getType());
            ps.setString(2, r.getTitle());
            ps.setString(3, r.getDetail());
            ps.setString(4, r.getDate());
            ps.setString(5, r.getValue());
            ps.executeUpdate();
            System.out.println("✅ Report inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void updateReport(Report r) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE reports SET type=?, title=?, detail=?, date=?, value=? WHERE id=?"
            );
            ps.setString(1, r.getType());
            ps.setString(2, r.getTitle());
            ps.setString(3, r.getDetail());
            ps.setString(4, r.getDate());
            ps.setString(5, r.getValue());
            ps.setInt(6, r.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void deleteReport(int id) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM reports WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
