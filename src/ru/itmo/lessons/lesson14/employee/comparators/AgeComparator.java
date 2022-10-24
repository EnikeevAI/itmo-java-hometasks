package ru.itmo.lessons.lesson14.employee.comparators;

import ru.itmo.lessons.lesson14.employee.Employee;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        if (e1.getSalary() < e2.getSalary()) return -1;
        if (e1.getSalary() > e2.getSalary()) return 1;
        return 0;
    }
}