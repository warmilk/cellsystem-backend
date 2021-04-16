package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.dao.RegionMapper;
import com.kueen.cellsystem.entity.RegionDetail;
import com.kueen.cellsystem.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.Region;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionMapper regionMapper;


    @Override
    public List<RegionDetail> getAll() {
        return regionMapper.getAll();
    }
}
