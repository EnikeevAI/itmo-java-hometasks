package ru.itmo.lessons.lesson6.task2.products;

public class MyProducts {
    private double maxProteins = 50;
    private double maxFats = 60 ;
    private double maxCarbs = 100;
    private double maxCallories = 800.0;

    private int productsCounter = 0;

    private Product[] myProducts = new Product[4];

    public void addProduct(Product product) {
        if (product.getProteins() > maxProteins) {
            System.out.println("Продукт " + product.getProductName() + " не подходит. Очень многа белка");
            return;
        }
        if (product.getFats() > maxFats) {
            System.out.println("Продукт " + product.getProductName() + " не подходит. Очень многа жира");
            return;
        }
        if (product.getCarbs() > maxCarbs) {
            System.out.println("Продукт " + product.getProductName() + " не подходит. Очень многа углеводов");
            return;
        }
        if (product.getCallories() > maxCallories) {
            System.out.println("Продукт " + product.getProductName() + " не подходит. Очень многа каллорий");
            return;
        }
        if (product.getCallories() == 0 && product.getCarbs() == 0 && product.getFats() == 0 && product.getProteins() == 0) {
            System.out.println("Продукт " + product.getProductName() + " не подходит. Неизвестный состав");
            return;
        }
        myProducts[productsCounter] = product;
        productsCounter++;
    }

    public void printProducts() {
        System.out.println("Список продуктов:");
        for(Product product: myProducts) {
            if (product == null) continue;
            System.out.println(product.getProductName());
        }
    }

}
