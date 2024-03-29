package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.dao.PatientMapper;
import com.kueen.cellsystem.entity.ModelCheckParam;
import com.kueen.cellsystem.entity.PatientDetail;
import com.kueen.cellsystem.entity.PatientPage;
import com.kueen.cellsystem.entity.PatientTableParam;
import com.kueen.cellsystem.service.PatientService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public PatientPage getPatient(PatientTableParam patientTableParam) {
        String keyword = patientTableParam.getKeyword();
        PatientPage patientPage = new PatientPage();
        int size = patientTableParam.getPageSize();
        int from = patientTableParam.getCurrPage() * size - size;
        int total = 0;
        List<PatientDetail> patients = null;
        if (keyword != null && !keyword.equals("")) {
            patients = patientMapper.searchPatient(
                    from, size, patientTableParam.getColumn(),
                    patientTableParam.getOrder(),
                    patientTableParam.getKeyword()
            );
            total = patientMapper.searchPatientNum(patientTableParam.getKeyword());
        } else {
            patients = patientMapper.getBatchPatient(
                    from, size, patientTableParam.getColumn(),
                    patientTableParam.getOrder(),
                    patientTableParam.getStartDate(),
                    patientTableParam.getEndDate()
            );
            total = patientMapper.getPatientNum();
        }
        patientPage.setPatients(patients);
        patientPage.setTotal(total);
        return patientPage;
    }

    @Override
    public void modifyPatient(PatientDetail patientDetail) {
        patientMapper.modifyPatient(patientDetail);
    }

    @Override
    public void insertPatient(PatientDetail patientDetail) {
        patientMapper.insertPatient(patientDetail);
    }

    @Override
    public void setSliceHandling(ModelCheckParam modelCheckParam) {
        patientMapper.updateSliceStateBySliceId(
                modelCheckParam.getSliceId(),
                modelCheckParam.getModelId(),
                modelCheckParam.getCheckUid(),
                PatientDetail.SLICE_STATE_CHECKING
        );
    }

    @Override
    public void setSliceFinish(ModelCheckParam modelCheckParam) {
        patientMapper.updateSliceStateBySliceId(
                modelCheckParam.getSliceId(),
                modelCheckParam.getModelId(),
                modelCheckParam.getCheckUid(),
                PatientDetail.SLICE_STATE_CHECKED
        );
    }

    @Override
    public void setSliceFailed(ModelCheckParam modelCheckParam) {
        patientMapper.updateSliceStateBySliceId(
                modelCheckParam.getSliceId(),
                modelCheckParam.getModelId(),
                modelCheckParam.getCheckUid(),
                PatientDetail.SLICE_STATE_FAILED
        );
    }

    @Override
    public PatientDetail getPatientById(int id) {
        return patientMapper.getPatientById(id);
    }

    @Override
    public PatientDetail getReadablePatientById(int id) {
        return patientMapper.getReadablePatientById(id);
    }


}
