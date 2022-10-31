package ru.itmo.lessons.lesson14.employee;

import ru.itmo.lessons.lesson14.employee.comparators.CompanyComparator;
import ru.itmo.lessons.lesson14.employee.comparators.NameComparator;
import ru.itmo.lessons.lesson14.employee.comparators.SalaryComparator;
import ru.itmo.lessons.lesson14.employee.comparators.AgeComparator;

import java.util.Comparator;
import java.util.List;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.employeeGenerator(50);

        Comparator<Employee> nameComparator = new NameComparator();
        Comparator<Employee> companyComparator = new CompanyComparator();
        Comparator<Employee> salaryComparator = new SalaryComparator();
        Comparator<Employee> ageComparator = new AgeComparator();

        // TODO 1: отсортировать список по имени
        employeeList.sort(nameComparator);
        System.out.println(employeeList);
        // TODO 2: отсортировать список по имени и зп
        Comparator<Employee> nameSalaryComparator = nameComparator.thenComparing(salaryComparator);
        employeeList.sort(nameSalaryComparator);
        System.out.println(employeeList);
        // TODO 3: отсортировать список по имени, зарплате, возрасту и компании
        Comparator<Employee> fullComparator = nameSalaryComparator.thenComparing(ageComparator).thenComparing(companyComparator);
        employeeList.sort(fullComparator);
        System.out.println(employeeList);
    }
}
