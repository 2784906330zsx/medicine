package com.javaclimb.medicine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.medicine.entity.User;
//用户表的service接口
public interface IUserService extends IService<User> {
//根据用户名查询用户对象
public User queryUserByUsername(User user);

}
