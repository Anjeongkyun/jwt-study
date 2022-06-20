package com.jeongkyun.study.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//web 보안 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //h2-console 하위 모든 요청과 파비콘은 모두 무시하도록 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
             web.ignoring()
                .antMatchers("/h2-console/**"
                ,"/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/api/hello").permitAll() //api/hello는 허용
                .anyRequest().authenticated(); //나머지는 인증을 받아야한다.
    }
}
