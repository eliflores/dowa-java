package com.dowa.java.web.repository;

import com.dowa.java.web.connection.ConnectionFactory;
import com.dowa.java.web.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public Student findStudentByFirstName(String firstName) throws SQLException{
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        Student found = new Student();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM student WHERE first_name = ?");
            pstmt.setString(1, firstName);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                found.setFirstName(rs.getString(2));
                found.setLastName(rs.getString(3));
            }
        } catch (SQLException e){
            System.err.println("SQLException: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.err.println("Runtime Exception " + e.getMessage());
        }
        finally {
            conn.close();
        }
        return found;
    }
}