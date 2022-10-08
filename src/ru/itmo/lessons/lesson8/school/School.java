package ru.itmo.lessons.lesson8.school;

public class School {
    private final String name;

    private Director director;

    private int maxNumberOfTeachers, maxNumberOfStudents;

    private int numberOfTeachers = 0, numberOfStudents = 0;

    private Teacher[] teachers;

    private Student[] students;

    public School(String name, Director director, int maxNumberOfTeachers, int maxNumberOfStudents) {
        if (name.length() < 1) throw new IllegalArgumentException("Имя школы должно содержать хотя бы один символ");
        this.name = name;
        setDirector(director);
        setMaxNumberOfTeachers(maxNumberOfTeachers);
        setMaxNumberOfStudents(maxNumberOfStudents);
        teachers = new Teacher[maxNumberOfTeachers];
        students = new Student[maxNumberOfStudents];
    }

    public String getName() {
        return this.name;
    }

    public Director getDirector() {
        return this.director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setMaxNumberOfTeachers(int maxNumberOfTeachers) {
        if (maxNumberOfTeachers < 1) throw new IllegalArgumentException("В школе должен быть хотя бы 1 учитель");
        this.maxNumberOfTeachers = maxNumberOfTeachers;

    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        if (maxNumberOfStudents < 1) throw new IllegalArgumentException("В школе должен быть хотя бы 1 ученик");
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addTeacher(Teacher teacher) {
        if (numberOfTeachers < maxNumberOfTeachers) {
            teachers[numberOfTeachers] = teacher;
            System.out.println(String.format("Учитель %s принят на работу в школу %s", teacher.getName(), this.name));
            numberOfTeachers++;
        } else {
            System.out.println(String.format("Учитель %s не принят на работу в школу %s. В школе нет мест", teacher.getName(), this.name));
        }
    }

    public void addStudent(Student student) {
        if (numberOfStudents < maxNumberOfStudents) {
            students[numberOfStudents] = student;
            System.out.println(String.format("Ученик %s принят в школу %s", student.getName(), this.name));
            numberOfStudents++;
        } else {
            System.out.println(String.format("Ученик %s не принят в школу %s. В школе нет мест", student.getName(), this.name));
        }
    }

    public void startWorkingDay() {
        director.startClasses();
        for (Teacher teacher: teachers) {
            if (teacher == null) continue;
            for (Student student: students) {
                if (student == null) continue;
                if (teacher.getLessonName().equals(student.getLessonName())){
                    teacher.teach(student);
                }
            }
        }
        director.finishClasses();
    }
}
