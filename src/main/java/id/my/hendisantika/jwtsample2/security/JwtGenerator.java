package id.my.hendisantika.jwtsample2.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/10/24
 * Time: 13.33
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JwtGenerator {

    public long JWT_EXPIRATION = 70000;
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
}
