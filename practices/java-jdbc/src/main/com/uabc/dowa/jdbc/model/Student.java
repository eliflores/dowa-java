package com.uabc.dowa.jdbc.model;

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

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }
}
