package ru.itmo.lessons.lesson6.task2.products;

public class Product {
    private String productName;
    private double proteins;
    private double fats;
    private double carbs;
    private double callories;

    public Product(String productName) {
        setProductName(productName);
    }

    public Product(String productName, double proteins) {
        setProductName(productName);
        setProteins(proteins);
    }

    public Product(String productName, double proteins, double fats, double carbs) {
        setProductName(productName);
        setProteins(proteins);
        setFats(fats);
        setCarbs(carbs);
    }

    public Product(String productName, double proteins, double fats, double carbs, double callories) {
        setProductName(productName);
        setProteins(proteins);
        setFats(fats);
        setCarbs(carbs);
        setCallories(callories);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName.length() < 4) throw new IllegalArgumentException("В наименовании продукта д.б. минимум 4 буквы");
        this.productName = productName;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        if (proteins < 0) throw new IllegalArgumentException("Количество белков не может быть отрицательным");
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        if (fats < 0) throw new IllegalArgumentException("Количество жиров не может быть отрицательным");
        this.fats = fats;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        if (carbs < 0) throw new IllegalArgumentException("Количество углеводов не может быть отрицательным");
        this.carbs = carbs;
    }

    public double getCallories() {
        return callories;
    }

    public void setCallories(double callories) {
        if (callories < 0) throw new IllegalArgumentException("Количество каллорий не может быть отрицательным");
        this.callories = callories;
    }
}
