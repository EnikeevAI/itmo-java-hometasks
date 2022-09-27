package hw3;

import java.util.Scanner;

public class Task4 {
    /*
        Программа загадывает число в диапазоне [1;9]
        Пользователь вводит число с клавиатуры
        Программа в зависимости от введенного числа выводит в консоль следующее:
        "загаданное число больше"
        "загаданное число меньше"
        "Вы угадали" (программа завершает работу)
        Если введен 0, выввести "выход из программы" (программа завершает работу)
     */
    public static void main(String[] args) {
        int min = 1; // Начальное значение диапазона
        int max = 9; // Максимальное значение диапазона
        int range = max - min; // Диапазон от min до max
        int randomNumber = min + (int) (Math.random() * ++(range));
        int userNumber;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите число в диапазоне [" + min + "; " + max + "]:");
        userNumber = in.nextInt();
        while (true) {
            if (userNumber == 0) {
                System.out.println("Выход из программы");
                break;
            }
            else if (userNumber != 0 && (userNumber < min || userNumber > max)) {
                System.out.println("Введено число, выходящее за пределы диапазона. Введите другое число");
                userNumber = in.nextInt();
            } else {
                if (userNumber < randomNumber) {
                    System.out.println("Загаданное число больше. Введите другое число");
                } else if (userNumber > randomNumber) {
                    System.out.println("Загаданное число меньше. Введите другое число");
                } else if (userNumber == randomNumber) {
                    System.out.println("Вы угадали!");
                    break;
                }
                userNumber = in.nextInt();
            }
        }
    }
}
