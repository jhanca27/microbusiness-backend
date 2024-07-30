package net.quintoimpacto.ubuntuapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.google.api.client.http.HttpMethods;

import net.quintoimpacto.ubuntuapi.security.jwt.JwtTokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
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
                http
                                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                                                .requestMatchers("/", "/login/oauth2/**", "/error", "/microbusiness/")
                                                .permitAll()
                                                .requestMatchers("/admin").hasAuthority("admin")
                                                .requestMatchers(HttpMethods.GET, "/countries", "/provinces").permitAll()
                                                .anyRequest().authenticated())
                                .oauth2Login(oauth2 -> oauth2
                                                .loginPage("/oauth2/authorization/google")
                                                .defaultSuccessUrl("/user", true)
                                                .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                                                                .oidcUserService(customOidcUserService))
                                                .successHandler(customAuthenticationSuccessHandler))
                                .logout(logout -> logout
                                                .logoutSuccessUrl("/").permitAll())
                                .addFilterBefore(jwtTokenAuthenticationFilter,
                                                UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }
}
