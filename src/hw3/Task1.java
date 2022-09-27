package hw3;


public class Task1 {
    public static void main(String[] args) {
        // Вывести все неотрицательные элементы последовательности 90 85 80 75 70 65 60 и тд
        System.out.println("Вывести все неотрицательные элементы последовательности 90 85 80 75 70 65 60 и тд");
        for (int element = 90, step = 5; element >= 0; element -= step) {
            System.out.println(element);
        }

        // Вывести на экран первые 10 элементов последовательности 2 4 6 8 10 и тд
        System.out.println("Вывести на экран первые 10 элементов последовательности 2 4 6 8 10 и тд");
        for (int startElement = 2, step = 2, counter =0; counter < 10; counter++){
            System.out.println(startElement);
            startElement += step;
        }
    }
}
