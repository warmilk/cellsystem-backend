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

    public void modify(DescriptionDetail descriptionDetail) {
        descriptionMapper.modify(descriptionDetail);
    }
    public void add(DescriptionDetail descriptionDetail) {
        descriptionMapper.add(descriptionDetail);
    }
    public void delete(int id) {
        descriptionMapper.delete(id);
    }

}
