package com.kueen.cellsystem.dao;




//import(一) 本项目的
import com.kueen.cellsystem.entity.DepartmentDetail;
//import(二) spring大家族的注解
import org.apache.ibatis.annotations.Mapper;
//import(三) java自带
import java.util.List;



@Mapper
public interface DepartmentMapper {

    List<DepartmentDetail> getAll();

}
