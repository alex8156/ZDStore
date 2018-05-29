package com.soling.store.controller;

import com.soling.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getMessage() {
        return "hello world main controlrler";
    }


    //注入userService
//    @Resource(name="userService")
    @Autowired
    UserService userService;

}
