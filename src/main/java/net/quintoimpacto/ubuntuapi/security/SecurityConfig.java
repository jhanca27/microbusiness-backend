package net.quintoimpacto.ubuntuapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
        http    .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/login/oauth2/**", "/error").permitAll()
                                .requestMatchers(HttpMethod.GET, "/countries", "/provinces", "/images", "images/{id}", "/microbusiness/").permitAll()
                                .requestMatchers("/admin", "/**" ).hasAuthority("admin") // Ajuste aquí
                                .requestMatchers(HttpMethod.POST, "/images/uploadBase64").hasAuthority("admin")
                                .requestMatchers(HttpMethod.PUT, "/images/updateBase64").hasAuthority("admin")
                                .requestMatchers(HttpMethod.DELETE, "/images/{id}").hasAuthority("admin")
                                .anyRequest().authenticated()
                )
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/oauth2/authorization/google")
                        .defaultSuccessUrl("/user", true)
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.oidcUserService(customOidcUserService))
                        .successHandler(customAuthenticationSuccessHandler)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/").permitAll()
                )
                .addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}