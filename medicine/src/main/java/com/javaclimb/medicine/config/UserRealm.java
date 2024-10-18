package com.javaclimb.medicine.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.javaclimb.medicine.entity.User;
import com.javaclimb.medicine.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//权限认证
public class UserRealm extends AuthorizingRealm {
@Autowired
private IUserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
//登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User queryUser = new User();
        queryUser.setUsername(username);
        User user = userService.queryUserByUsername(queryUser);
        if (user == null) {
            return null;

        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }

}
