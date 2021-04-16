package com.kueen.cellsystem.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class PatientDetail {

    public static final int SLICE_STATE_UNCHECK = 0;
    public static final int SLICE_STATE_CHECKING = 1;
    public static final int SLICE_STATE_CHECKED = 2;
    public static final int SLICE_STATE_FAILED = 3;

    private int id;
    private String name;
    private int gender;
    private Date birthday;
    private int bedId;
    private int departmentId;
    private String department;
    private int regionId;
    private String region;
    private int modelId;
    private int opinionId;
    private String opinion;
    private int descriptionId;
    private String description;
    private String patientId;
    private String sliceId;
    private int sliceNum;
    private int sliceState;
    private Timestamp createTime;
    private int createUid;
    private String createUser;
    private Timestamp checkTime;
    private int checkUid;
    private String checkUser;

}
