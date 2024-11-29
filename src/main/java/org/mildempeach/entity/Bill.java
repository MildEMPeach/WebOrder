package org.mildempeach.entity;

public class Bill {
    private long id;
    private long customerid;
    private double amount;
    private double weight;

    public Bill(long customerid, double amount, double weight) {
        this.customerid = customerid;
        this.amount = amount;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getCustomerid() {
        return customerid;
    }
    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
