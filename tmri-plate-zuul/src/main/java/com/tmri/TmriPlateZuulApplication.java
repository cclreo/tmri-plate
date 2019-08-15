package com.tmri;

import com.tmri.filters.TestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class TmriPlateZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmriPlateZuulApplication.class, args);
    }

    @Bean
    public TestFilter testFilter(){
        return new TestFilter();
    }

}
