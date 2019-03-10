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
                case 3:
                    doPersonAction();
                    break;
                case 4:
                    doSearchingAction();
                    break;
                case 5:
                    doSortingStudentsByCourse();
                    break;
                case 6:
                    doSortingByName();
                    break;
                case 7:
                    doSortingDepartmentStudentsByCourse();
                    break;
                case 8:
                    doDepartmentPersonSortingByName();
                    break;
                case 9:
                    doSearchingOfStudentsByDepartmentAndCourse();
                    break;
                case 10:
                    doSortingDepartmentCourseStudentsByName();
                    break;
            }

        } while (userAction != 0);

    }

    private static void doSortingDepartmentCourseStudentsByName() {
        do {
            String departmentName = getCorrectUserString("кафедра");
            int course = getUserInput(1, 6, "курс");
            Student[] students = (university.getStudentsOfDepartmentAndCourseOrderByName(departmentName, course));
            if (students[0] == null) {
                System.out.println("Студенти не існують");
            } else {
                InputUtils.printPersons(students);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void doSearchingOfStudentsByDepartmentAndCourse() {
        do {
            String departmentName = getCorrectUserString("кафедра");
            int course = getUserInput(1, 6, "курс");
            Student[] students = (university.getStudentsOfDepartmentAndCourse(departmentName, course));
            if (students[0] == null) {
                System.out.println("Студенти не існують");
            } else {
                InputUtils.printPersons(students);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void doDepartmentPersonSortingByName() {
        int userAction = 0;
        do {
            System.out.println("1. Вивести всіх студентів кафедри впорядкованих за алфавітом.");
            System.out.println("2. Вивести всіх викладачів кафедри впорядкованих за алфавітом.");
            System.out.println("0. Вихід.");
            userAction = getUserInput(0, 2, "номер операції");

            switch (userAction) {
                case 1:
                    orderDepartmentStudentsByName();
                    break;
                case 2:
                    orderDepartmentTeachersByName();
                    break;
                case 0:
            }
        } while (userAction != 0);
    }

    private static void orderDepartmentTeachersByName() {
        do {
            String departmentName = getCorrectUserString("кафедра");
            Teacher[] teachers = (Teacher[]) university.getTeachersOfDepartmentOrderByName(departmentName);
            if (teachers[0] == null) {
                System.out.println("Студенти не існують");
            } else {
                InputUtils.printPersons(teachers);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void orderDepartmentStudentsByName() {
        do {
            String departmentName = getCorrectUserString("кафедра");
            Student[] students = (Student[]) university.getStudentsOfDepartmentOrderByName(departmentName);
            if (students[0] == null) {
                System.out.println("Студенти не існують");
            } else {
                InputUtils.printPersons(students);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void doSortingDepartmentStudentsByCourse() {
        do {
            String departmentName = getCorrectUserString("кафедра");
            Student[] students = (university.getStudentsOfDepartmentOrderByCourse(departmentName));
            if (students[0] == null) {
                System.out.println("Студенти не існують");
            } else {
                InputUtils.printPersons(students);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void doSortingByName() {
        int userAction = 0;
        do {
            System.out.println("1. Вивести всіх студентів факультета впорядкованих за алфавітом.");
            System.out.println("2. Вивести всіх викладачів факультета впорядкованих за алфавітом.");
            System.out.println("0. Вихід.");
            userAction = getUserInput(0, 2, "номер операції");

            switch (userAction) {
                case 1:
                    orderFacultyStudentsByName();
                    break;
                case 2:
                    orderFacultyTeachersByName();
                    break;
            }
        } while (userAction != 0);
    }

    private static void orderFacultyTeachersByName() {
        do {
            String facultyName = getCorrectUserString("факультет");
            Teacher[] teachers = (Teacher[]) university.getTeachersOfFacultyByName(facultyName);
            if (teachers[0] == null) {
                System.out.println("Студенти не існують");
            } else {
                InputUtils.printPersons(teachers);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void orderFacultyStudentsByName() {
        do {
            String facultyName = getCorrectUserString("факультет");
            Student[] students = (Student[]) university.getStudentsOfFacultyByName(facultyName);
            if (students[0] == null) {
                System.out.println("Студенти не існують");
            } else {
                InputUtils.printPersons(students);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void doSortingStudentsByCourse() {

        do {

            Student[] students = university.getAllStudentOrderByCourse();
            if (students[0] == null) {
                System.out.println("Студентів не існує");
            } else {
                InputUtils.printPersons(students);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void doSearchingAction() {
        int userAction = 0;
        do {
            System.out.println("1. Знайти студента за ПІБ");
            System.out.println("2. Знайти студента за курсом");
            System.out.println("3. Знайти студента за групою.");
            System.out.println("4. Знайти викладача за ПІБ");
            System.out.println("0. Вихід.");
            userAction = getUserInput(0, 4, "номер операції");

            switch (userAction) {
                case 1:
                    findStudentByName();
                    break;
                case 2:
                    findStudentByCourse();
                    break;
                case 3:
                    findStudentByGroup();
                    break;
                case 4:
                    findTeacherByName();
                    break;
            }
        } while (userAction != 0);
    }

    private static void findTeacherByName() {
        do {
            String name = getCorrectUserString("ПІБ викладача");

            Teacher[] teachers = university.findTeacherByName(name);
            if (teachers[0] == null) {
                System.out.println("Викладач не існує");
            } else {
                InputUtils.printPersons(teachers);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);

    }

    private static void findStudentByGroup() {
        do {
            String group = getCorrectUserString("група");

            Student[] students = university.findStudentByGroup(group);
            if (students[0] == null) {
                System.out.println("Студент не існує");
            } else {
                InputUtils.printPersons(students);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void findStudentByCourse() {
        do {
            int course = getUserInput(1, 6, "курс");

            Student[] students = university.findStudentByCourse(course);
            if (students[0] == null) {
                System.out.println("Студент не існує");
            } else {
                InputUtils.printPersons(students);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
    }

    private static void findStudentByName() {
        do {
            String name = getCorrectUserString("ПІБ студента");

            Student[] students = university.findStudentByName(name);
            if (students[0] == null) {
                System.out.println("Студент не існує");
            } else {
                InputUtils.printPersons(students);
            }
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);

    }

    private static void doPersonAction() {
        int userAction = 0;
        do {
            System.out.println("1. Створити студента");
            System.out.println("2. Редагувати  студента");
            System.out.println("3. Видалити  студента");
            System.out.println("4. Створити викладача");
            System.out.println("5. Редагувати  викладача");
            System.out.println("6. Видалити  викладача");
            System.out.println("0. Вихід.");
            userAction = getUserInput(0, 6, "номер операції");

            switch (userAction) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    addTeacher();
                    break;
                case 5:
                    editTeacher();
                    break;
                case 6:
                    deleteTeacher();
                    break;
            }
        } while (userAction != 0);

    }

    private static void deleteTeacher() {
        do {
            System.out.println("Виберіть факультет");
            String facultyName = getCorrectUserString("назва факультету");
            Faculty faculty = university.getFaculty(facultyName);

            if (faculty == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {
                String departmentName = getCorrectUserString("назва кафедри");
                AcademicDepartment department = faculty.getAcademicDepartment(departmentName);
                if (department == null) {
                    System.out.println("Кафедра " + departmentName + " не існує");
                    InputUtils.printDepartments(faculty);
                } else {
                    String name = getCorrectUserString("ПІБ викладача");
                    if (department.getTeacher(name) == null) {
                        System.out.println("Викладача не існує");
                    } else {

                        department.deleteTeacher(name);
                        System.out.println("Викладача видалено");
                    }

                    InputUtils.printDepartmentTeachers(department);
                }

                if (InputUtils.showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
    }

    private static void deleteStudent() {
        do {
            System.out.println("Виберіть факультет");
            String facultyName = getCorrectUserString("назва факультету");
            Faculty faculty = university.getFaculty(facultyName);

            if (faculty == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {
                String departmentName = getCorrectUserString("назва кафедри");
                AcademicDepartment department = faculty.getAcademicDepartment(departmentName);
                if (department == null) {
                    System.out.println("Кафедра " + departmentName + " не існує");
                    InputUtils.printDepartments(faculty);
                } else {
                    String name = getCorrectUserString("ПІБ студента");
                    if (department.getStudent(name) == null) {
                        System.out.println("Студент не існує");
                    } else {

                        department.deleteStudent(name);
                        System.out.println("Студента видалено");
                    }

                    InputUtils.printDepartmentStudents(department);
                }

                if (InputUtils.showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
    }

    private static void editTeacher() {
        do {
            System.out.println("Виберіть факультет");
            String facultyName = getCorrectUserString("назва факультету");
            Faculty faculty = university.getFaculty(facultyName);

            if (faculty == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {
                String departmentName = getCorrectUserString("назва кафедри");
                AcademicDepartment department = faculty.getAcademicDepartment(departmentName);
                if (department == null) {
                    System.out.println("Кафедра " + departmentName + " не існує");
                    InputUtils.printDepartments(faculty);

                } else {
                    String oldName = getCorrectUserString("ПІБ викладача");
                    if (department.getTeacher(oldName) == null) {
                        System.out.println("Викладач не існує");
                    } else {
                        String newName = getCorrectUserString("новий ПІБ викладача");
                        if (department.getTeacher(newName) != null) {
                            System.out.println("Викладач " + newName + " вже існує");
                        } else {
                            department.editTeacher(oldName, newName);
                            System.out.println("Викладача відредаговано");
                        }
                    }
                    InputUtils.printDepartmentTeachers(department);
                }

                if (InputUtils.showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
    }


    private static void addTeacher() {
        do {

            System.out.println("Виберіть факультет");
            String facultyName = getCorrectUserString("назва факультету");
            Faculty faculty = university.getFaculty(facultyName);

            if (faculty == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {

                String departmentName = getCorrectUserString("назва кафедри");
                AcademicDepartment department = faculty.getAcademicDepartment(departmentName);

                if (department == null) {
                    System.out.println("Кафедра " + departmentName + " не існує");
                    InputUtils.printDepartments(faculty);

                } else {
                    String name = getCorrectUserString("ПІБ викладача");
                    if (department.getTeacher(name) != null) {
                        System.out.println("Викладач вже існує");
                    } else {

                        department.addTeacher(new Teacher(name));
                        System.out.println("Викладача створено");
                    }
                    InputUtils.printDepartmentTeachers(department);
                }

                if (InputUtils.showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
    }

    private static void addStudent() {
        do {

            System.out.println("Виберіть факультет");
            String facultyName = getCorrectUserString("назва факультету");
            Faculty faculty = university.getFaculty(facultyName);

            if (faculty == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {

                String departmentName = getCorrectUserString("назва кафедри");
                AcademicDepartment department = faculty.getAcademicDepartment(departmentName);


                if (department == null) {
                    System.out.println("Кафедра " + departmentName + " не існує");
                    InputUtils.printDepartments(faculty);
                } else {
                    String name = getCorrectUserString("ПІБ студента");
                    if (department.getStudent(name) != null) {
                        System.out.println("Студент вже існує");
                    } else {
                        int course = getUserInput(1, 6, "Курс");
                        String group = getCorrectUserString("Група");
                        department.addStudent(new Student(name, course, group));
                        System.out.println("Студента створено");
                    }
                    InputUtils.printDepartmentStudents(department);
                }

                if (InputUtils.showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
    }

    private static void editStudent() {

        do {
            System.out.println("Виберіть факультет");
            String facultyName = getCorrectUserString("назва факультету");
            Faculty faculty = university.getFaculty(facultyName);

            if (faculty == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {
                String departmentName = getCorrectUserString("назва кафедри");
                AcademicDepartment department = faculty.getAcademicDepartment(departmentName);
                if (department == null) {
                    System.out.println("Кафедра " + departmentName + " не існує");
                    InputUtils.printDepartments(faculty);
                } else {
                    String oldName = getCorrectUserString("ПІБ студента");
                    if (department.getStudent(oldName) == null) {
                        System.out.println("Студента не існує");
                    } else {
                        String newName = getCorrectUserString("новий ПІБ студента");
                        if (department.getStudent(newName) != null) {
                            System.out.println("Студента " + newName + " вже існує");
                        } else {
                            department.editStudent(oldName, newName);
                            System.out.println("Студента відредаговано");
                        }
                    }
                    InputUtils.printDepartmentStudents(department);
                }

                if (InputUtils.showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
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
                    editDepartment();
                    break;
                case 3:
                    deleteDepartment();
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
            if (InputUtils.showYesNoMenu() == 0) {
                break;
            }
        } while (true);
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
            if (InputUtils.showYesNoMenu() == 0) {
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

            if (InputUtils.showYesNoMenu() == 0) {
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

                if (InputUtils.showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
    }

    private static void editDepartment() {

        do {
            System.out.println("Виберіть факультет");
            String facultyName = getCorrectUserString("назва факультету");
            Faculty faculty = university.getFaculty(facultyName);

            if (faculty == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {
                String departmentName = getCorrectUserString("назва кафедри");

                if (faculty.getAcademicDepartment(departmentName) == null) {
                    System.out.println("Кафедра " + departmentName + " не існує");
                } else {
                    String newName = getCorrectUserString("нова назва кафедри");
                    if (faculty.getAcademicDepartment(newName) != null) {
                        System.out.println("Кафедра " + newName + " вже існує");
                    } else {
                        faculty.editAcademicDepartment(departmentName, newName);
                        System.out.println("Кафедру відредаговано");
                    }
                }
                InputUtils.printDepartments(faculty);

                if (InputUtils.showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
    }

    private static void deleteDepartment() {
        do {
            System.out.println("Виберіть факультет");
            String facultyName = getCorrectUserString("назва факультету");
            Faculty faculty = university.getFaculty(facultyName);

            if (faculty == null) {
                System.out.println("Факультет " + facultyName + " не існує");
            } else {
                String departmentName = getCorrectUserString("назва кафедри");

                if (faculty.getAcademicDepartment(departmentName) == null) {
                    System.out.println("Кафедра " + departmentName + " не існує");
                } else {
                    faculty.deleteAcademicDepartment(departmentName);
                    System.out.println("Кафедру " + departmentName + " видалено");
                    InputUtils.printDepartments(faculty);
                }
                if (InputUtils.showYesNoMenu() == 0) {
                    break;
                }
            }
        } while (true);
    }

    private static void showMenu() {

        System.out.println("1. Робота з факультетом");
        System.out.println("2. Робота з кафедрою");
        System.out.println("3. Робота з студентами/викладачами");
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
