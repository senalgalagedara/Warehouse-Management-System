package OSM.models;

public class DriverVehiType {
	private int id;
	private  String name;
	private  String vehicle_type;
	private  String license_number;
	
	public DriverVehiType(int id, String name, String vehicle_type, String license_number) {
		this.id = id;
		this.name = name;
		this.license_number = license_number;
		this.vehicle_type = vehicle_type;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLicense_number() {
		return license_number;
	}


	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}


	public String getVehicle_type() {
		return vehicle_type;
	}


	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

}
