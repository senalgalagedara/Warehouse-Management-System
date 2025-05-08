package model;

import java.sql.Date;

public class Product {
    private String productID;
    private String productName;
    private String brand;
    private int quantity;
    private double price;
    private Date manufacturedDate;
    private Date expiredDate;

    public Product() {
    }

    public Product(String productID,
                   String productName,
                   String brand,
                   int quantity,
                   double price,
                   Date manufacturedDate,
                   Date expiredDate) {
        this.productID        = productID;
        this.productName      = productName;
        this.brand            = brand;
        this.quantity         = quantity;
        this.price            = price;
        this.manufacturedDate = manufacturedDate;
        this.expiredDate      = expiredDate;
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
