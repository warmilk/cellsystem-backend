package com.kueen.cellsystem.dao;


import com.kueen.cellsystem.entity.CategoryDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<CategoryDetail> getAll();

}
