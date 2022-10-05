package ru.itmo.lessons.lesson6.task3;

public class Mouse {
    private int speed;

    public Mouse(int speed){
        setSpeed(speed);
    }

    private void setSpeed(int speed) {
        if (speed < 0) throw new IllegalArgumentException("Скорость мыши не может быть меньше 0");
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
