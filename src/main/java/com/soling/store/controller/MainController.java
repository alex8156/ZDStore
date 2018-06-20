package com.soling.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @RequestMapping()
    public String hellWorld(ModelAndView modelAndView) {
//        modelAndView.setViewName("home");
        return "home";
    }


}
