package com.kueen.cellsystem.service;
import com.kueen.cellsystem.entity.ModelCheckParam;
import com.kueen.cellsystem.entity.ModelCheckQueryParam;
import com.kueen.cellsystem.entity.ModelDetail;
import com.kueen.cellsystem.util.api.CommonResult;

import java.util.Map;

public interface CellprofilerService {
    CommonResult check(ModelCheckParam modelCheckParam,Map<String, Map<String,Object>> requestBodyData);
    ModelCheckQueryParam packageObjectParam(Map<String, Map<String,Object>> requestBodyData);
}
