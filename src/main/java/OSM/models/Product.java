package OSM.models;

import java.sql.Date;

public class Product extends ProductBrand {
    private int quantity;
    private double price;
    private Date manufacturedDate;
    private Date expiredDate;

    public Product() {
        super();
    }

    public Product(String productID,
                   String productName,
                   String brand,
                   int quantity,
                   double price,
                   Date manufacturedDate,
                   Date expiredDate) {

        super(productID, productName, brand);
        this.quantity = quantity;
        this.price = price;
        this.manufacturedDate = manufacturedDate;
        this.expiredDate = expiredDate;
    }

    // Getters and Setters
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(Date manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    // toString method for printing object details
    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", manufacturedDate=" + manufacturedDate +
                ", expiredDate=" + expiredDate +
                '}';
    }
}
