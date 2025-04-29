package com.example.dto;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.extensions.avro.coders.AvroCoder;

@DefaultCoder(AvroCoder.class)
public class ProductFlat {
    String productId, productName, category, brand, currency, warehouse, color, dimensions, status, releaseDate, updatedAt;
    double price, discount, rating;
    int availableStock, reviewCount;

    public ProductFlat() {
    }

    public ProductFlat(String productId, String productName, String category, String brand, String currency, String warehouse, String color, String dimensions, String status, String releaseDate, String updatedAt, double price, double discount, double rating, int availableStock, int reviewCount) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.brand = brand;
        this.currency = currency;
        this.warehouse = warehouse;
        this.color = color;
        this.dimensions = dimensions;
        this.status = status;
        this.releaseDate = releaseDate;
        this.updatedAt = updatedAt;
        this.price = price;
        this.discount = discount;
        this.rating = rating;
        this.availableStock = availableStock;
        this.reviewCount = reviewCount;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public String getCurrency() {
        return currency;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public String getColor() {
        return color;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getStatus() {
        return status;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getRating() {
        return rating;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Override
    public String toString() {
        return "ProductFlat{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", currency='" + currency + '\'' +
                ", warehouse='" + warehouse + '\'' +
                ", color='" + color + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", status='" + status + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", rating=" + rating +
                ", availableStock=" + availableStock +
                ", reviewCount=" + reviewCount +
                '}';
    }
}
