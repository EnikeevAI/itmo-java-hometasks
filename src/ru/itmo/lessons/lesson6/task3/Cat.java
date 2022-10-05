package ru.itmo.lessons.lesson6.task3;

public class Cat {
    private String name;
    private int speed, weight;
    private Mouse[] mouses;

    private int mouseCounter = 0;

    public Cat(String name, int speed, int weight) {
        setName(name);
        setSpeed(speed);
        setWeight(weight);
        initMouses();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < 3) throw new IllegalArgumentException("В имени кота д.б. минимум 3 буквы");
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0) throw new IllegalArgumentException("Скорость кота не может быть отрицательной");
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 0) throw new IllegalArgumentException("Вес кота не может быть отрицательной");
        this.weight = weight;
    }

    private void initMouses() {
        if (mouseCounter == 0) {
            mouses = new Mouse[100];
        }
    }

    public void catchingMouse(Mouse mouse) {
        if (speed > mouse.getSpeed()) {
            if (mouseCounter < mouses.length) {
                System.out.println("Кот " + getName() + " съел мышку!");
                mouses[mouseCounter] = mouse;
                mouseCounter++;
            } else {
                System.out.println("Я больше не съем");
            }
        }
    }

    public Mouse[] getMouses() {
        return mouses;
    }

    public Mouse[] lossMouses() {
        Mouse[] lossMousesArray = mouses.clone();
        mouseCounter = 0;
        initMouses();
        return lossMousesArray;
    }

    public void attackAnotherCat(Cat cat) {
        if(weight > cat.getWeight()) {
            System.out.println("Кот " + getName() + " отобрал у кота " + cat.getName() + " всех мышей");
            Mouse[] anotherCatMouses = cat.lossMouses();
            for(Mouse mouse: anotherCatMouses) {
                if (mouse != null) catchingMouse(mouse);
            }
        }
    }

    public void printMouses() {
        int cnt = 0;
        System.out.println("Мыши кота по имени " + name + ":");
        for(Mouse mouse: mouses) {
            if (mouse != null) System.out.println("Мышь №" + ++cnt);
        }
        if(cnt == 0) System.out.println("Мышей нет:(");

    }


}
