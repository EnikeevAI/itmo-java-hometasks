package ru.itmo.lessons.lesson8.school.base;

abstract public class Person {
    private final String name;
    private int age;


    public Person(String name, int age) {
        if (name.length() < 2) throw new IllegalArgumentException("Имя должно состоять хотя бы из двух буквы");
        this.name = name;

        if (age < 0) throw new IllegalArgumentException("Возраст человека не может быть отрицательным");
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }
}
