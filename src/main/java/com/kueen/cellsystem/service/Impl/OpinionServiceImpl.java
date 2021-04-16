package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.dao.OpinionMapper;
import com.kueen.cellsystem.entity.OpinionDetail;
import com.kueen.cellsystem.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionServiceImpl implements OpinionService {
    @Autowired
    private OpinionMapper opinionMapper;


    @Override
    public List<OpinionDetail> getAll() {
        return opinionMapper.getAll();
    }
}
