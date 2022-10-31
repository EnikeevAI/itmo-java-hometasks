package ru.itmo.lessons.lesson15;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue() - o1.getValue();
    }
}
