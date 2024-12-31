package com.pos.system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PosApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(PosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
