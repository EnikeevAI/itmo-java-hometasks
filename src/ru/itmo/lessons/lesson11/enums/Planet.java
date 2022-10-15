package ru.itmo.lessons.lesson11.enums;

public enum Planet {
    EARTH ("Земля", 6371, 6.0E25),
    MARS ("Марс", 3390, 6.0E23),
    JUPITER ("Юпитер", 69911, 1.9E25);

    private int radius;
    private double weight;
    private final String name;

    Planet(String name, int radius, double weight) {
        if(name.length() < 3) throw new IllegalArgumentException("Название планыт д.б. минимум из 3 символов");
        this.name = name;
        setRadius(radius);
        setWeight(weight);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0) throw new IllegalArgumentException("Радиус планеты д.б. больше нуля");
        this.radius = radius;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) throw new IllegalArgumentException("Вес планеты д.б. больше нуля");
        this.weight = weight;
    }

    public String getName() {
        return name;
    }


}
