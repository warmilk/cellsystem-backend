package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.dao.UserMapper;
import com.kueen.cellsystem.entity.UserDetail;
import com.kueen.cellsystem.entity.UserRegisterParam;
import com.kueen.cellsystem.service.UserService;
import com.kueen.cellsystem.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    private JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

    @Override
    public UserDetail login(String username, String password) {
        UserDetail userDetail = userMapper.getUserByUsername(username);
        if (userDetail != null && userDetail.getPassword().equals(password)) {
            String token = jwtTokenUtil.generateToken(userDetail);
            userDetail.setToken(token);
        } else {
            return null;
        }
        userDetail.setPassword(null);
        return userDetail;
    }

    @Override
    public void register(UserRegisterParam userRegisterParam) {
        userMapper.insertUser(userRegisterParam);
    }

    @Override
    public boolean existUser(String username) {
        return userMapper.getUserByUsername(username) != null;
    }


}
