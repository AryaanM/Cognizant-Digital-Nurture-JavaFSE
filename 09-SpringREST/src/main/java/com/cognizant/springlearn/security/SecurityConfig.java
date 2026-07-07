package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Creating two hardcoded users for testing: "admin" and "user"
        auth.inMemoryAuthentication()
            .withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
            .and()
            .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("START: Initializing BCryptPasswordEncoder");
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // Disabling CSRF for REST APIs, enabling Basic Auth, and restricting /countries
        httpSecurity.csrf().disable().httpBasic().and()
            .authorizeRequests()
            .antMatchers("/authenticate").permitAll() // Whitelist the login endpoint
            .antMatchers("/countries").hasRole("USER"); // Protect the API
    }
}