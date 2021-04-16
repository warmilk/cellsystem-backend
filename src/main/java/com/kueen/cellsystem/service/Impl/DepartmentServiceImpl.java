package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.dao.CellMapper;
import com.kueen.cellsystem.dao.DepartmentMapper;
import com.kueen.cellsystem.entity.CellDetail;
import com.kueen.cellsystem.entity.DepartmentDetail;
import com.kueen.cellsystem.service.CellService;
import com.kueen.cellsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<DepartmentDetail> getAll() {
        return departmentMapper.getAll();
    }
}
