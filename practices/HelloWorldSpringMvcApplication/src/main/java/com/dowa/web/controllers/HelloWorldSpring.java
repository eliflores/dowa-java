package com.dowa.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldSpring {
    @RequestMapping(value="/hello-spring-mvc/", method= RequestMethod.GET) //pagina a la que va a controlar esta clase
    public String helloWorld(Model model){
        model.addAttribute("message", "Stars rocks!");
        return "index"; //Regresa la vista a la cual este controlador maneja
    }
}
