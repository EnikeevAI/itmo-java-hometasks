package ru.itmo.lessons.lesson17.student;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class StudentTask {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: Используя Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        //  2. Найти средний возраст учеников
        //  3. Найти самого младшего ученика
        //  4. Найти самого старшего ученика
        //  5. Собрать учеников в группы по году рождения
        //  6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        //  7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        //  8. Вывести в консоль всех учеников в возрасте от N до M лет
        //  9. Собрать в список всех учеников с именем=someName
        //  10. Собрать Map<Student.Gender, Integer>, где Student.Gender - пол, Integer - суммарный возраст учеников данного пола

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        Map<Student.Gender, ArrayList<Student>> studentGendersMap = students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getGender(),
                        Collectors.toCollection(ArrayList::new)));
        System.out.println(studentGendersMap);

        // 2. Найти средний возраст учеников
        Double averageAge = students.stream()
                .collect(Collectors.averagingDouble(
                        student -> Period.between(student.getBirth(),LocalDate.now()).getYears()));
        System.out.println(averageAge);

        // 3. Найти самого младшего ученика
        Student youngestStudent = students.stream()
                .min((s1, s2) ->  Period.between(s1.getBirth(),LocalDate.now()).getYears() - Period.between(s2.getBirth(),LocalDate.now()).getYears()).get();
        System.out.println(youngestStudent);

        // 4. Найти самого старшего ученика
        Student oldestStudent = students.stream()
                .max((s1, s2) ->  Period.between(s1.getBirth(),LocalDate.now()).getYears() - Period.between(s2.getBirth(),LocalDate.now()).getYears()).get();
        System.out.println(oldestStudent);

        // 5. Собрать учеников в группы по году рождения
        Map<Integer, ArrayList<Student>> studentsByYears = students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getBirth().getYear(),
                        Collectors.toCollection(ArrayList::new)));
        System.out.println(studentsByYears);

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        // students.stream().distinct().forEach(student -> System.out.println(student));

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        Comparator<Student> comparingByBirthdate = (s1, s2) -> Period.between(s1.getBirth(),LocalDate.now()).getYears() - Period.between(s2.getBirth(),LocalDate.now()).getYears();
        Comparator<Student> comparingByName = (s1, s2) -> s1.getName().compareTo(s2.getName());
        List<Student> sortedStudentsList = students.stream()
                .sorted(comparingByBirthdate.thenComparing(comparingByName).thenComparing(comparingByName))
                .toList();
        System.out.println(sortedStudentsList);

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        int N = 7, M = 10;
        System.out.println("Список студентов в возрасте от " + N + " до " + M + " лет включительно");
        students.stream().filter(
                student -> Period.between(student.getBirth(),LocalDate.now()).getYears() >= N &&
                        Period.between(student.getBirth(),LocalDate.now()).getYears() <= M)
                .forEach(student -> System.out.println(student));

        // 9. Собрать в список всех учеников с именем=someName
        String name = "Петр";
        List<Student> studentList = students.stream()
                .filter(student -> student.getName().equals(name))
                .toList();
        System.out.println(studentList);

        // 10. Собрать Map<Student.Gender, Integer>, где Student.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Student.Gender, Integer> mapGenderSummOfYears = students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getGender(),
                        Collectors.summingInt(s -> Period.between(s.getBirth(),LocalDate.now()).getYears())
                ));
        System.out.println(mapGenderSummOfYears);
    }
}