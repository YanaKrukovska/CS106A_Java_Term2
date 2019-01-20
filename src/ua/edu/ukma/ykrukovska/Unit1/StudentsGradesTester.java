package ua.edu.ukma.ykrukovska.Unit1;

public class StudentsGradesTester {

    private static final int MAX_SIZE = 10;

    public static void main(String[] args) {

        StudentsGrades gradesService = new StudentsGrades();
        int[] currentGrades = new int[MAX_SIZE];

        int inputCounter = 0;
        System.out.println("Insert grades: ");
        do {
            int input = DataInput.getInt();

            if (input > 100 || input < 0) {
                do {
                    System.out.println("Grades can be from 0 to 100. Try again");
                    input = DataInput.getInt();
                } while (input > 100 || input < 0);
            }

            currentGrades[inputCounter++] = input;

        } while (inputCounter < MAX_SIZE);

        gradesService.setGrades(currentGrades);
        System.out.println("Max grade: " + gradesService.getMaxGrade());
        System.out.println("Min grade: " + gradesService.getMinGrade());
        System.out.println("Average grade: " + gradesService.getAverageGrade());
        System.out.println("Students higher than average grade: " + gradesService.getStudentsHigherAverage());
        System.out.println("Students lower than average grade: " + gradesService.getStudentsLowerAverage());
        System.out.println("Students with excellent grade (91-100): " + gradesService.getStudentsExcellent());
        System.out.println("Students with good grade (71-90): " + gradesService.getStudentsGood());
        System.out.println("Students with satisfying grade (60-70): " + gradesService.getStudentsSatisfying());
        System.out.println("Students with bad grade (0-59): " + gradesService.getStudentsBad());
        System.out.println("All grades: " + gradesService.toString());
    }

}
