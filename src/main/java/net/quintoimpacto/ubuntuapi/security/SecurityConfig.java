package net.quintoimpacto.ubuntuapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.google.api.client.http.HttpMethods;

import net.quintoimpacto.ubuntuapi.security.jwt.JwtTokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        private final JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;
        private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
        private final CustomOidcUserService customOidcUserService;

        @Autowired
        public SecurityConfig(JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter,
                        CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler,
                        CustomOidcUserService customOidcUserService) {
                this.jwtTokenAuthenticationFilter = jwtTokenAuthenticationFilter;
                this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
                this.customOidcUserService = customOidcUserService;
        }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http    .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/login/oauth2/**", "/error", "/contact/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/countries", "/provinces", "/images", "images/{id}", "/microbusiness/findAll").permitAll()
                                .requestMatchers("/user").hasRole("USER")
                                .requestMatchers("/microbusiness/**").hasRole("ADMIN")
                                .requestMatchers("/admin").hasRole("ADMIN") // Ajuste aquí
                                .anyRequest().authenticated()
                                //.requestMatchers("/images","/**").hasRole("ADMIN")        
                               
                                
                )
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/oauth2/authorization/google")
                        .defaultSuccessUrl("/user", true)
                        .successHandler(customAuthenticationSuccessHandler)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/").permitAll()
                )
                .addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}