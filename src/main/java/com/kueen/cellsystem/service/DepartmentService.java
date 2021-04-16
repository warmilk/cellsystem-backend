package com.kueen.cellsystem.service;

import com.kueen.cellsystem.entity.DepartmentDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDetail> getAll();

}
