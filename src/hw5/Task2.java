package hw5;

import java.util.Arrays;

public class Task2 {
    //Создайте массив из чётных чисел [2;20] и выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)
    public static void main(String[] args) {
        int arrLen = 10, arrMin = 2, step = 2;
        int[] resultArray = new int [arrLen];

        for (int i = 0, arrElem = arrMin; i < resultArray.length; i++, arrElem += step) {
            resultArray[i] = arrElem;
        }

        System.out.print("Полученный массив: ");
        System.out.println(Arrays.toString(resultArray));

        for (int i = resultArray.length -1; i >= 0; i--) {
            System.out.println(resultArray[i]);
        }
    }
}
