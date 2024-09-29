package com.hashcodehub.springboot.studentservices.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/esg")
public class EmployeeController {

    @GetMapping("/employee")
    public Employee getEmployee() {
        System.out.println("inside employee controller get employee");

        Employee employee1 = Employee.builder().id(12).build();
        return employee1;

    }

}
