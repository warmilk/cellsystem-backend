package com.kueen.cellsystem.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CellDetail {
    private int id;
    private String label;
    private String name;
    private String color;
    private float thresholdUp;
    private float thresholdDown;
    private int category;
}
