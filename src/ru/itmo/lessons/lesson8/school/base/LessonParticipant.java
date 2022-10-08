package ru.itmo.lessons.lesson8.school.base;

public class LessonParticipant extends Person{

    private String lessonName;

    public LessonParticipant(String name, int age, String lessonName) {
        super(name, age);
        if (lessonName.length() < 3) throw new IllegalArgumentException("в lessonName д.б. больше 3 букв");
        this.lessonName = lessonName;
    }

    public String getLessonName() {
        return this.lessonName;
    }
}
