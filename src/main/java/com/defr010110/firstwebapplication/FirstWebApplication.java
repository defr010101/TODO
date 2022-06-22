package com.defr010110.firstwebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class FirstWebApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FirstWebApplication.class, args);
    }

}
