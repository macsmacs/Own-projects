package com.callcenter;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by Роман on 18.03.2016.
 */
class Operator {
    private final String name;
    private final short id;
    private String status;
    private Date time;
    public int countCalls;
    public Operator(String name, short id, String status) {
        this.name = name;
        this.id = id;
        this.status = status;
        this.time = new Date();
        this.countCalls = 0;
    }
    public void setStatus(String status) {
        this.status = status;
        this.time = new Date();
    }
    public String getStatus() {
        return status.equals("free") ? "в ожидании звонка" : "в обработке звонка";
    }
    public short getId() {
        return id;
    }
    public String getTime() {
        Date current = new Date();
        long realTime = current.getTime() - time.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        current.setTime(realTime);
        current.setHours(0);
        return dateFormat.format(current);
    }
    public long getTimeToLong() {
        return new Date().getTime();
    }
    public String getName() {
        return name;
    }
}