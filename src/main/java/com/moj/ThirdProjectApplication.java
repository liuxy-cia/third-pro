package com.moj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.moj.mapper")
public class ThirdProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdProjectApplication.class, args);
    }

}
