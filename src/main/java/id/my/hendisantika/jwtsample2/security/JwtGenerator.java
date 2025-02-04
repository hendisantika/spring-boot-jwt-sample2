package id.my.hendisantika.jwtsample2.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        // 15 minutes in milliseconds (15 * 60 * 1000)
        long fifteenMinutesInMillis = 15 * 60 * 1000;
        Date expireDate = new Date(currentDate.getTime() + fifteenMinutesInMillis);

        // Extract roles from the authentication object
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        // Build the token with roles included in claims
        // Inclusion of roles in claims
        return Jwts
                .builder()
                .setSubject(username)
                .claim("roles", roles) // Inclusion of roles in claims
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secretKey).compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims =
                Jwts.parser()
                        .setSigningKey(secretKey).build()
                        .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was exprired or incorrect",
                    ex.fillInStackTrace());
        }
    }

    public List<String> getRolesFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
        return claims.get("roles", List.class);
    }
}
