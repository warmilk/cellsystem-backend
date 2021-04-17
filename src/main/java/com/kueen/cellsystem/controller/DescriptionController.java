package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.service.DescriptionService;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.kueen.cellsystem.entity.DescriptionDetail;

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

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult modify(@RequestBody DescriptionDetail descriptionDetail) {
        descriptionService.modify(descriptionDetail);
        return CommonResult.success(null);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody DescriptionDetail descriptionDetail) {
        descriptionService.add(descriptionDetail);
        return CommonResult.success(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestBody int id) {
        descriptionService.delete(id);
        return CommonResult.success(null);
    }


}
