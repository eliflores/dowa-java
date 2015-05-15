package com.dowa.web.controllers;

import javax.faces.context.FacesContext;
import java.util.List;
import com.dowa.web.JsfUtil;
import com.dowa.web.model.UserSessionData;
import com.dowa.web.service.ServiceLocator;

public class HomeController {

    public HomeController() {
        System.out.println("#######created HomeController");
    }

    public String getWelcome() {
        UserSessionData userSession = JsfUtil.<UserSessionData>getBean("userSessionData", FacesContext.getCurrentInstance());
        return "Hi there " + userSession.getSessionValue() + " !!!";
    }

    public List<String> getNames() {
        return ServiceLocator.getFakeService().getNames();
    }


}
