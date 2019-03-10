package ua.edu.ukma.ykrukovska.lab1;

import java.io.IOException;

public class InputUtils {
    public static int getUserInput(int min, int max, String prompt) {
        int userInput;
        System.out.println("Введіть " + prompt);
        userInput = DataInput.getInt();

        if (userInput < min || userInput > max) {
            System.out.println("Хибне значення " + prompt);
            while (userInput < min && userInput > max) {
                System.out.println("Введіть " + prompt);
                userInput = DataInput.getInt();
            }
        }

        return userInput;
    }

    public static String getCorrectUserString(String prompt) {
        String userInput = "";
        boolean exitFlag = false;
        do {
            System.out.println("Введіть: " + prompt);
            try {
                userInput = DataInput.getString();
                if (userInput == null || userInput.length() == 0 || userInput.trim().length() == 0) {
                    System.out.println("Не коректне значення: " + prompt);
                } else {
                    exitFlag = true;
                }
            } catch (IOException e) {
                System.out.println("Не коректне значення: " + prompt);
            }
        } while (!exitFlag);
        return userInput;
    }

    public static void printFaculties(Faculty[] faculties){
        String result = "";
        for (int i = 0; i < SortUtils.getItemsAmount(faculties); i++) {
            result += faculties[i] + ", ";
        }
        System.out.println(result);
    }

    public static void printDepartments(Faculty faculty){
        String result = faculty.getName() + ": ";
        for (int i = 0; i < SortUtils.getItemsAmount(faculty.getAcademicDepartments()); i++) {
            result += faculty.getAcademicDepartments()[i] + ", ";
        }
        System.out.println(result);
    }

    public static void printDepartmentStudents(AcademicDepartment department) {
        String result = department.getName() + ": ";
        for (int i = 0; i < SortUtils.getItemsAmount(department.getStudents()); i++) {
            result += department.getStudents()[i] + ", ";
        }
        System.out.println(result);
    }

    public static void printDepartmentTeachers(AcademicDepartment department) {
        String result = department.getName() + ": ";
        for (int i = 0; i < SortUtils.getItemsAmount(department.getTeachers()); i++) {
            result += department.getTeachers()[i] + ", ";
        }
        System.out.println(result);
    }

    public static void printPersons(Person[] persons) {

        String result = "";
        for (int i = 0; i < SortUtils.getItemsAmount(persons); i++) {
            result += persons[i] + ", ";
        }
        System.out.println(result);
    }

    static int showYesNoMenu() {

        return getUserInput(0, 1, " режим ( 0 - завершити, 1 - продовжити)");


    }
}
