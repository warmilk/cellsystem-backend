package com.kueen.cellsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
@AllArgsConstructor
public class PatientTableParam {

    private Integer currPage;
    private Integer pageSize;
    private String column;
    private String order;
    private String keyword;
    private Timestamp startDate;
    private Timestamp endDate;

}
