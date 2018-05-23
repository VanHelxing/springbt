//package com.hx.springbt;
//
//import com.hx.springbt.common.entity.user.User;
//import com.hx.springbt.common.service.user.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@EnableJpaAuditing
//public class UserTest {
//
//    @Autowired
//    private UserService userService;
//
//
//    @Test
//    public void userAdd(){
//
//        User user = new User();
//        user.setId("998844841239322624");
//        user.setUserId("162906");
//        user.setUserName("范海辛o");
//        user.setSexy("0");
//        user.setOrgId("00000");
//        user.setDepId("0001");
//        userService.save(user);
//
//        System.out.println("保存成功！");
//    }
//}
