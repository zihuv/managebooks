package com.zihuv.managebooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ManagebooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagebooksApplication.class, args);
    }

}
