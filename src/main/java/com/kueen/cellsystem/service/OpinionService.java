package com.kueen.cellsystem.service;

import com.kueen.cellsystem.entity.OpinionDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface OpinionService {

    List<OpinionDetail> getAll();

}
