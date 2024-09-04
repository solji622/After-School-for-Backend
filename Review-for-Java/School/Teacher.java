package school;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private String subject;
    private int experience;
    private List<Student> students;

    public Teacher(String name, String subject, int experience) {
        this.name = name;
        this.subject = subject;
        this.experience = experience;
        this.students = new ArrayList<>(); // 초기화를 해주지 않으면 npe 발생!!
    }


    public void addStudent(Student student) {
        students.add(student);
        student.setTeacher(this); // 학생에게 교사를 할당
    }

   public void showStudents() {
        System.out.println(name + "teaches the following students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }

    }

    public void teach() {
        System.out.println(name + " is teaching " + subject);
    }

    public void showInfo() {
        System.out.println("Teacher Name: " + name);
        System.out.println("Subject: " + subject);
        System.out.println("Experience: " + experience + " years");
    }


    // 모든 필드 getter & setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

}
