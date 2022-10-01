package hw5;

import java.util.Arrays;

public class Task5 {
    // Задать массив. Отрицательные элементы массива перенести в новый массив.
    // Размер массива должен быть равен количеству отрицательных элементов.
    public static void main(String[] args) {
        int[] firstArray = {5, -1, 4, -3, 7, 8, -5, -4, 9, 10, -110};
        int secondArraySize = 0;

        for(int number: firstArray) {
            if (number < 0) secondArraySize++;
        }
        if (secondArraySize == 0) {
            System.out.println("Исходный массив не содержит отрицательных чисел");
        } else {
            int[] secondArray = new int[secondArraySize];
            for(int firstIndex = 0, secondIndex = 0; firstIndex < firstArray.length; firstIndex++) {
                if (firstArray[firstIndex] < 0) {
                    secondArray[secondIndex] = firstArray[firstIndex];
                    secondIndex++;
                }
            }
            System.out.println("Исходный массив: " + Arrays.toString(firstArray));
            System.out.println("Массив с отрицательными элементами: " + Arrays.toString(secondArray));
        }
    }
}
