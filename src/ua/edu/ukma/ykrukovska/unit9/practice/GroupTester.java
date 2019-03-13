package ua.edu.ukma.ykrukovska.unit9.practice;

public class GroupTester {

    public static final int MAX_AMOUNT_OF_STUDENTS = 2;

    public static void main(String[] args) {

        Group group = new Group();
        fillStudentsData(group);
        System.out.println("Best student: " + group.getBest().toString());
        System.out.println("Worst student: " + group.getWorst().toString());

    }

    private static void fillStudentsData(Group group) {

        String name;
        String address;
        double averageMark;

        for (int i = 0; i < MAX_AMOUNT_OF_STUDENTS; i++) {

            System.out.println("Student " + (i + 1));
            name = InputUtils.getCorrectUserString("student's name");
            address = InputUtils.getCorrectUserString("student's address");
            averageMark = InputUtils.getUserInput(0.0, 100.0, "average mark");

            group.addStudent(new Student(name, averageMark, address));
            System.out.println("");
        }
    }

}
