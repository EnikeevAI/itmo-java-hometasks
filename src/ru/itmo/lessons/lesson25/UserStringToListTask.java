package ru.itmo.lessons.lesson25;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserStringToListTask implements Runnable{

    Scanner sc;

    CopyOnWriteArrayList<String> list;

    public UserStringToListTask(CopyOnWriteArrayList<String> list) {
        sc = new Scanner(System.in);
        this.list = list;
    }

    private String getUserWord() {
        System.out.println("Введите слово");
        return sc.nextLine();
    }

    private void putUserWordToList() {
        list.add(getUserWord());
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            putUserWordToList();
            //System.out.println(!Thread.currentThread().isInterrupted() +"   "+ Thread.currentThread().getName());
        }

    }
}
