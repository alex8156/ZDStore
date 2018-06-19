package com.soling.store.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FormAction{

    // 这样的方法里，一般是用来注册一些PropertyEditor
    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy---MM---dd HH:mm:ss");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }


    @RequestMapping(value="/test/json",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getFormData(Date date){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","lg");
        map.put("age",23);
        map.put("date",new Date());
        return map;
    }
}
