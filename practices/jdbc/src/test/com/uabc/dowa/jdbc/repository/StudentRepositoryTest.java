package com.uabc.dowa.jdbc.repository;

import com.uabc.dowa.jdbc.model.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class StudentRepositoryTest {
    @Test
    public void testAddStudent() throws SQLException {
        StudentRepository rep = new StudentRepository();
        Student student = new Student();
        student.setFirstName("Miriam");
        student.setLastName("Rod");
        rep.persistStudent(student);
        assertNotNull(rep.findStudentByFirstName(student.getFirstName()));
    }

    @Test
    public void testFindAllStudents() throws SQLException {
        StudentRepository rep = new StudentRepository();
        List<Student> allStudents = rep.findAllStudents();
        assertEquals(allStudents.size(),1);
    }

    @Test
    public void testFindStudentByFirstName() throws SQLException {
        String name = "Miriam";
        StudentRepository rep = new StudentRepository();
        Student student = rep.findStudentByFirstName(name);
        assertEquals(name, student.getFirstName());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        StudentRepository rep = new StudentRepository();
        Student student = new Student();
        student.setFirstName("Miriam");
        student.setLastName("Rod");
        rep.deleteStudent(student);
        assertNull(rep.findStudentByFirstName(student.getFirstName()).getFirstName());
    }
}
