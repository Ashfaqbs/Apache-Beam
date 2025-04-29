package com.example.dto;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.extensions.avro.coders.AvroCoder;

@DefaultCoder(AvroCoder.class)
public class CleanProduct {
    String id, name, brand;
    double finalPrice;
    int stock;

    public CleanProduct() {
    }

    public CleanProduct(String id, String name, String brand, double finalPrice, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.finalPrice = finalPrice;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "CleanProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", finalPrice=" + finalPrice +
                ", stock=" + stock +
                '}';
    }
}