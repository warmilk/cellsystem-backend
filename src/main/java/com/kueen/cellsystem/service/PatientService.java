package com.kueen.cellsystem.service;

import com.kueen.cellsystem.entity.ModelCheckParam;
import com.kueen.cellsystem.entity.PatientDetail;
import com.kueen.cellsystem.entity.PatientPage;
import com.kueen.cellsystem.entity.PatientTableParam;

public interface PatientService {

    PatientPage getPatient(PatientTableParam patientTableRaram);
    void modifyPatient(PatientDetail patientDetail);
    void insertPatient(PatientDetail patientDetail);

    void setSliceHandling(ModelCheckParam modelCheckParam);
    void setSliceFinish(ModelCheckParam modelCheckParam);
    void setSliceFailed(ModelCheckParam modelCheckParam);
    PatientDetail getPatientById(int id);
    PatientDetail getReadablePatientById(int id);

}
