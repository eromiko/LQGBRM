package com.lq.gbrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.lq.gbrm.mapper","com.lq.gbrm.util"})
public class LqgbrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(LqgbrmApplication.class, args);

    }

}
