package com.it.domain;


import java.util.Date;

public class Orders {
  private long id;
  private String orderNum;
  private Date orderTime;
  private long peopleCount;
  private String orderDesc;
  private long payType;
  private long orderStatus;
  //订单对应的产品
  private Product product;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(String orderNum) {
    this.orderNum = orderNum;
  }

  public Date getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(Date orderTime) {
    this.orderTime = orderTime;
  }

  public long getPeopleCount() {
    return peopleCount;
  }

  public void setPeopleCount(long peopleCount) {
    this.peopleCount = peopleCount;
  }

  public String getOrderDesc() {
    return orderDesc;
  }

  public void setOrderDesc(String orderDesc) {
    this.orderDesc = orderDesc;
  }

  public long getPayType() {
    return payType;
  }

  public void setPayType(long payType) {
    this.payType = payType;
  }

  public long getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(long orderStatus) {
    this.orderStatus = orderStatus;
  }



  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "Orders{" +
            "id=" + id +
            ", orderNum='" + orderNum + '\'' +
            ", orderTime=" + orderTime +
            ", peopleCount=" + peopleCount +
            ", orderDesc='" + orderDesc + '\'' +
            ", payType=" + payType +
            ", orderStatus=" + orderStatus +
            ", product=" + product +
            '}';
  }
}
