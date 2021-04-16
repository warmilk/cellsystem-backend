package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.service.DescriptionService;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/description")
public class DescriptionController {

    @Autowired
    private DescriptionService descriptionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAll() {
        return CommonResult.success(descriptionService.getAll());
    }


}
