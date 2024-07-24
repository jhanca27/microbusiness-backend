package net.quintoimpacto.ubuntuapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import net.quintoimpacto.ubuntuapi.security.jwt.JwtTokenAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    public SecurityConfig(JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter,
                          CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.jwtTokenAuthenticationFilter = jwtTokenAuthenticationFilter;
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/login/oauth2/**", "/error").permitAll() 
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                .loginPage("/oauth2/authorization/google")
                         .defaultSuccessUrl("/user", true) 
                        // .failureUrl("/login?error=true")  agregue esta ruta de error
                        .successHandler(customAuthenticationSuccessHandler) //si comentas este te redirije a user para que lo pruebes en el back
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/").permitAll()
                )
                .addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); 
        return http.build();
    }
}
