package com.kueen.cellsystem.dao;

import com.kueen.cellsystem.entity.ModelDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModelMapper {
    List<ModelDetail> getAll();

}
