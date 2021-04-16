package com.kueen.cellsystem.service;

import com.kueen.cellsystem.entity.UserDetail;
import com.kueen.cellsystem.entity.UserRegisterParam;

public interface UserService {

    UserDetail login(String username, String password);
    void register(UserRegisterParam userRegisterParam);
    boolean existUser(String username);

}
