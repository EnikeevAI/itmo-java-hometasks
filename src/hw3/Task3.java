package hw3;

import java.util.Scanner;

public class Task3 {
    /*
    Считать с консоли количество тарелок и моющего средства.
    Моющее средство расходуется из расчета 0.5 на 1 тарелку (за один раз расходуется 0.5 стредства и 1 тарелка).
    В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.
    После цикла вывести сколько тарелок и моющего средства осталось.
     */
    public static void main(String[] args) {
        int platesNumber = 0;
        double dishwashingDetergent = 0.0;
        double DISH_DET_PER_PLATE = 0.5;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество тарелок:");
        platesNumber = in.nextInt();
        System.out.println("Введите количество моющего средства:");
        dishwashingDetergent = in.nextDouble();
        if (platesNumber < 0 || dishwashingDetergent < 0) {
            System.out.println("Значения колиства тарелок и моющего средства должны быть положительными");
        } else if (platesNumber == 0) {
            System.out.println("Отсутствуют грязные тарелки");
        } else if (dishwashingDetergent < DISH_DET_PER_PLATE) {
            System.out.println("Моющего средства не хватает для мытья 1 тарелки");
        } else {
            while (platesNumber > 0 && dishwashingDetergent > DISH_DET_PER_PLATE) {
                platesNumber--;
                dishwashingDetergent -= DISH_DET_PER_PLATE;
                System.out.println("Тарелка помыта. Количество оставшегося моющего средства: " + dishwashingDetergent);
            }
            System.out.println("Мытье тарелок закончено!");
            System.out.println("Количество грязных тарелок: " + platesNumber);
            System.out.println("Количество моющего средства: " + dishwashingDetergent);
        }
    }

}
