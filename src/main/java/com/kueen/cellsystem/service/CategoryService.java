package com.kueen.cellsystem.service;


import com.kueen.cellsystem.entity.CategoryDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface CategoryService {

    List<CategoryDetail> getAll();

}
