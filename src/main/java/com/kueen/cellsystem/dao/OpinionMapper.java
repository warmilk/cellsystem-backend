package com.kueen.cellsystem.dao;

import com.kueen.cellsystem.entity.OpinionDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OpinionMapper {

    List<OpinionDetail> getAll();
    void modify(OpinionDetail opinionDetail);
    void add(OpinionDetail opinionDetail);
    void delete(int id);

}
