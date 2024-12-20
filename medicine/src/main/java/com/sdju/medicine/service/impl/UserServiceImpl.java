package com.sdju.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdju.medicine.entity.User;
import com.sdju.medicine.mapper.UserMapper;
import com.sdju.medicine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//用户service实现类
@Service
public class UserServiceImpl extends ServiceImpl <UserMapper, User> implements IUserService {
@Autowired
    private  UserMapper userMapper;
    @Override
    public User queryUserByUsername(User user) {
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        return userMapper.selectOne(wrapper);
    }
}
