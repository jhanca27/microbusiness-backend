package net.quintoimpacto.ubuntuapi.security;

import net.quintoimpacto.ubuntuapi.security.jwt.JwtTokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;

    @Autowired
    public SecurityConfig(JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter) {
        this.jwtTokenAuthenticationFilter = jwtTokenAuthenticationFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/user").permitAll()
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login/oauth2/**")
                        .defaultSuccessUrl("/user", true)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/").permitAll()
                );
        return http.build();
    }

}