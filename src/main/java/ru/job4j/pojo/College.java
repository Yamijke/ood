package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Knyazev Sergei");
        student.setGroup("main group");
        student.setCreated(new Date());
        System.out.println(student.getFullName() + " joined " + student.getGroup() + " in " + student.getCreated());
    }
}
