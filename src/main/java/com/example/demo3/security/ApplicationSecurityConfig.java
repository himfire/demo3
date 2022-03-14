package com.example.demo3.security;

import com.example.demo3.persistances.model.role.Role;
import com.example.demo3.persistances.model.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Set;


@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("index","/css/*","/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails annaSmithUser = (UserDetails) User.builder()
                .username("anna")
                .password("password")
                .roles((Set<Role>) new Role(1L,"STUDENT","std"))
                .build();
        return new InMemoryUserDetailsManager(annaSmithUser);
    }
}