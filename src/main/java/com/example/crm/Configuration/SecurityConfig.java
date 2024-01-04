package com.example.crm.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.example.crm.Service.EmployeeDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/index").permitAll()
                        .requestMatchers("/interaction/**").hasRole("EMPLOYEE")
                        .requestMatchers("/customer/**").hasRole("EMPLOYEE")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/index")
                        .permitAll()
                )
                .logout(logout -> logout
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index")
                        .invalidateHttpSession(true)
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsService() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

//    @Bean
//    public UserDetailsService inMemoryUserDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(EmployeeDetailsService employeeDetailsService) {
//        return employeeDetailsService;
//    }
}