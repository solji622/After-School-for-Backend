package school;

public class Student {
    // 모든 필드에는 외부 접근 막기 위해 private 필수로
    private String name;
    private int grade;
    private String studentId;
    private Teacher teacher;

    public Student(String name, int grade, String studentId) {
        this.name = name;
        this.grade = grade;
        this.studentId = studentId;
    }

    public void study() {
        System.out.println(name + "is studying");
    }

    public void showInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("Student ID: " + studentId);
        if (teacher != null) { // 교사 유무에 따른 출력 방식 차이
            System.out.println("Teacher: " + teacher.getName());
        } else {
            System.out.println("No Teacher");
        }
    }

    // 교사 설정
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Teacher getTeacher() {
        return teacher;
    }

    // studentId의 경우 값이 바뀌면 안 되기에 getter만
    public String getStudentId() {
        return studentId;
    }

    // 그 외에는 getter & setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
}
