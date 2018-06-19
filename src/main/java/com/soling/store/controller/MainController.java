package com.soling.store.controller;

import com.soling.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/helloWorld")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getMessage() {
        return "hello world main controlrler";
    }

    @RequestMapping(value = "/test")
    public ModelAndView hellWorld(ModelAndView modelAndView) {
        modelAndView.addObject("message","Hello World!Model&View");
        modelAndView.setViewName("helloWorld");
        return modelAndView;
    }

    //注入userService
//    @Resource(name="userService")
    @Autowired
    UserService userService;

}
