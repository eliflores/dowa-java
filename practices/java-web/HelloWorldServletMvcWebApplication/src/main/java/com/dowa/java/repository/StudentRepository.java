package com.dowa.java.repository;

import com.dowa.java.connection.SmartConnection;
import com.dowa.java.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public static void persistStudent(Student student) throws SQLException {

        String SQL = "INSERT INTO Student (firstName, lastName) VALUES( ?, ?)";

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = SmartConnection.getConnection();

            stm = conn.prepareStatement(SQL);

            stm.setString(1, student.getFirstName());
            stm.setString(2, student.getLastName());

            stm.executeUpdate();

            System.out.println("Student saved...");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if(stm != null){
                stm.close();
            }

            if(conn != null){
                conn.close();
            }
        }


    }

    public static List<Student> findAllStudents() throws SQLException {
        String SQL = "SELECT * FROM Student";

        Connection conn = null;
        PreparedStatement stm = null;

        List<Student> myStudentList = new ArrayList<>();

        try {
            conn = SmartConnection.getConnection();

            stm = conn.prepareStatement(SQL);

            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                Student student = new Student();
                System.out.println(rs.getString("firstName"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                myStudentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if(stm != null){
                stm.close();
            }

            if(conn != null){
                conn.close();
            }
        }

        return myStudentList;
    }

    public static Student findStudentByFirstName(String firstName) throws SQLException {
        List<Student> students = StudentRepository.findAllStudents();
        for(Student student: students){
            if (student.getFirstName().equals(firstName))
                return student;
        }

        return null;
    }

    public static void deleteStudent(Student student) throws SQLException{

        Connection conn = null;
        PreparedStatement stm = null;

        String SQL = "DELETE FROM Student WHERE firstName = ? AND lastName = ?";

        try {
            conn = SmartConnection.getConnection();

            stm = conn.prepareStatement(SQL);

            stm.setString(1, student.getFirstName());
            stm.setString(2, student.getLastName());

            stm.executeUpdate();

            System.out.println("Student deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if(stm != null){
                stm.close();
            }

            if(conn != null){
                conn.close();
            }
        }

    }
}
