package com.callcenter;

import java.util.Date;

/**
 * Created by Роман on 20.03.2016.
 */
class Tech extends Call {
    public Tech(long tel, Date endTime) {
        super(tel, endTime);
    }
    @Override
    public String toString() {
        return "Tech";
    }
}
