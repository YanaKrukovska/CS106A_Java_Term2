package ua.edu.ukma.ykrukovska.unit12.practice;

public class GroupDemo {

    public static void main(String[] args) {
        Group group = new Group("IPZ-1");

        group.addStudent(new Student("Oleg"));
        group.addStudent(new Student("Kobzon"));
        group.addStudent(new Student("Justin"));
        group.addStudent(new Student("Poplavok"));
        group.printStudents();
        System.out.println("");

        group.deleteStudent(new Student("Kobzon"));
        group.deleteStudentByName("Poplavok");
        group.printStudents();
        System.out.println("");

        System.out.println(group.toString());
    }
}
