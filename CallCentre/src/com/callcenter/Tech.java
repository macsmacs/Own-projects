package com.callcenter;
import java.util.Date;
class Tech extends Call {
    public Tech(long tel, Date endTime) {
        super(tel, endTime);
    }
    @Override
    public String toString() {
        return "Tech";
    }
}
