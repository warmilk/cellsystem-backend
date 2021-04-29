package com.kueen.cellsystem.service.Impl;


import com.kueen.cellsystem.dao.DepartmentMapper;
import com.kueen.cellsystem.entity.DepartmentDetail;
import com.kueen.cellsystem.service.DepartmentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // stereo（刻板的）stereo-type就是【模板】

import java.util.List;

@Service //@Service注解用于类上，标记当前类是一个service类，spring妈妈（spring框架就是java项目的妈妈）看到该注解后，会将当前类自动注入到spring容器中，我们就不需要再在applicationContext.xml文件定义bean了。
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<DepartmentDetail> getAll() {
        return departmentMapper.getAll();
    }
}
