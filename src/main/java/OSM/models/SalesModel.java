package OSM.models;

public class SalesModel extends Sales {
	
	private String quantity;
	private String price_per_unit;
	private String purchase_date;
	
	public SalesModel(int detail_id, String purchase_id, String product_id, String quantity, String price_per_unit,
			String purchase_date) {
		super(detail_id,purchase_id,product_id);
		this.quantity = quantity;
		this.price_per_unit = price_per_unit;
		this.purchase_date = purchase_date;
	}
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice_per_unit() {
		return price_per_unit;
	}

	public void setPrice_per_unit(String price_per_unit) {
		this.price_per_unit = price_per_unit;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	
	

}
