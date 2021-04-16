package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.dao.DescriptionMapper;
import com.kueen.cellsystem.entity.DescriptionDetail;
import com.kueen.cellsystem.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionServiceImpl implements DescriptionService {
    @Autowired
    private DescriptionMapper descriptionMapper;


    @Override
    public List<DescriptionDetail> getAll() {
        return descriptionMapper.getAll();
    }
}
