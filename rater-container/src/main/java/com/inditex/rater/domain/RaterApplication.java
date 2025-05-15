package com.inditex.rater.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.inditex.rater")
public class RaterApplication {
    public static void main(String[] args) {
      SpringApplication.run(RaterApplication.class, args);
    }
}
