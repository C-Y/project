package com.it.domain;


import java.util.Date;

public class SysLog {

  private long id;
  private Date visitTime;
  private String username;
  private String ip;
  private String method;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public Date getVisitTime() {
    return visitTime;
  }

  public void setVisitTime(Date visitTime) {
    this.visitTime = visitTime;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }


  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

}
