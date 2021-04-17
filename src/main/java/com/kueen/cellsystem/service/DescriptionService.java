package com.kueen.cellsystem.service;

import com.kueen.cellsystem.entity.DescriptionDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DescriptionService {

    List<DescriptionDetail> getAll();

    void modify(DescriptionDetail descriptionDetail);
    void add(DescriptionDetail descriptionDetail);
    void delete(int id);

}
