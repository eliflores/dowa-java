package com.dowa.web.controllers;

import javax.faces.context.FacesContext;
import com.dowa.web.JsfUtil;
import com.dowa.web.model.UserSessionData;
import org.apache.commons.lang3.StringUtils;

public class LoginController {

    public LoginController() {
        System.out.println("#######created LoginController");
    }

    private String username = "user";
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String doLogin() {
        if (StringUtils.equals("admin", username)) {
            UserSessionData userSession = JsfUtil.<UserSessionData>getBean("userSessionData", FacesContext.getCurrentInstance());
            userSession.setSessionValue(username);
            return "success";
        }
        username = "";
        password = "";
        return "";
    }
}
