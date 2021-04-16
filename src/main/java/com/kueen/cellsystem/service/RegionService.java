package com.kueen.cellsystem.service;


import com.kueen.cellsystem.entity.RegionDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface RegionService {

    List<RegionDetail> getAll();

}
