package OSM.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import OSM.models.DriverModel;
import OSM.util.DBConnection;

public class DriverController {
  //connect DB
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement  stmt=null;  
	private static  ResultSet rs =null;
	
	//Insert data function
    public  static boolean insertdata(String name,String license_number,String address, String phone_number,String vehicle_type, String email){
    	
    	boolean isSuccess= false;
    	
    	try {
    		//DB connection call
    		
    		con=DBConnection.getConnection();
    		stmt=con.createStatement();
    		
    		//SQL Query
    		
    		String sql = "insert into driver values (0,'"+name+"','"+license_number+"','"+address+"','"+phone_number+"','"+vehicle_type+"','"+email+"')";
    		int rs =stmt.executeUpdate(sql);
    		if(rs>0) {
    			isSuccess= true;
    		}
    		else {
    			isSuccess= false;
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return isSuccess;
    }
    

    
    //GetByID
	public static List<DriverModel>getByid(String ID){
		int convertedID = Integer.parseInt(ID);
		
		ArrayList <DriverModel> driver = new ArrayList<>();
		
		try {
			//DB connection
    		con=DBConnection.getConnection();
    		stmt=con.createStatement();
    		
    		//Query
    		String sql = "select * from driver where id ='"+convertedID+"'";
    		
    		rs = stmt.executeQuery(sql);
    		while (rs.next()) {
    			int id = rs.getInt(1);
    			String name=rs.getString(2);
    			String license_number=rs.getString(3);
    			String address=rs.getString(4);
    			String phone_number=rs.getString(5);
    			String vehicle_type=rs.getString(6);
    			String email=rs.getString(7);
    			
    			DriverModel dm = new DriverModel(id,name,license_number,address,phone_number,vehicle_type, email);
    			driver.add(dm);
    		}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	
	//getall

	public static List<DriverModel> getAllDriver(){
		
		ArrayList <DriverModel> drivers = new ArrayList<>();
		
		try {
			//DB connection
    		con=DBConnection.getConnection();
    		stmt=con.createStatement();
    		
    		//Query
    		String sql = "select * from driver";
    		
    		rs = stmt.executeQuery(sql);
    		while (rs.next()) {
    			int id = rs.getInt(1);
    			String name=rs.getString(2);
    			String license_number=rs.getString(3);
    			String address=rs.getString(4);
    			String phone_number=rs.getString(5);
    			String vehicle_type=rs.getString(6);
    			String email=rs.getString(7);
    			
    			DriverModel dm = new DriverModel(id,name,license_number,address,phone_number,vehicle_type, email);
    			drivers.add(dm);
    		}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return drivers;
		
	}
	public  static boolean updatedata(String id,String name,String license_number,String address,String phone_number,String vehicle_type,String email) {
		try {
			//DB connection
    		con=DBConnection.getConnection();
    		stmt=con.createStatement();
    		
    		String sql="update driver set name='"+name+"', license_number='"+license_number+"',address='"+address+"' , phone_number= '"+phone_number+"' , vehicle_type= '"+vehicle_type+"',email='"+email+"'"
    				+"where id ='"+id+"'";
    		
    	int rs = stmt.executeUpdate(sql);
    	
    	if(rs>0) {
			isSuccess= true;
		}
		else {
			isSuccess= false;
		}
    	
    	
		  }catch(Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}
	//deletedata
	public static boolean deletedata(String id) {
		int convID = Integer.parseInt(id);
		try {
			//DB connection
    		con=DBConnection.getConnection();
    		stmt=con.createStatement();
    		String sql="delete from driver where id='"+convID+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs>0) {
    			isSuccess= true;
    		}
    		else {
    			isSuccess= false;
    		}
        	
    		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
}
