package school2;

public class Main {
    public static void main(String[] args) {

        Teacher t1 = new Teacher("Mr. Smith", "Math", 5);
        Teacher t2 = new Teacher("Ms. Johnson", "English", 10);

        Student s1 = new Student("Alice", 10, "S12345");
        Student s2 = new Student("Bob", 11, "S54321");
        Student s3 = new Student("Charlie", 12, "S67890");

        Person[] people = {t1, t2, s1, s2, s3};

        printPersonInfo(people);

    }

    private static void printPersonInfo(Person[] people) {
        System.out.println("=== Person Info ===");
        for (Person person : people) {
            if (person instanceof Teacher) {
                person.showInfo();
                ((Teacher) person).showStudents();
                ((Teacher) person).teach();
                System.out.println();
            } else {
                person.showInfo();
                System.out.println();
            }
        }

    }
}
