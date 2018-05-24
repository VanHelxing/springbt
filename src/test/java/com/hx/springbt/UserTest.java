package com.hx.springbt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableJpaAuditing
public class UserTest {


    @Test
    public void test(){

        String password = "123123";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

        String after = encoder.encode(password);
        System.out.println("加密后的密码为: " + after);

    }
}
