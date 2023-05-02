package com.example.histo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HistoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HistoApplication.class, args);
    }

}
