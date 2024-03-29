package tgrzelak;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CosmicApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void getPass() {
        getPasswordHas();
    }


    @Bean
    public PasswordEncoder getPasswordHas() {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("admin"));
        return new BCryptPasswordEncoder();
    }

}
