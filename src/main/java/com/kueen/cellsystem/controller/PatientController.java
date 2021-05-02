package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.entity.ModelCheckParam;
import com.kueen.cellsystem.entity.PatientDetail;
import com.kueen.cellsystem.entity.PatientPage;
import com.kueen.cellsystem.entity.PatientTableParam;
import com.kueen.cellsystem.service.ModelService;
import com.kueen.cellsystem.service.PatientService;
import com.kueen.cellsystem.service.UploadService;
import com.kueen.cellsystem.util.ModelSocket;
import com.kueen.cellsystem.util.api.CommandParam;
import com.kueen.cellsystem.util.api.CommonResult;
import com.kueen.cellsystem.util.api.ResultCode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private ModelService modelService;
    @Value("${model.port}")
    private int modelPort;

    @RequestMapping(value = "/batch", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getBatch(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("column") String column,
            @RequestParam("order") String order,
            @RequestParam("keyword") String keyword,
            @RequestParam("startDate") Timestamp startDate,
            @RequestParam("endDate") Timestamp endDate
    ) {
        PatientTableParam patientTableParam = new PatientTableParam(currPage, pageSize, column, order, keyword, startDate, endDate);
        PatientPage patientPage = patientService.getPatient(patientTableParam);
        return CommonResult.success(patientPage);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult modify(@RequestBody PatientDetail patientDetail) {
        patientService.modifyPatient(patientDetail);
        return CommonResult.success(null);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(PatientDetail patientDetail, @RequestParam("slices") MultipartFile[] slices) {
        String sliceId = null;
        try {
            sliceId = uploadService.uploadSlices(slices);
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.failed("上传失败");
        }
        patientDetail.setSliceId(sliceId);
        patientDetail.setSliceNum(slices.length);
        patientDetail.setPatientId("" + System.currentTimeMillis());
        patientService.insertPatient(patientDetail);
        return CommonResult.success(null);
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult check(@RequestBody ModelCheckParam modelCheckParam) {
        modelCheckParam.setModelId(1);
        patientService.setSliceHandling(modelCheckParam);
        CommonResult commonResult = modelService.check(modelCheckParam);
        if (commonResult.getCode() == ResultCode.SUCCESS.getCode()) {
            patientService.setSliceFinish(modelCheckParam);
        } else {
            patientService.setSliceFailed(modelCheckParam);
        }
        return commonResult;
    }


    @RequestMapping(value = "/one", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getOne(@RequestParam("id") int id) {
        PatientDetail patientDetail = patientService.getPatientById(id);
        return CommonResult.success(patientDetail);
    }



    @RequestMapping(value = "/readable/one", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getReadableOne(@RequestParam("id") int id) {
        PatientDetail patientDetail = patientService.getReadablePatientById(id);
        return CommonResult.success(patientDetail);
    }
}
