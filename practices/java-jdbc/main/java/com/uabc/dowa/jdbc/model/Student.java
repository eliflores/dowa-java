package com.uabc.dowa.jdbc.model;

/**
 * Created by ferzerkerx on 4/14/15.
 */
public class Student {
    private int _id;
    private String _firstName;
    private String _lastName;

    public int getId() {
        return _id;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }
}
