package ru.itmo.lessons.lesson15;

import java.util.*;

public class MapTask {

    public static ArrayList<String> getCitiesLoginByValue(HashMap<String, String> citiesMap, String city) {
        ArrayList<String> citiesLogin = new ArrayList<>();
        for(Map.Entry<String, String> pair: citiesMap.entrySet()) {
            if (city.equals(pair.getValue())) {
                citiesLogin.add(pair.getKey());
            }
        }
        return citiesLogin;
    }

    public static HashMap<String, Integer> getWordsCounter(List<String> words) {
        HashMap<String, Integer> wordsCounter = new HashMap<>();

        for (String word : words) {
            if (wordsCounter.containsKey(word)) {
                wordsCounter.put(word, wordsCounter.get(word) + 1);
            } else {
                wordsCounter.put(word, 1);
            }
        }
        return wordsCounter;
    }

    public static HashMap<String, Customer> getCustomerByAgeRange(HashMap<String, Customer> customerMap, int ageFrom, int ageTo) {
        HashMap<String, Customer> customers = new HashMap<>();
        for (Map.Entry<String, Customer> pair: customerMap.entrySet()) {
            int customerAge = pair.getValue().getAge();
            if (customerAge >= ageFrom && customerAge < ageTo) {
                customers.put(pair.getKey(), pair.getValue());
            }
        }
        return customers;
    }

    public static HashMap<String, Long> getWordStatistic(String text, String word) {
        HashMap<String, Long> wordStatistic = new HashMap<>();
        wordStatistic.put(word, 0L);
        String[] textByWords = text.split(" ");

        for (String textByWord : textByWords) {
            if (textByWord.toLowerCase().equals(word.toLowerCase())) {
                wordStatistic.put(word, wordStatistic.get(word) + 1);
            }
        }
        return wordStatistic;
    }

    public static HashMap<Integer, ArrayList<String>> getTextStatistic(String text) {
        HashMap<Integer, ArrayList<String>> textStatistic = new HashMap<>();
        int wordLength = 0;
        for (String word : text.split(" ")) {
            wordLength = word.length();
            if(textStatistic.containsKey(wordLength)) {
                ArrayList<String> wordsList = textStatistic.get(wordLength);
                wordsList.add(word);
                textStatistic.put(wordLength, wordsList);
            } else {
                ArrayList<String> wordsList = new ArrayList<>();
                wordsList.add(word);
                textStatistic.put(wordLength, wordsList);
            }
        }
        return textStatistic;
    }

    public static void main(String[] args) {
        // FIXME:: В решениях не использовать lambda выражения и stream API

        // TODO:: написать статический метод, который принимает на вход мапу (firstTaskMap) и город (city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(getCitiesLoginByValue(firstTaskMap, city)); // [asd, rty, qwe]

        // TODO:: дан список слов (words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов
        //  в мапе вида Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(getWordsCounter(words)); // {june=1, may=4, august=3, july=1}


        // TODO:: дана мапа (customerMap).
        //  Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(getCustomerByAgeRange(customerMap, 17, 48)); // {1=Customer{name='Павел', uuid='1', age=23}, 2=Customer{name='Олег', uuid='2', age=17}}

        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод (можно статический):
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  (Map<String, Long>, где - ключи (String) - слово, значения (Long) - частота встречаемости)
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  (Map<Integer, ArrayList<String>>, где - ключи (Integer) - количество букв, значения (ArrayList<String>) - слова)
        //  3. написать метод, который выводит в консоль топ 10 самых часто встречаемых в тексте слов (артикли и предлоги тоже считаем за слова)

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(getWordStatistic(text, "It")); // 3
        System.out.println(getTextStatistic(text));

    }
}
