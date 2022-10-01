package hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    // Задать массив на N слов. В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив
    // (добавлять новое слово в массив можно только, если в нем его еще нет).
    // В итоге в массиве будут только уникальные слова.
    // Выход из программы по слову exit (слово 'exit' в массив не добавлять) или если массив заполнен.
    // Перед завершением программы, вывести получившийся массив в консоль
    public static void main(String[] args) {
        int N = 3;
        String[] resultArr = new String[N];

        Scanner sc = new Scanner(System.in);
        String word;

        int wordsCounter = 0;

        while (true) {
            word = sc.nextLine();

            if ("exit".equals(word)) break;

            if (Arrays.asList(resultArr).contains(word)) {
                System.out.println("Данное слово уже содержится в массиве. Введите новое слово");
            } else {
                resultArr[wordsCounter] = word;
                wordsCounter++;
            }

            if (wordsCounter == N) break;
        }
        System.out.println("Итоговый массив:");
        System.out.println(Arrays.asList(resultArr));
    }
}
