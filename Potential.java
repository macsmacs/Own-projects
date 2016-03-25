package com.callcenter;
import java.util.Date;
class Potential extends Call {
    public Potential(long tel, Date endTime) {
        super(tel, endTime);
    }
    @Override
    public String toString() {
        return "Potential";
    }
}
