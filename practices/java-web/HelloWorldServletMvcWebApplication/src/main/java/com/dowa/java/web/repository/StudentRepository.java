package com.dowa.java.web.repository;
import com.dowa.java.web.model.Student;
import com.dowa.java.web.database.DatabaseConnection;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentRepository {
    public void persistStudent(Student student) throws SQLException {
        String SQL = "INSERT " +
                     "INTO student (first_name,last_name) " +
                     "VALUES (?, ?) ";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.execute();
        }
    }

    public List<Student> findAllStudents() throws SQLException {
        String SQL = "SELECT * " +
                     "FROM student";
        Student student = new Student();
        List <Student> allStudents= new ArrayList<Student>();
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL)) {
            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    student.setFirstName(result.getString(2));
                    student.setLastName(result.getString(3));
                    allStudents.add(student);
                }

            }
        }
        return allStudents;
    }

    public Student findStudentByFirstName(String firstName) throws SQLException {
        String SQL =  "SELECT * " +
                      "FROM student " +
                      "WHERE first_name = ?";
        Student student = new Student();
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setString(1, firstName);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    student.setFirstName(result.getString(2));
                    student.setLastName(result.getString(3));
                }
            }
        }
        return student;
    }

    public void deleteStudent(Student student) throws SQLException {
        String SQL =  "DELETE FROM student " +
                      "WHERE first_name = ?"+
                      "AND last_name = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.execute();
        }
    }
}
