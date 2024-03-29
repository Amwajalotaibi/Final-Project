package com.example.occasion.Config;

import com.example.occasion.Service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringConfiguration {

 private final MyUserDetailsService myUserDetailsService;
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(authenticationProvider())
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/register").permitAll()
                .requestMatchers("/api/v1/auth/company").hasAuthority("COMPANY")
                .requestMatchers("/api/v1/auth/customer").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/auth/login").hasAuthority("COMPANY")
                .requestMatchers("/api/v1/auth/login").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/auth/register").permitAll()
//                .requestMatchers("/api/v1/company/**").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/customer/**").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/login").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/login").hasAuthority("COMPANY")
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/auth/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
        return http.build();
    }

}
