package com.mrfang.yunhome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

/**
 * @ Author: Fang
 * @ Date: 2022/11/28 19:32
 * @ Project: RuoYi
 */
@Component
public class SecurityConfig {

    /**
     * 声明一个BCryptPasswordEncoder类型的密码加密器并注册到spring容器中
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/personal_center_", "/yunhome/home/signingPage*","/yunhome/comment/add*").authenticated()    //必须认证后才能访问
                .anyRequest().permitAll()  //所有的请求都是放行的
                .and()
                .formLogin()
                .loginPage("/login_")                //设置登录页面
                .loginProcessingUrl("/yunhome/tenant/login")       //设置登录请求，必须与登录表单的action一致
                .successForwardUrl("/yunhome/tenant/index")       //登录成功后跳转的路径
                .permitAll()
                .and().headers().frameOptions().disable()       //用来处理security对iframe页面的支持
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403_")         //配置403界面
                .and()
                .csrf().disable();                  //关闭csrf机制，使得logout可以使用get请求而不是post

        return http.build();
    }
}
