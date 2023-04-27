package com.spring.WebServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EntityScan(basePackages = "com/spring/WebServices/entities")
public class WebServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebServicesApplication.class, args);

    }
}
