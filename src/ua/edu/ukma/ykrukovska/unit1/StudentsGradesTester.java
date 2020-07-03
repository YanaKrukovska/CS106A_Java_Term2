package ua.edu.ukma.ykrukovska.unit1;

public class StudentsGradesTester {

    private static final int MAX_SIZE = 5;

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

        System.out.println("Do you want to sort numbers in ascending or descending order? 1-ascending, 2-descending");
        int sortingOrder = DataInput.getInt();
        if (sortingOrder != 1 && sortingOrder != 2) {
            do {
                System.out.println("You can only choose 1 or 2. Try again");
                sortingOrder = DataInput.getInt();
            } while (sortingOrder != 1 && sortingOrder != 2);
        }
        System.out.println("Marks sorted: " + gradesService.sortGrades(sortingOrder));
    }
}
