package ru.itmo.lessons.lesson14.employee.comparators;

import ru.itmo.lessons.lesson14.employee.Employee;

import java.util.Comparator;

public class CompanyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getCompany().compareTo(e2.getCompany());
    }
}

