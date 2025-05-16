 package OSM.models;

public class DriverModel extends DriverVehiType {
	
	private  String address;
	private  String phone_number;
	private  String email;
	
	
	public DriverModel(int id,  String name,  String license_number,  String address,  String phone_number,
			 String vehicle_type,  String email) {
		super(id,name,license_number,vehicle_type);
		
		this.address = address;
		this.phone_number = phone_number;
		this.email = email;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
