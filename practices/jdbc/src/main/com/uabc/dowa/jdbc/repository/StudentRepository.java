package com.uabc.dowa.jdbc.repository;


import com.uabc.dowa.jdbc.connection.ConnToDB;
import com.uabc.dowa.jdbc.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public void persistStudent(Student student) throws SQLException {
        Connection conn = ConnToDB.getConnection();
        try{
            PreparedStatement pStatement = conn.prepareStatement("INSERT INTO students(firstName, lastName) VALUES(?, ?)");
            pStatement.setString(1,student.getFirstName());
            pStatement.setString(2,student.getLastName());
            pStatement.execute();
        } finally {
            if (conn != null){
                conn.close();
            }
        }
    }

    public List<Student> findAllStudents() throws SQLException {
        Connection conn = ConnToDB.getConnection();
        Student student = new Student();
        List <Student> allStudents = new ArrayList<Student>();
        try{
            PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM students");
            ResultSet result = pStatement.executeQuery();
            while (result.next()){
                student.setFirstName(result.getString(2));
                student.setLastName(result.getString(3));
                allStudents.add(student);
            }
        } finally {
            if (conn != null){
                conn.close();
            }
        }
        return allStudents;
    }

    public Student findStudentByFirstName(String firstName) throws SQLException {
        Connection conn = ConnToDB.getConnection();
        Student student = new Student();
        try {
            PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM students where firstName = ?");
            pStatement.setString(1, firstName);
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                student.setFirstName(result.getString(2));
                student.setLastName(result.getString(3));
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return student;
    }

    public void deleteStudent(Student student) throws SQLException {
        Connection conn = ConnToDB.getConnection();
        try {
            PreparedStatement pStatement = conn.prepareStatement("DELETE FROM students WHERE firstName = ? AND " +
                    "lastName = ?");
            pStatement.setString(1,student.getFirstName());
            pStatement.setString(2,student.getLastName());
            pStatement.execute();
        } finally {
            if (conn != null){
                conn.close();
            }
        }
    }

}
