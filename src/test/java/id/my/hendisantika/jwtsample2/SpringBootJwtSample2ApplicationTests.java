package id.my.hendisantika.jwtsample2;

import id.my.hendisantika.jwtsample2.repository.AppUserRepository;
import id.my.hendisantika.jwtsample2.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Testcontainers
@SpringBootTest(
        properties = {
                "management.endpoint.health.show-details=always",
                "spring.datasource.url=jdbc:tc:postgresql:17.0-alpine3.20:///bankDB"
        },
        webEnvironment = RANDOM_PORT
)
class SpringBootJwtSample2ApplicationTests {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    void deleteAll() {
        appUserRepository.deleteAll();
        roleRepository.deleteAll();
    }

}
