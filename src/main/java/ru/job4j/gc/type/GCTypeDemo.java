package ru.job4j.gc.type;

import java.util.Random;

public class GCTypeDemo {

    public static void main(String[] args) {
        System.out.println("PID процесса: " + ProcessHandle.current().pid());
        Random random = new Random();
        int length = 100;
        String[] data = new String[1_000_000];
        for (int i = 0; ; i = (i + 1) % data.length) {
            data[i] = String.valueOf(
                    (char) random.nextInt(255)
            ).repeat(length);
        }
    }
}
