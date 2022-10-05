package ru.itmo.lessons.lesson6.task3;

import java.util.Arrays;

public class Application {
    /*
    Задача 3. Коты и мыши
        Класс Мышь: скорость.
        Класс Кот: имя, скорость, вес, пойманные мыши;
        Кот хранит информацию о пойманных мышах (максимум о 100).
        Кот ловит мышь, только, если его скорость выше, чем у мыши.
        Кот может напасть на другого кота и, если он больше противника (по весу),
        то может отобрать его мышей (если скорость мыши выше, чем скорость кота, она убежит).
     */
    public static void main(String[] args) {
        Mouse mouse1 = new Mouse(20);
        Mouse mouse2 = new Mouse(10);
        Mouse mouse3 = new Mouse(30);

        Cat barsik = new Cat("Барсик", 25, 100);
        Cat tom = new Cat("Том", 60, 60);

        tom.catchingMouse(mouse1);
        tom.catchingMouse(mouse2);
        tom.catchingMouse(mouse3);

        tom.printMouses();
        barsik.printMouses();

        barsik.attackAnotherCat(tom);
        tom.printMouses();
        barsik.printMouses();
    }
}
