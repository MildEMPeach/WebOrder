package org.mildempeach.entity;

public class Review {
    private long instrumentid;
    private long userid;
    private String comment;

    public Review(long instrumentid, long userid, String comment) {
        this.instrumentid = instrumentid;
        this.userid = userid;
        this.comment = comment;
    }

    public long getInstrumentid() {
        return instrumentid;
    }

    public void setInstrumentid(long instrumentid) {
        this.instrumentid = instrumentid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
