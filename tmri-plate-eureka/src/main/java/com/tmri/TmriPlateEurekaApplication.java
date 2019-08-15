package com.tmri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TmriPlateEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmriPlateEurekaApplication.class, args);
    }

}
