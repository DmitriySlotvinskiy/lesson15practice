package com.slotvinskiy.time_span;

public class Main {

    public static void main(String[] args) {

        TimeSpan ts1 = new TimeSpan(1, 30);
        TimeSpan ts2 = new TimeSpan(1, 10);

        System.out.println("TimeSpan ts1 is: " + ts1.toString());
        System.out.println("TimeSpan ts2 is: " + ts2.toString());
        ts1.add(ts2);
        System.out.println("Do ts1.add(ts2);");
        System.out.println("Now TimeSpan ts1 is: " + ts1.toString());
        ts1.sub(ts2);
        System.out.println("Do ts1.sub(ts2);");
        System.out.println("Now TimeSpan ts1 is: " + ts1.toString());
        ts2.mult(0.5);
        System.out.println("ts2.mult(0.5);");
        System.out.println("Now TimeSpan ts2 is: " + ts2.toString());

    }
}