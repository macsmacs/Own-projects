package com.callcenter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class Main {
    private static LinkedList<Operator> listOfFreeOperator = new LinkedList<Operator>();
    private static LinkedList<Operator> listOfBusyOperator = new LinkedList<>();
    private static List<Call> listOfWaitingCalls = new LinkedList<>();
    private static List<Call> listOfProcessingCalls = new LinkedList<>();
    static {
        String[] name = {"Mike", "Nike", "Ryan", "Tony", "Frank",
                "Luke", "Mason", "Mitchel", "Steven", "Stew"};
        short[] id = {2354, 8745, 4895, 6798, 8123, 8932, 1237, 4958, 3049, 9142};
        for (int i = 0; i < name.length; i++)
            listOfFreeOperator.add(new Operator(name[i], id[i], "free"));
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        while (true){
            createCall();
            processingCalls();
            endingCalls();
            printProcessingCalls();
            printWaitingCalls();
            printFreeOperators();
            Thread.sleep(1000);
        }
    }
    private static void createCall(){
        int rand = rand(8);
        if(rand == 1) listOfWaitingCalls.add(new Finance(rand(9999999) + 380990000000L,
                createEndTime(rand(60000) + 20000)));
        else if(rand == 2) listOfWaitingCalls.add(new Tech(rand(9999999) + 380990000000L,
                createEndTime(rand(60000) + 20000)));
        else if(rand == 3) listOfWaitingCalls.add(new Potential(rand(9999999) + 380990000000L,
                createEndTime(rand(60000) + 20000)));
    }
    private static void processingCalls(){
        if(!listOfFreeOperator.isEmpty() && !listOfWaitingCalls.isEmpty()){
            Operator busyOperator = listOfFreeOperator.get(0);
            busyOperator.setStatus("busy");
            listOfBusyOperator.add(busyOperator);
            listOfFreeOperator.remove(0);
            listOfProcessingCalls.add(listOfWaitingCalls.get(0));
            listOfWaitingCalls.remove(0);
        }
    }
    private static Date createEndTime(int n){
        long time = new Date().getTime() + n;
        return new Date(time);
    }
    private static void endingCalls(){
        if(!listOfProcessingCalls.isEmpty()){
            for (int i = 0; i < listOfProcessingCalls.size(); ){
                if(listOfBusyOperator.get(i).getTimeToLong() > listOfProcessingCalls.get(i).getEndTime()){
                    Operator freeOperator = listOfBusyOperator.get(i);
                    freeOperator.setStatus("free");
                    freeOperator.countCalls++;
                    registrationToFile(freeOperator);
                    listOfFreeOperator.add(freeOperator);
                    listOfBusyOperator.remove(i);
                    listOfProcessingCalls.remove(i);
                }
                i++;
            }
        }
    }
    private static void registrationToFile(Operator operator){
        try {
            FileOutputStream stream = new FileOutputStream("E:/operators/"+operator.getId()+".txt");
            String str = String.format("Operator %s has processed %s calls.",
                    operator.getName(), operator.countCalls);
            for (int i = 0; i < str.length(); i++)
                stream.write(str.charAt(i));
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int rand(int i){
        return new Random().nextInt(i) + 1;
    }
    private static void printFreeOperators(){
        if(!listOfFreeOperator.isEmpty()) System.out.println("\t\t\t\t\t\tСВОБОДНЫЕ ОПЕРАТОРЫ");
        for (Operator operator : listOfFreeOperator)
            System.out.println(String.format("Оператор: %s. ID: %s. Статус: %s уже %s",
                    operator.getName(), operator.getId(), operator.getStatus(), operator.getTime()));
    }
    private static void printWaitingCalls(){
        if(!listOfWaitingCalls.isEmpty()) System.out.println("\t\t\t\t\t\tЗВОНКИ В ОЧЕРЕДИ");
        for (Call call : listOfWaitingCalls)
            System.out.println(String.format("Категория: %s. Номер: %s. Статус: %s уже %s",
                    call.getCapture(), call.getTel(), call.getStatus(), call.getTime()));
    }
    private static void printProcessingCalls(){
        if(!listOfProcessingCalls.isEmpty()) System.out.println("\t\t\t\t\t\tОБРАБОТКА ЗВОНКОВ");
        for (int i = 0; i < listOfProcessingCalls.size(); i++)
            System.out.println(String.format("Оператор %s (%s) %s (%s) по тематике %s. Время: %s",
                    listOfBusyOperator.get(i).getName(), listOfBusyOperator.get(i).getId(),
                    listOfBusyOperator.get(i).getStatus(), listOfProcessingCalls.get(i).getTel(),
                    listOfProcessingCalls.get(i).getCapture(), listOfBusyOperator.get(i).getTime()));
    }
}