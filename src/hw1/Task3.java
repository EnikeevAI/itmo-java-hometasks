package hw1;

// Даны две переменные типа double: время (в часах) и расстояние (в километрах).
// Найти и вывести в консоль скорость, выраженную в метрах в секунду
public class Task3 {
    public static void main(String[] args) {

        double distance = 72.0;
        double timeHour = 2.0;

        double speed = (distance) / (timeHour * 3.6);

        System.out.println(speed);
    }
}
