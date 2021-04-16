package com.kueen.cellsystem.dao;

import com.kueen.cellsystem.entity.PatientDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.sql.Timestamp;


@Mapper
public interface PatientMapper {

    Integer getPatientNum();
    List<PatientDetail> getBatchPatient(@Param("from") int from, @Param("size") int size, @Param("column") String column, @Param("order") String order, @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

    Integer searchPatientNum(String keyword);
    List<PatientDetail> searchPatient(@Param("from") int from, @Param("size") int size, @Param("column") String column, @Param("order") String order, @Param("keyword") String keyword);

    void modifyPatient(PatientDetail patientDetail);
    void insertPatient(PatientDetail patientDetail);

//    void updateSliceStateBySliceId(String sliceId, int sliceNum);

    void updateSliceStateBySliceId(@Param("sliceId") String sliceId,
                                   @Param("modelId") int modelId,
                                   @Param("checkUid") int checkUid,
                                   @Param("sliceState") int sliceState);

    PatientDetail getPatientById(int id);
    PatientDetail getReadablePatientById(int id);
}
