package com.javaclimb.medicine;

import com.javaclimb.medicine.entity.User;
import com.javaclimb.medicine.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MedicineApplicationTests {
@Autowired
private UserServiceImpl userService;
    @Test
    void contextLoads() {
    User user=new User();
    user.setUsername("admin");
    User user1 = userService.queryUserByUsername(user);
    if(user1!=null){
        System.out.print(user1.getPassword());
    }
    }

}
