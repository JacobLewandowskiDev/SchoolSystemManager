package com.jakub.SchoolSystemManager.config;

import com.jakub.SchoolSystemManager.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final PasswordEncoder encoder;

    public SecurityConfig(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/", "/index", "/css/**", "/js/**").permitAll();
                    auth.requestMatchers("/student-interface.html").hasRole(Role.ROLE_STUDENT);
                    auth.requestMatchers("/teacher-interface.html").hasRole(Role.ROLE_TEACHER);
                    auth.requestMatchers("/admin-interface.html").hasAnyRole(Role.ROLE_ADMIN, Role.ROLE_MAIN_ADMIN);
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
                    logout.logoutUrl("/logout");
                    logout.clearAuthentication(true);
                    logout.invalidateHttpSession(true);
                    logout.deleteCookies("JSession");
                    logout.logoutSuccessUrl("/index.html");
                })
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails student = User.builder()
                .username("student")
                .password(encoder.encode("pass"))
                .roles(Role.ROLE_STUDENT)
                .build();

        UserDetails teacher = User.builder()
                .username("teacher")
                .password(encoder.encode("pass"))
                .roles(Role.ROLE_TEACHER)
                .build();

        return new InMemoryUserDetailsManager(
                student,
                teacher
        );
    }

}
