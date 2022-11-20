package ru.itmo.lessons.lesson25;

import java.util.concurrent.CopyOnWriteArrayList;

public class Application {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        UserStringToListTask task01 = new UserStringToListTask(list);
        Thread thread01 = new Thread(task01);
        thread01.setDaemon(true);

        MinWordToFileTask task02 = new MinWordToFileTask(list);
        Thread thread02 = new Thread(task02);

        thread01.start();
        thread02.start();

        try {
            thread02.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
