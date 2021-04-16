package com.kueen.cellsystem.dao;

import com.kueen.cellsystem.entity.UserDetail;
import com.kueen.cellsystem.entity.UserRegisterParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserDetail getUserByUsername(String username);
    void insertUser(UserRegisterParam userRegisterParam);

}
