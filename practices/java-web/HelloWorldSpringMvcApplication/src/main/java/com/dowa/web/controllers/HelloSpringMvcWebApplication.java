package com.dowa.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloSpringMvcWebApplication {
    @RequestMapping(value = "/hello-spring-mvc/", method = RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("message", "Star Wars Rocks!");
        return "index";
    }

    @RequestMapping(value = "/hello-spring-mvc-params", method = RequestMethod.POST)
    public String welcome(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }
}

