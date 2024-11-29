package org.mildempeach.entity;

public class Cart {
    private long userid;
    private long instrumentid;
    private String instrumentname;
    private int number;
    private double price;
    private double weight;
    public long getUserid() {
        return userid;
    }
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public long getInstrumentid() {
        return instrumentid;
    }
    public void setInstrumentid(long instrumentid) {
        this.instrumentid = instrumentid;
    }
    public String getInstrumentname() {
        return instrumentname;
    }
    public void setInstrumentname(String instrumentname) {
        this.instrumentname = instrumentname;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

}
