package OSM.models;

public class ProductBrand {
    protected String productID;
    protected String productName;
    protected String brand;

    public ProductBrand() {
    }

    public ProductBrand(String productID, String productName, String brand) {
        this.productID = productID;
        this.productName = productName;
        this.brand = brand;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
