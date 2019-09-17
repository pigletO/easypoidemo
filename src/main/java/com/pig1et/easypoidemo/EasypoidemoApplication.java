package com.pig1et.easypoidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.pig1et.easypoidemo.controller")
@SpringBootApplication
public class EasypoidemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasypoidemoApplication.class, args);
    }

}
