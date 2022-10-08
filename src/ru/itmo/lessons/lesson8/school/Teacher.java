package ru.itmo.lessons.lesson8.school;

import ru.itmo.lessons.lesson8.school.base.LessonParticipant;

public class Teacher extends LessonParticipant {

    private int teacherSkill;

    public Teacher(String name, int age, String lessonName, int teacherSkill) {
        super(name, age, lessonName);
        if (teacherSkill < 0) throw new IllegalArgumentException("teacherSkill д.б. больше 0");
        this.teacherSkill = teacherSkill;
    }

    public void teach (Student student) {
        if (student.getLessonName().equals(this.getLessonName())) {
            System.out.println(String.format("Учитель %s обучает ученика %s. Наименование дисциплины - %s",
                    this.getName(),
                    student.getName(),
                    this.getLessonName()));
            System.out.println(String.format("Уровень знаний был равен %d", student.getLevelOfKnowledge()));
            student.toStudy(this.teacherSkill);
            System.out.println(String.format("Уровень знаний стал равен %d", student.getLevelOfKnowledge()));
        }
    }
}
