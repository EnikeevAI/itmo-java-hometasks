package ru.itmo.lessons.lesson8.school;

import ru.itmo.lessons.lesson8.school.base.Person;

public class Director extends Person {
    public Director(String name, int age) {
        super(name, age);
    }

    public void startClasses() {
        System.out.println(String.format("Директо %s объявляет начало занятий!", this.getName()));
    }

    public void finishClasses() {
        System.out.println(String.format("Директо %s объявляет конец занятий!", this.getName()));
    }
}
