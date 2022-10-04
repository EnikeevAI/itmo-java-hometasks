package ru.itmo.lessons.lesson6.task1;

import ru.itmo.lessons.lesson6.task1.mountaineering.Alpinist;
import ru.itmo.lessons.lesson6.task1.mountaineering.Group;
import ru.itmo.lessons.lesson6.task1.mountaineering.Mountain;

public class Application {
    /*
    Задача 1. Описать объектную модель Альпинист, Гора, Группа для восхождения на гору.
    Альпинист создаётся с именем (не менее 3 символов) и адресом проживания (не менее 5 символов).
    Гора создаётся с названием (не менее 4 символов), страной (не менее 4 символов) и высотой (не менее 100 метров)
    Группа для восхождения на гору создаётся со следующими характеристиками и возможностями:
    идёт набор в группу или нет;
    массив альпинистов;
    гора;
    должна быть возможность добавить альпиниста в группу, если набор ещё идёт
    В методе main (отдельного класса) создать:
    3 группы для восхождений на 3 различных горы.
    В первой группе 3 альпиниста (набор закрыт)
    Во второй и третьей группах по 2 альпиниста (набор в эти группы открыт)
    При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки.
     */
    public static void main(String[] args) {
        Mountain everest = new Mountain("Эверест", "Гималаи", 8849);
        Mountain elbrus = new Mountain("Эльбрус", "Россия", 5642);
        Mountain kilimanjaro = new Mountain("Килиманджаро", "Танзания", 5885);

        Alpinist ivan = new Alpinist("Иван", "Россия");
        Alpinist petr = new Alpinist("Петр", "Россия");
        Alpinist sergey = new Alpinist("Сергей", "Россия");
        Alpinist alex = new Alpinist("Alex", "Бразилия");
        Alpinist leo = new Alpinist("Alex", "Аргентина");
        Alpinist frank = new Alpinist("Frank", "Мексика");
        Alpinist steven = new Alpinist("Steven", "Великобритания");

        Group groupEverest = new Group(everest);
        Group groupElbrus = new Group(elbrus);
        Group groupKilimanjaro = new Group(kilimanjaro);

        groupEverest.addAplinist(steven);
        groupEverest.addAplinist(leo);
        groupEverest.addAplinist(frank);
        groupEverest.addAplinist(alex); // проверяем, что набор закрыт

        groupElbrus.addAplinist(ivan);
        groupElbrus.addAplinist(petr);
        groupElbrus.isOpen(); // набор открыт

        groupKilimanjaro.addAplinist(alex);
        groupKilimanjaro.addAplinist(sergey);
        groupKilimanjaro.isOpen(); // набор открыт



    }
}
