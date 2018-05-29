package com.soling.store.controller;

import com.soling.store.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployRestController {

    @RequestMapping
    @ResponseBody
    public List<Employee> employeeList() {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(1L, "emp1"));
        emps.add(new Employee(2L, "emp2"));
        return emps;
    }

}
