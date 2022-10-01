package hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    // Заполните массив на N элементов случайным целыми числами и выведете максимальное,
    // минимальное и среднее арифметическое значение элементов массива
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        while (true) {
            System.out.println("Введите желаемое количество элементов в массиве:");
            N = sc.nextInt();
            if (N > 0) break;
            System.out.println("Количество элементов в массиве должно быть больше 0");
        }

        int[] resultArray = new int[N];
        int elementsSum = 0;

        for(int i = 0, element; i < resultArray.length; i++) {
            element = (int) (Math.random() * N * N);
            resultArray[i] = element;
            elementsSum += element;
        }

        double arrayAverage = elementsSum * 1.0 / N;

        System.out.println("Полученный массив: " + Arrays.toString(resultArray));
        Arrays.sort(resultArray);
        System.out.println("Отсортированный массив: " + Arrays.toString(resultArray));
        System.out.println("Минимальное значение: " + resultArray[0]);
        System.out.println("Среднее арифметическое: " + arrayAverage);
        System.out.println("Максимальное значение: " + resultArray[resultArray.length-1]);
    }
}
