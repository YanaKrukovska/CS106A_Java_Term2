package ua.edu.ukma.ykrukovska.lab1;

public class SortUtils {

    public static Student[] sortStudentsByCourse(Student[] students) {

        int length = getItemsAmount(students);
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (students[j].getCourse() > students[j + 1].getCourse()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        return students;
    }

    public static int getItemsAmount(Object[] students) {
        for (int i = 0; i < students.length; i++) {

            if (students[i] == null) {
                return i;
            }
        }
            return 0;
    }

    public static Person[] sortByName(Person[] persons) {

        int length = getItemsAmount(persons);

        boolean isSwapped = false;
        do {
            isSwapped = false;
            for (int i = 0; i < length - 1; i++) {
                if (persons[i].getName().compareTo(persons[i + 1].getName()) > 0) {
                    Person temp = persons[i + 1];
                    persons[i + 1] = persons[i];
                    persons[i] = temp;
                    isSwapped = true;
                }
            }
        } while ((isSwapped));


        return persons;
    }
}
