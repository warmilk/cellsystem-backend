package com.kueen.cellsystem.dao;

import com.kueen.cellsystem.entity.DescriptionDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DescriptionMapper {

    List<DescriptionDetail> getAll();
    void modify(DescriptionDetail descriptionDetail);
    void add(DescriptionDetail descriptionDetail);
    void delete(int id);


}
