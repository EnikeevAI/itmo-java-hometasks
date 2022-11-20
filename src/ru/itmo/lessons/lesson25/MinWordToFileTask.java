package ru.itmo.lessons.lesson25;

import java.util.concurrent.CopyOnWriteArrayList;

public class MinWordToFileTask implements Runnable{

    BinHandler bh;

    CopyOnWriteArrayList<String> list;

    public MinWordToFileTask(CopyOnWriteArrayList<String> list) {
        bh = new BinHandler<>();
        this.list = list;
    }

    private void waitThirtySeconds() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private String getMinListWord(CopyOnWriteArrayList<String> list) {
        return list.stream().min((w1, w2) -> (int) (w1.length() - w2.length())).get();
    }

    private void writeWordToFile(String word) {
        bh.writeToFile(word);
    }

    private void deleteWordFormList(String word) {
        list.remove(word);
    }

    @Override
    public void run() {
        waitThirtySeconds();
        if (!list.isEmpty()) {
            System.out.println("Коллекция до: " + list.toString());
            String minWord = getMinListWord(list);
            writeWordToFile(minWord);
            deleteWordFormList(minWord);
            System.out.println("Слово " + minWord + " записано в файл и удалено из коллекции");
            System.out.println("Коллекция после: " + list.toString());
        } else {
            System.out.println("В листе нет элементов: " + list.toString());
        }
    }
}
