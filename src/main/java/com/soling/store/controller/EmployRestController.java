package com.soling.store.controller;

import com.soling.store.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployRestController {

    @GetMapping
    public List<Employee> employeeList() {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(1L, "emp1",5L));
        emps.add(new Employee(2L, "emp2",6l));
        return emps;
    }

    @GetMapping(value = "depts/{deptId}/emps/{empId}",consumes = "application/json",produces = "application/json")
    public Employee getEmp(@PathVariable Long empId,@PathVariable Long deptId) {
        return new Employee(empId,"json格式",deptId);
    }


    @GetMapping(value = "depts/{deptId}/emps/{empId}",headers = "Content-Type=text/xml")
    public Employee getEmpxml(@PathVariable Long empId,@PathVariable Long deptId) {
        return new Employee(empId,"xml格式",deptId);
    }

}
