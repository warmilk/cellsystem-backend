package com.kueen.cellsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class PatientTableRaram {

    private Integer currPage;
    private Integer pageSize;
    private String column;
    private String order;
    private String keyword;
    private Timestamp startDate;
    private Timestamp endDate;

}
