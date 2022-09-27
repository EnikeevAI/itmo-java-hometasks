package hw3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        // Для введённого пользователем с клавиатуры целого положительного числа посчитайте сумму всех его цифр
        Scanner in = new Scanner(System.in);
        int resultSum = 0;

        System.out.println("Введите целое положительное число:");
        int number = in.nextInt();
        if (number < 0) {
            System.out.println("Введено отрицательное число");
        } else {
            System.out.print("Сумма цифр числа " + number + " равна ");
            if (number < 10) {
                resultSum = number;
            }
            else {
                while (number != 0) {
                    resultSum += number % 10;
                    number = number / 10;
                }
            }
            System.out.println(resultSum);
        }
    }
}
