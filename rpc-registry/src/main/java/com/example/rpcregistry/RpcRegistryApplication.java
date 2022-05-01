package com.example.rpcregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author xxs
 */
@SpringBootApplication
@EnableConfigurationProperties
public class RpcRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcRegistryApplication.class, args);
    }

}
