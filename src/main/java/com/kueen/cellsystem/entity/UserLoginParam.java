package com.kueen.cellsystem.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserLoginParam {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
