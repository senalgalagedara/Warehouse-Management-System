package OSM.models;

public class Sales {
	private int detail_id;
	private String purchase_id;
	private String product_id;
	
	public Sales() {
		
	}
	
	public Sales(int detail_id, String purchase_id, String product_id) {
		this.detail_id = detail_id;
		this.purchase_id = purchase_id;
		this.product_id = product_id;
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

}
