package com.uabc.dowa.jdbc.repository;

import com.uabc.dowa.jdbc.model.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentRepositoryTest {
    @Test
    public void testAddStudent() throws SQLException {
        StudentRepository repo = new StudentRepository();
        Student student = new Student();
        student.setFirstName("Alejandro");
        student.setLastName("Ramirez");
        repo.persistStudent(student);
        assertNotNull(repo.findStudentByFirstName(student.getFirstName()));
    }

    @Test
    public void testFindAllStudents() throws SQLException {
        StudentRepository repo = new StudentRepository();
        List <Student> allStuds = repo.findAllStudents();
        //I am not really sure ih this is fine for the test
        assertNotNull(allStuds);
    }

    @Test
    public void testFindStudentByFirstName() throws SQLException {
        String nameSearch = "Marco";
        StudentRepository repo = new StudentRepository();
        Student search = repo.findStudentByFirstName(nameSearch);
        assertEquals(null, search.getFirstName());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        StudentRepository repo = new StudentRepository();
        Student student = new Student();
        student.setFirstName("Alejandro");
        student.setLastName("Ramirez");
        repo.deleteStudent(student);
        assertNull(repo.findStudentByFirstName(student.getFirstName()).getFirstName());
    }
}
