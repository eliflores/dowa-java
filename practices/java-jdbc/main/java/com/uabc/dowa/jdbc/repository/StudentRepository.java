package com.uabc.dowa.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uabc.dowa.jdbc.dbconnection.Connection;
import com.uabc.dowa.jdbc.model.Student;
/**
 * Created by nexuz 05/31/15
 */
public class StudentRepository {
    public void persistStudent(Student student) throws SQLException {
        Connection conn = Connection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO student (first_name, last_name) VALUES ('"+student.getFirstName()+
                    "','"+student.getLastName()+"')");
            pstmt.execute();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            conn.close();
        }
    }

    public List<Student> findAllStudents() throws SQLException {
        Connection conn = Connection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = new Student();
        List <Student> allStuds= new ArrayList<Student>();
        pstmt = conn.prepareStatement("SELECT * FROM student");
        try {
            rs = pstmt.executeQuery();

            while(rs.next()) {
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                allStuds.add(student);
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            conn.close();
        }
        return allStuds;
    }

    public Student findStudentByFirstName(String firstName) throws SQLException{
        Connection conn = Connection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student found = new Student();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM student WHERE first_name =" +
                    " '" + firstName + "'");
            rs = pstmt.executeQuery();
            if(rs.next()) {
                found.setFirstName(rs.getString(2));
                found.setLastName(rs.getString(3));
            }
        } catch (SQLException e){
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            conn.close();
        }
        return found;
    }

    public void deleteStudent(Student student) throws SQLException{
        Connection conn = Connection.getConnection();
        PreparedStatement prepStm = null;

        try {
            prepStm = conn.prepareStatement("DELETE FROM student WHERE first_name" +
                    " = '"+student.getFirstName()+
                    "' AND last_name = '"+student.getLastName()+"'");
            prepStm.execute();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }finally {
            conn.close();
        }
    }
}