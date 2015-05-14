package com.dowa.web.model;

import java.io.Serializable;


public class UserSessionData implements Serializable {

    private String sessionValue;
    private String selectedName;

    public UserSessionData() {
        System.out.println("#######created UserSessionData");
    }

    public String getSessionValue() {
        return sessionValue;
    }

    public void setSessionValue(String sessionValue) {
        this.sessionValue = sessionValue;
    }

    public String getSelectedName() {
        return selectedName;
    }

    public void setSelectedName(String selectedName) {
        this.selectedName = selectedName;
    }
}
