package com.uabc.dowa.jdbc.repository;

import com.uabc.dowa.jdbc.model.Student;


import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentRepositoryTest {
    @Test
    public void testAddStudent() throws SQLException {
        StudentRepository repo = new StudentRepository();
        Student student = new Student();
        student.setFirstName("Miguel");
        student.setLastName("Garcia");
        repo.persistStudent(student);
        assertNotNull(repo.findStudentByFirstName(student.getFirstName()));
    }

    @Test
    public void testFindAllStudents() throws SQLException {
        StudentRepository repo = new StudentRepository();
        List<Student> allStudents = repo.findAllStudents();
        assertEquals(allStudents.size(), 1);
    }

    @Test
    public void testFindStudentByFirstName() throws SQLException {
        String student = "Miguel";
        StudentRepository repo = new StudentRepository();
        Student search = repo.findStudentByFirstName(student);
        assertEquals( student, search.getFirstName());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        StudentRepository repo = new StudentRepository();
        Student student = new Student();
        student.setFirstName("Miguel");
        student.setLastName("Garcia");
        repo.deleteStudent(student);
        assertNull(repo.findStudentByFirstName(student.getFirstName()).getFirstName());
    }
}
