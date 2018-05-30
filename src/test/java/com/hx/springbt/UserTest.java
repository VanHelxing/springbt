package com.hx.springbt;

import com.hx.springbt.security.dao.SysResourceDao;
import com.hx.springbt.security.dao.SysRoleDao;
import com.hx.springbt.security.dao.SysUserDao;
import com.hx.springbt.security.entity.SysResource;
import com.hx.springbt.security.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysRoleDao sysRoleDao;
    @Resource
    private SysResourceDao sysResourceDao;

    @Test
    @Transactional
    public void find(){
        List<SysUser> users = sysUserDao.findAll();
        System.out.println(users.toString());

        List<SysResource> resources = sysResourceDao.findAll();
        System.out.println(resources.toString());

    }


    @Test
    public void test(){

        String password = "123123"; //$2a$04$rQMMpQyu2U1OVWMQGtvZauP.bijkH1E93ndxbjKhpWJnzuXlVNC6y
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

        String after = encoder.encode(password);
        System.out.println("加密后的密码为: " + after);

    }
}
