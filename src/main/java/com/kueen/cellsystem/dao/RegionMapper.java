package com.kueen.cellsystem.dao;


import com.kueen.cellsystem.entity.RegionDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionMapper {

    List<RegionDetail> getAll();

}
