package id.my.hendisantika.jwtsample2.security;

import id.my.hendisantika.jwtsample2.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/10/24
 * Time: 13.36
 * To change this template use File | Settings | File Templates.
 */

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtGenerator tokenGenerator;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

}
