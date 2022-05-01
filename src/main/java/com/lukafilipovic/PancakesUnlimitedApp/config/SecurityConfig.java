package com.lukafilipovic.PancakesUnlimitedApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/ingredients/**").hasRole("employee")
                .antMatchers("/api/orders/**").hasRole("customer")
                .antMatchers("/api/pancakes/**").hasRole("customer")
                .antMatchers("/api/reports/**").hasRole("store owner")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails userCustomer =User.builder().username("customer").password(passwordEncoder().encode("croz")).roles("customer").build();
        UserDetails userEmployee =User.builder().username("employee").password(passwordEncoder().encode("palacinke")).roles("employee").build();
        UserDetails userStoreOwner =User.builder().username("owner").password(passwordEncoder().encode("store")).roles("store owner").build();

        return new InMemoryUserDetailsManager(userCustomer,userEmployee,userStoreOwner);

    }
}
