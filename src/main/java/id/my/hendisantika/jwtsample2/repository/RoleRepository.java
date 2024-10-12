package id.my.hendisantika.jwtsample2.repository;

import id.my.hendisantika.jwtsample2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/10/24
 * Time: 10.48
 * To change this template use File | Settings | File Templates.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
