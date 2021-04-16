package com.kueen.cellsystem.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetail {

    public static final int USER_GROUP_ID_VALIDING = 0;
    public static final int USER_GROUP_ID_INVALID = 1;
    public static final int USER_GROUP_ID_DOCTOR = 2;
    public static final int USER_GROUP_ID_ADMIN = 3;

    private int id;
    private String username;
    private String password;
    private String name;
    private int gender;
    private int groupId;
    private String token;

}
