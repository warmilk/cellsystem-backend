package com.kueen.cellsystem.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientPage {

    private int total;
    private List<PatientDetail> patients;
}
