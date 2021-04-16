package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.entity.UserDetail;
import com.kueen.cellsystem.entity.UserLoginParam;
import com.kueen.cellsystem.entity.UserRegisterParam;
import com.kueen.cellsystem.service.UserService;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@Validated @RequestBody UserLoginParam userLoginParam) {
        UserDetail userDetail = userService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        if (userDetail == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        if (userDetail.getGroupId() == UserDetail.USER_GROUP_ID_VALIDING) {
            return CommonResult.validateFailed("用户未进行审核");
        } else if (userDetail.getGroupId() == UserDetail.USER_GROUP_ID_INVALID) {
            return CommonResult.validateFailed("用户未通过审核");
        }
        return CommonResult.success(userDetail, "登陆成功");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@Validated @RequestBody UserRegisterParam userRegisterParam) {
        if (userService.existUser(userRegisterParam.getUsername())) {
            return CommonResult.failed("用户己存在");
        }
        userService.register(userRegisterParam);
        return CommonResult.success(null, "注册成功");
    }
}
