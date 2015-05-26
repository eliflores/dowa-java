package com.uabc.dowa.jdbc.repository;

//our model.
import com.uabc.dowa.jdbc.model.Student;

import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


public class StudentRepositoryTest {
    @Test
    public void testAddStudent() throws SQLException {
        //fail("Implement me!");
        StudentRepository repo = new StudentRepository();
        Student student = new Student();

        student.setFirstName("Antonio");
        student.setLastName("Garcia");
        repo.persistStudent(student);

        assertNotNull(repo.findStudentByFirstName(student.getFirstName()));

    }

    @Test
    public void testFindAllStudents() throws SQLException {
        //fail("Implement me!");
        StudentRepository repo = new StudentRepository();
        List <Student> allStuds = repo.findAllStudents();
        assertNotNull(allStuds);

    }

    @Test
    public void testFindStudentByFirstName()throws SQLException {
        //fail("Implement me!");
        String nameSearch = "Antonio";
        StudentRepository repo = new StudentRepository();
        Student search = repo.findStudentByFirstName(nameSearch);
        assertEquals(null, search.getFirstName());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        //fail("Implement me!");
        StudentRepository repo = new StudentRepository();
        Student student = new Student();
        student.setFirstName("Antonio");
        student.setLastName("Garcia");
        repo.deleteStudent(student);
        assertNull(repo.findStudentByFirstName(student.getFirstName()).getFirstName());
    }
}
