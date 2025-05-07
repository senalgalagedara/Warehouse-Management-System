package model;

public class StockModel {
	
	private int detail_id;
	private String purchase_id;
	private String product_id;
	private String quantity;
	private String price_per_unit;
	private String purchase_date;
	
	public StockModel(int detail_id, String purchase_id, String product_id, String quantity, String price_per_unit,
			String purchase_date) {
		super();
		this.detail_id = detail_id;
		this.purchase_id = purchase_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price_per_unit = price_per_unit;
		this.purchase_date = purchase_date;
	}

	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}

	public String getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
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
