package ru.itmo.lessons.lesson8;

import ru.itmo.lessons.lesson8.school.Director;
import ru.itmo.lessons.lesson8.school.School;
import ru.itmo.lessons.lesson8.school.Student;
import ru.itmo.lessons.lesson8.school.Teacher;

import java.util.Arrays;

public class Application {

    private static String[] classes = {"Русский язык", "Математика", "История"};

    public static void main(String[] args) {
        Director director = new Director("Директор1", 55);

        School school = new School("Лицей № 1", director, 3, 10);

        Teacher teacher1 = new Teacher("Иван Иванович", 35, Application.classes[0], 20);
        Teacher teacher2 = new Teacher("Василий Васильевич", 55, Application.classes[1], 30);
        Teacher teacher3 = new Teacher("Петр Петрович", 45, Application.classes[2], 15);

        school.addTeacher(teacher1);
        school.addTeacher(teacher2);
        school.addTeacher(teacher3);

        for (int i = 0; i < 10; i++) {
            Student student = new Student(
                    String.format("Ученик %d",i+1),
                    (int) (7 + (Math.random() * 9)),
                    Application.classes[(int) (Math.random() * 3)],
                    (int) (Math.random() * 40));
            school.addStudent(student);
        }

        System.out.println(Arrays.asList(school.getStudents()));

        school.startWorkingDay();

    }

}
