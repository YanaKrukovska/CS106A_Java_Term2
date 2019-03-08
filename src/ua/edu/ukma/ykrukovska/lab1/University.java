package ua.edu.ukma.ykrukovska.lab1;

public class University {

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
                for (int j = i++; j < facultyCounter; j++) {
                    faculties[j - 1] = faculties[j];
                }
                facultyCounter--;
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
}
