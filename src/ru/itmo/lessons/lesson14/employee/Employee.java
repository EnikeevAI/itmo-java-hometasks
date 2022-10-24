package ru.itmo.lessons.lesson14.employee;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;



    // TODO: добавить конструктор, необходимы геттеры и сеттеры
    public Employee(String name, String company, int age, int salary) {
        setName(name);
        setCompany(company);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.length() < 3)
            throw new IllegalArgumentException("Имя должно иметь как минимум 3 символа");
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    private void setCompany(String company) {
        if (company == null || company.length() < 3)
            throw new IllegalArgumentException("Имя должно иметь как минимум 3 символа");
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    private void setSalary(int salary) {
        if (salary < 0) throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    // TODO: дописать реализацию метода для создания списка из объектов класса Employee.
    //  Объекты Employee создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп.
    //  num - количество объектов в списке
    public static List<Employee> employeeGenerator(int num) {
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний
        int minAge = 21;
        int maxAge = 60;
        int minSalary = 100;
        int maxSalary = 10000;
        int age, salary, nameIndex, companyIndex;

        ArrayList<Employee> employees = new ArrayList<>();

        // создание объектов, наполнение списка
        for (int i = 0; i < num; i++) {
            age = (int) (minAge + Math.random()*(maxAge-minAge));
            salary = (int) (minSalary + Math.random() * (maxSalary - minSalary));
            nameIndex = (int) (Math.random() * names.length);
            companyIndex = (int) (Math.random() * companies.length);
            employees.add(
                    new Employee(
                            names[nameIndex],
                            companies[companyIndex],
                            age,
                            salary)
            );
        }
        return employees;
    }
}
