package com.hashcodehub.springboot.studentservices.Controller;


import com.hashcodehub.springboot.studentservices.StudentServicesApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestartController {


    @PostMapping("/restart")
    public void restart() {
        StudentServicesApplication.restart();
    }

}
