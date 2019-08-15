package com.tmri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableConfigServer
public class TmriPlateConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmriPlateConfigApplication.class, args);
    }

}
