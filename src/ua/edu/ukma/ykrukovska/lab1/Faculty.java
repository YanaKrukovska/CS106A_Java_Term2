package ua.edu.ukma.ykrukovska.lab1;

public class Faculty {

    private int academicDepartmentCounter = 0;
    private String name;
    private AcademicDepartment[] academicDepartments = new AcademicDepartment[10];

    public void addAcademicDepartment(AcademicDepartment academicDepartment) {
        academicDepartments[academicDepartmentCounter++] = academicDepartment;
        academicDepartment.setFaculty(this);
    }

    public AcademicDepartment getAcademicDepartment(String academicDepartmentName) {

        for (int j = 0; j < academicDepartmentCounter; j++) {
            if (academicDepartmentName.equals(academicDepartments[j].getName())) {
                return academicDepartments[j];
            }
        }
        return null;
    }

    public void deleteAcademicDepartment(String academicDepartmentName) {
        for (int i = 0; i < academicDepartmentCounter; i++) {
            if (academicDepartmentName.equals(academicDepartments[i].getName())) {
                academicDepartments[i] = null;
                for (int j = i + 1; j < academicDepartmentCounter; j++) {
                    academicDepartments[j - 1] = academicDepartments[j];
                }
                academicDepartments[--academicDepartmentCounter] = null;
                break;
            }
        }
    }

    public void editAcademicDepartment(String oldAcademicDepartmentName, String newAcademicDepartmentName) {

        for (int i = 0; i < academicDepartmentCounter; i++) {
            if (oldAcademicDepartmentName.equals(academicDepartments[i].getName())) {
                academicDepartments[i].setName(newAcademicDepartmentName);
                break;
            }
        }
    }

    public AcademicDepartment[] getAcademicDepartments() {
        return academicDepartments;
    }

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcademicDepartmentCounter() {
        return academicDepartmentCounter;
    }

    @Override
    public String toString() {
        return name;
    }
}
