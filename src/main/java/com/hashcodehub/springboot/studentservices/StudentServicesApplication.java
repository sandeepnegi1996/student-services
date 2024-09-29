package com.hashcodehub.springboot.studentservices;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentServicesApplication {

    private static ConfigurableApplicationContext context;
    private static String[] orginalArg;

    public static void main(String[] args) {


        context = SpringApplication.run(StudentServicesApplication.class, args);
        orginalArg = args;

    }

    public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);

        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(StudentServicesApplication.class, args.getSourceArgs());
        });

        thread.setDaemon(false);
        thread.start();
    }

}
