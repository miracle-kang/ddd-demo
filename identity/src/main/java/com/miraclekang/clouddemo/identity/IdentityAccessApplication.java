package com.miraclekang.clouddemo.identity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IdentityAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentityAccessApplication.class, args);
    }
}
