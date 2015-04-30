package com.uabc.dowa.jdbc.repository;

import org.junit.Test;

import com.uabc.dowa.jdbc.model.Student;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class StudentRepositoryTest {
    @Test
    public void testAddStudent() throws SQLException {

        StudentRepository repository = new StudentRepository();

        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Duarte");

        repository.persistStudent(student);
    }

    @Test
    public void testFindAllStudents() throws SQLException {
        StudentRepository repository = new StudentRepository();

        assertEquals(repository.findAllStudents().size(), 0);
    }

    @Test
    public void testFindStudentByFirstName() throws SQLException {
        StudentRepository repository = new StudentRepository();

        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Duarte");

        repository.persistStudent(student);

        Student newStudent = repository.findStudentByFirstName(student.getFirstName());

        assertEquals(student.getFirstName(), newStudent.getFirstName());
        assertEquals(student.getLastName(), newStudent.getLastName());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        StudentRepository repository = new StudentRepository();

        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Duarte");

        repository.persistStudent(student);

        repository.deleteStudent(student);

        assertNull(repository.findStudentByFirstName(student.getFirstName()));
    }
}
