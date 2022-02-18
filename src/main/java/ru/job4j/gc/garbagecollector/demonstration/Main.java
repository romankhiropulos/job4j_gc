package ru.job4j.gc.garbagecollector.demonstration;

import ru.job4j.gc.garbagecollector.GCDemo;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GCDemo gcDemo = new GCDemo();
        gcDemo.info();

        System.gc();
        Thread.sleep(1000);
        gcDemo.info();

        Count countDeletedObj = new Count();
        for (int i = 0; i < 10000; i++) {
            new User(i, "Name" + i, countDeletedObj);
            Thread.sleep(5);
        }

        gcDemo.info();
    }
}

class Count {

    private int countOfDeletedObj = 0;

    public int incrementAndGet() {
        return ++countOfDeletedObj;
    }
}