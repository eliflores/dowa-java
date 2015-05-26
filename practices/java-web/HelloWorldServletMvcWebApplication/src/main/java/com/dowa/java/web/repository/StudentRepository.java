package com.dowa.java.web.repository;

/**
 * Created by Tonoid on 5/20/2015.
 */

//this import have the connection to our data base.
import com.dowa.java.web.connection.CreateConnection;
//this has the model for Student, again we do this in order to have MVC style.
import com.dowa.java.web.model.StudentLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public StudentLogin findStudentByFirstName(String firstName) throws SQLException{

        Connection conn = CreateConnection.getConnection();
        PreparedStatement preStatement; //sql.
        ResultSet result;//result from the execution of
        StudentLogin found = new StudentLogin();

        try {

            preStatement = conn.prepareStatement("SELECT * FROM student WHERE name = ?");
            preStatement.setString(1, firstName);
            result = preStatement.executeQuery();

            if(result.next()) {
                found.setFirstName(result.getString(2));
                found.setLastName(result.getString(3));
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
