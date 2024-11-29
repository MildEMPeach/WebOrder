package org.mildempeach.entity;

public class Record {
    private long billid;
    private long customerid;
    private long instrumentid;
    private String instrumentname;
    private int number;

    public Record(long billid, long customerid, long instrumentid, String instrumentname, int number) {
        this.billid = billid;
        this.customerid = customerid;
        this.instrumentid = instrumentid;
        this.instrumentname = instrumentname;
        this.number = number;
    }

    public long getBillid() {
        return billid;
    }
    public void setBillid(long billid) {
        this.billid = billid;
    }
    public long getCustomerid() {
        return customerid;
    }
    public void setCustomerid(long customerid) {
        this.customerid = customerid;
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
}
