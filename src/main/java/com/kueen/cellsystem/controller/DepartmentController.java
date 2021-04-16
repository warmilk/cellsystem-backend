package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.service.DepartmentService;
import com.kueen.cellsystem.service.RegionService;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAll() {
        return CommonResult.success(departmentService.getAll());
    }


}
