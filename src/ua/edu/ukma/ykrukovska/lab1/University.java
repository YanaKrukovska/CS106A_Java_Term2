package ua.edu.ukma.ykrukovska.lab1;

public class University {

    public static final int MAX_AMOUNT_OF_STUDENTS = 100;
    private int facultyCounter = 0;

    private Faculty[] faculties = new Faculty[10];


    public void addFaculty(Faculty faculty) {
        faculties[facultyCounter++] = faculty;
    }

    public Faculty getFaculty(String facultyName) {
        for (int i = 0; i < facultyCounter; i++) {
            if (facultyName.equals(faculties[i].getName())) {
                return faculties[i];
            }
        }
        return null;
    }

    public void deleteFaculty(String facultyName) {
        for (int i = 0; i < facultyCounter; i++) {
            if (facultyName.equals(faculties[i].getName())) {
                faculties[i] = null;
                for (int j = i + 1; j < facultyCounter; j++) {
                    faculties[j - 1] = faculties[j];

                }
                faculties[--facultyCounter] = null;
                break;
            }
        }
    }

    public void editFaculty(String oldFacultyName, String newFacultyName) {
        for (int i = 0; i < facultyCounter; i++) {
            if (oldFacultyName.equals(faculties[i].getName())) {
                faculties[i].setName(newFacultyName);
            }
        }
    }


    public Student[] findStudentByName(String name) {

        Student[] result = new Student[100];
        int resultCounter = 0;

        for (int i = 0; i < facultyCounter; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.getAcademicDepartmentCounter(); j++) {
                AcademicDepartment department = faculty.getAcademicDepartments()[j];

                for (int k = 0; k < department.getStudentsCounter(); k++) {
                    if (department.getStudents()[k].getName().equals(name)) {

                        result[resultCounter++] = department.getStudents()[k];
                    }
                }

            }
        }
        return result;
    }

    public Student[] findStudentByCourse(int course) {
        Student[] result = new Student[100];
        int resultCounter = 0;

        for (int i = 0; i < facultyCounter; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.getAcademicDepartmentCounter(); j++) {
                AcademicDepartment department = faculty.getAcademicDepartments()[j];

                for (int k = 0; k < department.getStudentsCounter(); k++) {
                    if (department.getStudents()[k].getCourse() == course) {

                        result[resultCounter++] = department.getStudents()[k];
                    }
                }
            }
        }


        return result;
    }

    public Student[] findStudentByGroup(String group) {

        Student[] result = new Student[100];
        int resultCounter = 0;

        for (int i = 0; i < facultyCounter; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.getAcademicDepartmentCounter(); j++) {
                AcademicDepartment department = faculty.getAcademicDepartments()[j];

                for (int k = 0; k < department.getStudentsCounter(); k++) {
                    if (department.getStudents()[k].getGroup().equals(group)) {

                        result[resultCounter++] = department.getStudents()[k];
                    }
                }

            }
        }
        return result;


    }

    public Teacher[] findTeacherByName(String name) {

        Teacher[] result = new Teacher[100];
        int resultCounter = 0;

        for (int i = 0; i < facultyCounter; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.getAcademicDepartmentCounter(); j++) {
                AcademicDepartment department = faculty.getAcademicDepartments()[j];

                for (int k = 0; k < department.getTeachersCounter(); k++) {
                    if (department.getTeachers()[k].getName().equals(name)) {

                        result[resultCounter++] = department.getTeachers()[k];
                    }
                }

            }
        }
        return result;
    }

    public Student[] getAllStudents() {

        Student[] result = new Student[MAX_AMOUNT_OF_STUDENTS];
        int resultCounter = 0;


        for (int i = 0; i < facultyCounter; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.getAcademicDepartmentCounter(); j++) {
                AcademicDepartment department = faculty.getAcademicDepartments()[j];

                for (int k = 0; k < department.getStudentsCounter(); k++) {

                    result[resultCounter++] = department.getStudents()[k];

                }
            }
        }

        return result;
    }

    public Student[] getAllStudentOrderByCourse() {


        return SortUtils.sortStudentsByCourse(getAllStudents());
    }

    public Person[] getStudentsOfFacultyByName(String facultyName) {

        Student[] result = new Student[100];
        int resultCounter = 0;


        for (int i = 0; i < facultyCounter; i++) {
            if (faculties[i].getName().equals(facultyName)) {


                for (int j = 0; j < faculties[i].getAcademicDepartmentCounter(); j++) {
                    AcademicDepartment department = faculties[i].getAcademicDepartments()[j];

                    for (int k = 0; k < department.getStudentsCounter(); k++) {

                        result[resultCounter++] = department.getStudents()[k];

                    }
                }

            }
        }
        return SortUtils.sortByName(result);


    }

    public Person[] getTeachersOfFacultyByName(String facultyName) {

        Teacher[] result = new Teacher[MAX_AMOUNT_OF_STUDENTS];
        int resultCounter = 0;


        for (int i = 0; i < facultyCounter; i++) {
            if (faculties[i].getName().equals(facultyName)) {


                for (int j = 0; j < faculties[i].getAcademicDepartmentCounter(); j++) {
                    AcademicDepartment department = faculties[i].getAcademicDepartments()[j];

                    for (int k = 0; k < department.getTeachersCounter(); k++) {

                        result[resultCounter++] = department.getTeachers()[k];

                    }
                }

            }
        }
        return SortUtils.sortByName(result);

    }

    public Student[] getStudentsOfDepartmentOrderByCourse(String departmentName) {


        return SortUtils.sortStudentsByCourse(getStudentsOfDepartment(departmentName));

    }

    public Student[] getStudentsOfDepartment(String departmentName) {
        Student[] result = new Student[MAX_AMOUNT_OF_STUDENTS];

        int resultCounter = 0;
        for (int i = 0; i < facultyCounter; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.getAcademicDepartmentCounter(); j++) {

                AcademicDepartment department = faculty.getAcademicDepartments()[j];

                if (department.getName().equals(departmentName)) {
                    for (int k = 0; k < department.getStudentsCounter(); k++) {

                        result[resultCounter++] = department.getStudents()[k];

                    }
                }
            }

        }
        return result;
    }

    public Teacher[] getTeachersOfDepartment(String departmentName) {
        Teacher[] result = new Teacher[MAX_AMOUNT_OF_STUDENTS];

        int resultCounter = 0;
        for (int i = 0; i < facultyCounter; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.getAcademicDepartmentCounter(); j++) {

                AcademicDepartment department = faculty.getAcademicDepartments()[j];

                if (department.getName().equals(departmentName)) {
                    for (int k = 0; k < department.getTeachersCounter(); k++) {

                        result[resultCounter++] = department.getTeachers()[k];

                    }
                }
            }

        }
        return result;
    }

    public Person[] getStudentsOfDepartmentOrderByName(String departmentName) {

        return SortUtils.sortByName(getStudentsOfDepartment(departmentName));

    }


    public Person[] getTeachersOfDepartmentOrderByName(String departmentName) {
        return SortUtils.sortByName(getTeachersOfDepartment(departmentName));
    }

    public Student[] getStudentsOfDepartmentAndCourse(String departmentName, int course) {

        Student[] result = new Student[MAX_AMOUNT_OF_STUDENTS];

        int resultCounter = 0;
        for (int i = 0; i < facultyCounter; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.getAcademicDepartmentCounter(); j++) {

                AcademicDepartment department = faculty.getAcademicDepartments()[j];

                if (department.getName().equals(departmentName)) {
                    for (int k = 0; k < department.getStudentsCounter(); k++) {
                        if (department.getStudents()[k].getCourse() == course) {
                            result[resultCounter++] = department.getStudents()[k];

                        }
                    }
                }
            }
        }
        return result;
    }

    public Student[] getStudentsOfDepartmentAndCourseOrderByName(String departmentName, int course) {

        return (Student[]) SortUtils.sortByName(getStudentsOfDepartmentAndCourse(departmentName, course));
    }

    public Faculty[] getFaculties() {
        return faculties;
    }
}