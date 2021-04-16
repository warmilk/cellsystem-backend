package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.dao.CategoryMapper;
import com.kueen.cellsystem.entity.CategoryDetail;
import com.kueen.cellsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<CategoryDetail> getAll() {
        return categoryMapper.getAll();
    }
}
