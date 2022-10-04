package hw5;

import java.security.cert.TrustAnchor;
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
        boolean isRepeat;

        while (true) {
            word = sc.nextLine();
            isRepeat = false;

            if ("exit".equals(word)) break;

            for (String element: resultArr) {
                if (element == null) continue;
                if (word.equals(element)){
                    System.out.println("Данное слово уже содержится в массиве. Введите новое слово");
                    isRepeat = true;
                    break;
                }
            }
            if (!isRepeat) {
                resultArr[wordsCounter] = word;
                wordsCounter++;
            }

            if (wordsCounter == N) break;
        }
        System.out.println("Итоговый массив:");
        System.out.println(Arrays.asList(resultArr));
    }
}
