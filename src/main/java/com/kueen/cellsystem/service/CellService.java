package com.kueen.cellsystem.service;

import com.kueen.cellsystem.entity.CellDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface CellService {

    List<CellDetail> getAll();

    void modifyCell(String filename, String content);

}
