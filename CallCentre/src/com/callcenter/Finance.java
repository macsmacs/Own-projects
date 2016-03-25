package com.callcenter;
import java.util.Date;
class Finance extends Call {
    public Finance(long tel, Date endTime) {
        super(tel, endTime);
    }
    @Override
    public String toString() {
        return "Finance";
    }
}