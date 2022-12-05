package com.mrfang.yunhome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@MapperScan("com.mrfang.yunhome.mapper")
@SpringBootApplication
public class RuoyiYunhomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuoyiYunhomeApplication.class, args);
    }




}
