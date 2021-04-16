package com.kueen.cellsystem.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRegisterParam {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;

    private Integer gender;
}
