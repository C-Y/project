package com.it.domain;


import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class Product {

  private long id;
  private String productNum;
  private String productName;
  private String cityName;
 //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date departureTime;
  private double productPrice;
  private String productDesc;
  private long productStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public long getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(long productStatus) {
        this.productStatus = productStatus;
    }
}
