package hw5;

public class Task4 {
    // Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины.
    // Предложение для поска длинного слова: "в предложении все слова разной длины"
    // (самостоятельно найти метод преобразования строки в массив строк).
    public static void main(String[] args) {
        String text = "в предложении все слова разной длины";
        String[] wordsArray = text.split(" ");
        int maxWordSize = 0;
        String longestWord = "";
        for (String word: wordsArray) {
            if (word.length() > maxWordSize) {
                maxWordSize = word.length();
                longestWord = word;
            }
        }
        System.out.println(String.format("Исходный текст: %s", text));
        System.out.println(String.format("Самое длинное слово - %s (количество букв = %d)",longestWord, maxWordSize));
    }
}
