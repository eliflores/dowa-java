package com.dowa.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Greetings {
    @RequestMapping(value = "/hello-spring-mvc-params", method = RequestMethod.POST)
    public String greetingsFromController(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "greetings";
    }
}
