package id.my.hendisantika.jwtsample2.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/10/24
 * Time: 10.49
 * To change this template use File | Settings | File Templates.
 */
@Data
public class RegisterDto {
    private String username;
    private String password;
    private String role;
}
