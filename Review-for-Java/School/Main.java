package school;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Teacher[] teachers = {
                new Teacher("Mr. Smith", "Math", 5),
                new Teacher("Ms. Johnson", "English", 10)
        };

        Student[] students = {
                new Student("Alice", 10, "S12345"),
                new Student("Bob", 11, "S54321"),
                new Student("Charlie", 12, "S67890")
        };


       teachers[0].addStudent(students[0]);
       teachers[0].addStudent(students[1]);
       teachers[1].addStudent(students[2]);

        System.out.println("=== Teacher Info ===");
        for (Teacher teacher : teachers) {
            teacher.showInfo();
            teacher.showStudents();
            teacher.teach();
            System.out.println();
        }


        System.out.println("=== Student Info ===");
        for (Student student : students) {
            student.showInfo();
            System.out.println();
        }

    }
}
