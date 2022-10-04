package ru.itmo.lessons.lesson6.task2;

import ru.itmo.lessons.lesson6.task2.products.MyProducts;
import ru.itmo.lessons.lesson6.task2.products.Product;

public class Application {
    /*
    Задача 2. Список разрешенных продуктов
        Класс Продукт:
        Свойства: название продукта / белки / жиры / углеводы / калории
        Минимум 4 конструктора
        Реализовать необходимые проверки входящих данных
        Создать не менее 4 экземпляров данного класса (объектов)
        Класс МоиПродукты:
        Свойства: максимальное количество белков / жиров / углеводов / калорий / список продуктов (массив)
        Реализовать метод, который принимает на Продукт и добавляет его в список,
        если характеристики продукта полностью соответствуют заявленным разрешениям,
        в противном случае сообщить, по какой причине продукт не может быть добавлен в список
        (например, слишком большое содержание калорий)
        Реализовать метод, который выводит названия всех продуктов из списка
        При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки.
     */
    public static void main(String[] args) {
        Product product1 = new Product("Протеиновый продукт", 30);
        Product product2 = new Product("Каллорийный продукт", 10, 20, 30, 1000);
        Product product3 = new Product("Жирный продукт", 5, 50, 20);
        Product product4 = new Product("Подозрительный продукт");

        MyProducts myProducts = new MyProducts();
        myProducts.addProduct(product1);
        myProducts.addProduct(product2);
        myProducts.addProduct(product3);
        myProducts.addProduct(product4);
        myProducts.printProducts();
    }

}
