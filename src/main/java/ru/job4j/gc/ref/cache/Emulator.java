package ru.job4j.gc.ref.cache;

import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) {
        new Emulator().run();
    }

    public void run() {
        System.out.println("Enter directory: ");
        Scanner console = new Scanner(System.in);
        String cachingDir = console.nextLine();
        AbstractCache<String, String> fileCache = new DirFileCache(cachingDir);
        String key;
        do {
            System.out.println("Enter file name or \"Q\" for quit.");
            key = console.nextLine();
            if (!key.equals("Q")) {
                try {
                    String contents = fileCache.load(key);
                    System.out.printf("This is files data: %n%s%n", contents);
                } catch (Exception e) {
                    System.out.printf("Exception: %s", e.getMessage());
                }
            }
        }
        while (!key.equals("Q"));
    }
}
