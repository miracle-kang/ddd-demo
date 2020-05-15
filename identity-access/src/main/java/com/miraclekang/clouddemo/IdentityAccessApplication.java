package com.miraclekang.clouddemo;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Specified here
 *
 * @author kangliqi
 * @date 2020/5/15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class IdentityAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentityAccessApplication.class, args);
    }
}
