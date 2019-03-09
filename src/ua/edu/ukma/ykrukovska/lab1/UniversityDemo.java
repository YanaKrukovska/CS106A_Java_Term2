package ua.edu.ukma.ykrukovska.lab1;

import static ua.edu.ukma.ykrukovska.lab1.InputUtils.getCorrectUserString;
import static ua.edu.ukma.ykrukovska.lab1.InputUtils.getUserInput;

public class UniversityDemo {

    private static University university = new University();

    public static void main(String[] args) {
        int userAction = 0;

        do {
            showMenu();
            userAction = getUserInput(0, 10, "номер операції");

            switch (userAction) {
                case 1:
                    doFacultyAction();
                    break;
                case 2:
                    doDepartmentAction();
                    break;
                default:
                    System.exit(0);
            }

        } while (userAction != 0);

    }

    private static void doDepartmentAction() {
        int userAction = 0;
        do {
            System.out.println("1. Створити кафедру");
            System.out.println("2. Редагувати  кафедру");
            System.out.println("3. Видалити  кафедру");
            System.out.println("0. Вихід.");
            userAction = getUserInput(0, 3, "номер операції");

            switch (userAction) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    // editDepartment();
                    break;
                case 3:
                    //deleteDepartment();
                    break;
            }
        } while (userAction != 0);

    }

    private static void doFacultyAction() {
        int userAction = 0;
        do {
            System.out.println("1. Створити факультет");
            System.out.println("2. Редагувати факультет");
            System.out.println("3. Видалити факультет");
            System.out.println("0. Вихід.");
            userAction = getUserInput(0, 3, "номер операції");

            switch (userAction) {
                case 1:
                    addFaculty();
                    break;
                case 2:
                    editFaculty();
                    break;
                case 3:
                    deleteFaculty();
                    break;
                case 0:
            }
        } while (userAction != 0);

    }

    private static void deleteFaculty() {
        do {
            String facultyName = getCorrectUserString("назва факультету");


            if (university.getFaculty(facultyName) == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {
                university.deleteFaculty(facultyName);
                System.out.println("Факультет " + facultyName + " видалено");
                InputUtils.printFaculties(university.getFaculties());
            }
            if (showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static int showYesNoMenu() {

        return getUserInput(0, 1, " режим ( 0 - завершити, 1 - продовжити)");


    }

    private static void editFaculty() {

        do {
            String facultyName = getCorrectUserString("назва факультету");


            if (university.getFaculty(facultyName) == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {
                String newName = getCorrectUserString("нова назва факультету");
                if (university.getFaculty(newName) != null) {
                    System.out.println("Факультет " + newName + " вже існує");
                } else {
                    university.editFaculty(facultyName, newName);
                    System.out.println("Факультет відредаговано");
                }
            }
            InputUtils.printFaculties(university.getFaculties());
            if (showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void addFaculty() {

        do {
            String facultyName = getCorrectUserString("назва факультету");

            if (university.getFaculty(facultyName) != null) {
                System.out.println("Факультет " + facultyName + " вже існує");
            } else {

                university.addFaculty(new Faculty(facultyName));
                System.out.println("Факультет створено");
                InputUtils.printFaculties(university.getFaculties());
            }

            if (showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void addDepartment() {

        do {

            System.out.println("Виберіть факультет");
            String facultyName = getCorrectUserString("назва факультету");
            Faculty faculty = university.getFaculty(facultyName);

            if (faculty == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {

                String departmentName = getCorrectUserString("назва кафедри");

                if (faculty.getAcademicDepartment(departmentName) != null) {
                    System.out.println("Кафедра " + departmentName + " вже існує");
                } else {

                    faculty.addAcademicDepartment(new AcademicDepartment(departmentName));
                    System.out.println("Кафедру створено");
                    InputUtils.printDepartments(faculty);
                }

                if (showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
    }

    private static void showMenu() {

        System.out.println("1. Робота з факультетом");
        System.out.println("2. Робота з кафедрою");
        System.out.println("3. Робота з викладачами/студентами");
        System.out.println("4. Знайти студента/викладача за ПІБ, курсом або групою.");
        System.out.println("5. Вивести всіх студентів впорядкованих за курсами");
        System.out.println("6. Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.");
        System.out.println("7. Вивести всіх студентів кафедри впорядкованих за курсами.");
        System.out.println("8. Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом.");
        System.out.println("9. Вивести всіх студентів кафедри вказаного курсу.");
        System.out.println("10. Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом.");
        System.out.println("0. Вихід.");
    }


}
