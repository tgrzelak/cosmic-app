package tgrzelak;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPass {
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
