package OSM.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import OSM.util.DBConnection;
import OSM.models.SalesModel;
public class SalesController {
	
	//connect DB
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs= null;
	
	//insert data function
	public static boolean insertdata(String purchase_id,String product_id,String quantity,String price_per_unit,String purchase_date) {
		boolean isSuccess = false;
		try {
			//DB CONNECTION CALL
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			//SQL QUERY
			String sql = "insert into purchase_details values(0,'"+purchase_id+"','"+product_id+"','"+quantity+"','"+price_per_unit+"','"+ purchase_date+"')";
			int rs = stmt.executeUpdate(sql);
			if( rs > 0) {
				isSuccess = true;
				
			}
			else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

  }
	//display GetById
	public static List<SalesModel> getById (String Id){
		int convertedId = Integer.parseInt(Id);
		
		ArrayList <SalesModel> stock = new ArrayList<>();
		
		try {
			//DBCONNECTION
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			//Query
			String sql = "select * from purchase_details where detail_id = '"+convertedId+"'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int detail_id = rs.getInt(1);
				String purchase_id = rs.getString(2);
				String product_id = rs.getString(3);
				String quantity = rs.getString(4);
				String price_per_unit = rs.getString(5);
				String purchase_date = rs.getString(6);
				
				SalesModel sk = new SalesModel(detail_id,purchase_id,product_id,quantity,price_per_unit,purchase_date);
				stock.add(sk);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return stock;
		
	}
	//GetAll Data
	public static List<SalesModel> getAllPurchase(){
		ArrayList <SalesModel> stocks = new ArrayList<>();
		
		try {
			//DBCONNECTION
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			//Query
			String sql = "select * from purchase_details ";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int detail_id = rs.getInt(1);
				String purchase_id = rs.getString(2);
				String product_id = rs.getString(3);
				String quantity = rs.getString(4);
				String price_per_unit = rs.getString(5);
				String purchase_date = rs.getString(6);
				
				SalesModel sk = new SalesModel(detail_id,purchase_id,product_id,quantity,price_per_unit,purchase_date);
				stocks.add(sk);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return stocks;
		
	}
	//update Data
	public static boolean updatedata(String detail_id,String purchase_id,String product_id,String quantity,String price_per_unit,String purchase_date) {
		try {
			//DBCONNECTION
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			//SQL QUERY
			String sql = "update purchase_details set purchase_id='"+purchase_id+"',product_id='"+product_id+"',quantity='"+quantity+"',price_per_unit='"+price_per_unit+"',purchase_date='"+purchase_date+"'"
					+"where id='"+detail_id+"'";
			
			int rs = stmt.executeUpdate(sql);
			if( rs > 0) {
				isSuccess = true;
				
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	//Delete Data
	public static boolean deletedata(String detail_id) {
		int convID= Integer.parseInt(detail_id);
		try {
			//DBConnection
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			String sql = "delete from purchase_details where id ='"+convID+"'";
			int rs = stmt.executeUpdate(sql);
			if( rs > 0) {
				isSuccess = true;
				
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
		}
		
	}
	
	
	
	

