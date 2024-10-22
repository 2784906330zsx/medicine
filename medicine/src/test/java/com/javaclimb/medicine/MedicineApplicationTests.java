package com.sdju.medicine;

import com.sdju.medicine.entity.User;
import com.sdju.medicine.service.impl.UserServiceImpl;
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
