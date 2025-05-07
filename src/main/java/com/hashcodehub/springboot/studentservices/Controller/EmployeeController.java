package com.hashcodehub.springboot.studentservices.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/esg")
public class EmployeeController {

    @GetMapping("/employee")
    public Employee getEmployee() {
        System.out.println("inside employee controller get employee");
        log.info("inside hte employee controller get employee");

        log.info("employee controller returns a simple employee");
        Employee employee1 = Employee.builder().id(1).build();
        return employee1;
    }

    @GetMapping("/employeList")
    public List<Employee> getEmployeeList() {

        log.info("fetching the employee list ");
        Employee e1 = Employee.builder().id(2).build();
        Employee e2 = Employee.builder().id(3).build();

      List<Employee>  employeeList = Arrays.asList(e1,e2);
      return  employeeList;
    }

}
