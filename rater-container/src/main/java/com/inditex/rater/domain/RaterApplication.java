package com.inditex.rater.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.inditex.rater.dataaccess" })
@EntityScan(basePackages = { "com.inditex.rater.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.inditex.rater")
public class RaterApplication {
    public static void main(String[] args) {
      SpringApplication.run(RaterApplication.class, args);
    }
}
