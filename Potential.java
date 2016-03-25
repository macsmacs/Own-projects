package com.callcenter;

import java.util.Date;

/**
 * Created by Роман on 20.03.2016.
 */
class Potential extends Call {
    public Potential(long tel, Date endTime) {
        super(tel, endTime);
    }
    @Override
    public String toString() {
        return "Potential";
    }
}
