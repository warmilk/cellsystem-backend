package com.kueen.cellsystem.service;

import com.kueen.cellsystem.entity.ModelCheckParam;
import com.kueen.cellsystem.entity.ModelDetail;
import com.kueen.cellsystem.util.api.CommonResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface ModelService {
    List<ModelDetail> getAll();
    CommonResult check(ModelCheckParam modelCheckParam);

}
