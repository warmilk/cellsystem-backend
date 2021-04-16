package com.kueen.cellsystem.dao;

import com.kueen.cellsystem.entity.CellDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CellMapper {

    List<CellDetail> getAll();
}
