package com.fire.ami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AmiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmiDemoApplication.class, args);
    }
}