package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.service.CellService;
import com.kueen.cellsystem.service.RegionService;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAll() {
        return CommonResult.success(regionService.getAll());
    }


}
