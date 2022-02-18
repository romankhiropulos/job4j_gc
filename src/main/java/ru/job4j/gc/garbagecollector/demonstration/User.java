package ru.job4j.gc.garbagecollector.demonstration;

public class User {

    private int age;

    private String name;

    private final Count countDeletedObj;

    public User(int age, String name, Count countDeletedObj) {
        this.age = age;
        this.name = name;
        this.countDeletedObj = countDeletedObj;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
        System.out.println("Removed count " + countDeletedObj.incrementAndGet());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
