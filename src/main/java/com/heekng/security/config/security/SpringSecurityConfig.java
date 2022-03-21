package com.heekng.security.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/").permitAll() //모든 경로 접근 가능
                    .antMatchers("/admin").hasAuthority("ROLE_ADMIN") // /admin: ROLE_ADMIN 권한 가진 사용자만 사용 가능
                    .anyRequest().authenticated() // 모든 URL 인증 필수
                .and()
                    .formLogin() //폼방식 로그인
                    .defaultSuccessUrl("/hello", true)
                    .loginProcessingUrl("/loginProcess")
                    .usernameParameter("id")
                    .passwordParameter("password")
                    .permitAll()
                .and()
                    .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logoutProcess")); //default: /logout
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 시큐리티 미적용 경로 설정
        web.ignoring().antMatchers("/static/css/**", "/static/js/**", "/static/img/**");
    }
}
