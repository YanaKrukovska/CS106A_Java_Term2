package ua.edu.ukma.ykrukovska.unit9.practice;

import org.junit.Assert;
import org.junit.Test;

public class GroupTest {

    @Test
    public void getBest() {

        Group group = new Group();
        group.addStudent(new Student("Justin", 40.5, "SpoonsStreet"));
        group.addStudent(new Student("Oleg", 40.3, "Olevska"));
        group.addStudent(new Student("Katy", 20.9, "Evergreen"));


        Student result = group.getBest();
        Assert.assertEquals("Justin", result.getName());

    }

    @Test
    public void getWorst() {

        Group group = new Group();
        group.addStudent(new Student("Katy", 20.9, "Evergreen"));
        group.addStudent(new Student("Justin", 40.5, "SpoonsStreet"));
        group.addStudent(new Student("Oleg", 40.3, "Olevska"));


        Student result = group.getWorst();
        Assert.assertEquals("Katy", result.getName());

    }
}