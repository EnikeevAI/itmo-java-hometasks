package hw3;

import java.util.Scanner;

public class Task5 {
    /*
    Пользователь загадывает число в диапазоне от [2 до 100]
    Программа пытается его угадать (используйте метод бинарного поиска, т.е деление отрезка на 2).
    Программа может задавать пользователю вопросы: Число равно ...?, Число больше ...? и в зависимоти от ответа пользователя принимать решения.
    Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА
     */
    public static void main(String[] args) {
        int minNumber = 2, maxNumber = 100;
        short answer;

        int randomNumber = (maxNumber + minNumber) / 2;

        Scanner in = new Scanner(System.in);
        System.out.println("Загадайте число в диапазоне [2; 100]");
        while (true) {
            System.out.println("Число равно " + randomNumber + "? 0 - ответ нет; 1 - ответ да");
            answer = in.nextShort();
            if (answer == 1) {
                System.out.println("Игра окончена. Загаданное число: " + randomNumber);
                break;
            } else if (answer == 0) {
                System.out.println("Число больше " + randomNumber + "? 0 - ответ нет; 1 - ответ да");
                answer = in.nextShort();
                if (answer == 1) {
                    minNumber = randomNumber + 1;
                } else if (answer == 0) {
                    maxNumber = randomNumber;
                } else {
                    System.out.println("Ответ долежн быть 0 или 1. Повторим сначала");
                }
                randomNumber = (maxNumber + minNumber) / 2;
            } else {
                System.out.println("Ответ долежн быть 0 или 1. Повторим сначала");
            }
            System.out.println("min = " + minNumber + "; max = " + maxNumber + "; rand = " + randomNumber);
        }
    }
}
