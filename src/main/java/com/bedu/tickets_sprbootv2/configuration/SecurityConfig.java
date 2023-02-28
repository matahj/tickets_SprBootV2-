package com.bedu.tickets_sprbootv2.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Value("${spring.security.debug:false}")
    boolean securityDebug;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf()
                .disable()
                /*.authorizeHttpRequests()
                .requestMatchers(HttpMethod.DELETE)
                .hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT)
                .hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST)
                .hasRole("ADMIN")
                .requestMatchers("/admins")
                .hasRole("ADMIN")
                .requestMatchers("/buses")
                .hasRole("ADMIN")
                .requestMatchers("/stations")
                .hasRole("ADMIN")
                .requestMatchers("/drivers")
                .hasRole("ADMIN")
                .requestMatchers("/users")
                .hasAnyRole("USER", "ADMIN")
                .requestMatchers("/tickets")
                .hasAnyRole("USER", "ADMIN")
                .requestMatchers("/trips")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()*/
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.debug(securityDebug)
                .ignoring()
                .requestMatchers("/css/**","/img/**");
    }
}
