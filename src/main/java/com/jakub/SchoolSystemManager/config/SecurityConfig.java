package com.jakub.SchoolSystemManager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    private final PasswordEncoder encoder;
//
//    public SecurityConfig(PasswordEncoder encoder) {
//        this.encoder = encoder;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/", "/index", "/css/**", "/js/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(formLogin -> {
                    formLogin.loginPage("/login").permitAll();
                    formLogin.defaultSuccessUrl("/greeting");
                    formLogin.failureUrl("/index.html");
                    formLogin.usernameParameter("username");
                    formLogin.passwordParameter("password");
                })
                .logout(logout -> {
                    logout.logoutSuccessUrl("/index.html");
                    logout.invalidateHttpSession(true);
                    logout.deleteCookies("JSession");
                })
                .build();
    }

}
