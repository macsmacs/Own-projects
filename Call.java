package com.callcenter;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by Роман on 20.03.2016.
 */
abstract class Call {
    private long tel;
    private Date time;
    private Date endTime;
    protected Call(long tel, Date endTime) {
        this.tel = tel;
        this.time = new Date();
        this.endTime = endTime;
    }
    protected String getTel() {
        return "+" + tel;
    }
    protected long getEndTime() {
        return endTime.getTime();
    }
    protected String getTime() {
        Date current = new Date();
        long realTime = current.getTime() - this.time.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        current.setTime(realTime);
        current.setHours(0);
        return dateFormat.format(current);
    }
    protected String getStatus() {
        return "в ожидании";
    }
    protected String getCapture() {
        return String.valueOf(this);
    }
    public abstract String toString();
}