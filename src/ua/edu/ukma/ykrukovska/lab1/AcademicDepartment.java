package ua.edu.ukma.ykrukovska.lab1;


public class AcademicDepartment {

    private Faculty faculty;
    private int studentsCounter = 0;
    private int teachersCounter = 0;
    private String name;
    private Teacher[] teachers = new Teacher[10];
    private Student[] students = new Student[10];

    public void addStudent(Student student) {
        students[studentsCounter++] = student;
        student.setFaculty(this.getFaculty());
        student.setAcademicDepartment(this);

    }

    public Student getStudent(String studentsName) {

        for (int i = 0; i < studentsCounter; i++) {
            if (studentsName.equals(students[i].getName())) {
                return students[i];
            }
        }

        return null;

    }

    public void deleteStudent(String studentsName) {

        for (int i = 0; i < studentsCounter; i++) {
            if (studentsName.equals(students[i].getName())) {
                students[i] = null;
                for (int j = i + 1; j < studentsCounter; j++) {
                    students[j - 1] = students[j];

                }
                students[--studentsCounter] = null;
                break;
            }
        }
    }

    public void editStudent(String oldStudentsName, String newStudentsName) {

        for (int i = 0; i < studentsCounter; i++) {
            if (oldStudentsName.equals(students[i].getName())) {
                students[i].setName(newStudentsName);
                break;
            }
        }

    }

    public void addTeacher(Teacher teacher) {
        teachers[teachersCounter++] = teacher;
        teacher.setFaculty(this.getFaculty());
        teacher.setAcademicDepartment(this);

    }

    public Teacher getTeacher(String teachersName) {

        for (int i = 0; i < teachersCounter; i++) {
            if (teachersName.equals(teachers[i].getName())) {
                return teachers[i];
            }
        }

        return null;
    }

    public void deleteTeacher(String teachersName) {

        for (int i = 0; i < teachersCounter; i++) {
            if (teachersName.equals(teachers[i].getName())) {
                teachers[i] = null;
                for (int j = i +1; j < teachersCounter; j++) {
                    teachers[j - 1] = teachers[j];
                }
                teachers[--teachersCounter] = null;
                break;
            }
        }
    }

    public void editTeacher(String oldTeachersName, String newTeachersName) {

        for (int i = 0; i < teachersCounter; i++) {
            if (oldTeachersName.equals(teachers[i].getName())) {
                teachers[i].setName(newTeachersName);
                break;
            }
        }
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public AcademicDepartment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getStudentsCounter() {
        return studentsCounter;
    }

    public int getTeachersCounter() {
        return teachersCounter;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return  name;
    }
}
