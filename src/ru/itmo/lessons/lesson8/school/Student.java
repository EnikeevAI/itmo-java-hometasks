package ru.itmo.lessons.lesson8.school;

import ru.itmo.lessons.lesson8.school.base.LessonParticipant;

public class Student extends LessonParticipant {

    private int levelOfKnowledge;

    public Student(String name, int age, String lessonName, int levelOfKnowledge) {
        super(name, age, lessonName);
        if (levelOfKnowledge < 0) throw new IllegalArgumentException("levelOfKnowledge д.б. больше 0");
        this.levelOfKnowledge = levelOfKnowledge;
    }

    public int getLevelOfKnowledge() {
        return levelOfKnowledge;
    }

    public void toStudy(int teacherSkill) {
        levelOfKnowledge += (int) (Math.random() * teacherSkill);
    }
}
