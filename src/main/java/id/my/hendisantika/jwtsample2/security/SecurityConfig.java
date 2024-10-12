package id.my.hendisantika.jwtsample2.security;

import id.my.hendisantika.jwtsample2.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/10/24
 * Time: 13.38
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    public static final String ADMIN = "admin";
    public static final String USER = "user";

    private final CustomUserDetailsService userDetailsService;
    private final JwtAuthEntryPoint authEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz.requestMatchers("/api/**")
                .permitAll()
                .requestMatchers(HttpMethod.GET)
                .permitAll()
                .requestMatchers(HttpMethod.DELETE)
                .hasAuthority(ADMIN)
                .requestMatchers(HttpMethod.POST)
                .permitAll()
                .requestMatchers(HttpMethod.PUT)
                .hasAuthority(USER)
                .anyRequest()
                .authenticated());

        http.exceptionHandling((exceptions) -> exceptions.authenticationEntryPoint(authEntryPoint));
        http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(c -> c.disable());
        return http.build();
    }
}
