package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.service.OpinionService;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.kueen.cellsystem.entity.OpinionDetail;

@Controller
@RequestMapping("/opinion")
public class OpinionController {

    @Autowired
    private OpinionService opinionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAll() {
        return CommonResult.success(opinionService.getAll());
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult modify(@RequestBody OpinionDetail opinionDetail) {
        opinionService.modify(opinionDetail);
        return CommonResult.success(null);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody OpinionDetail opinionDetail) {
        opinionService.add(opinionDetail);
        return CommonResult.success(opinionDetail.getId());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestBody OpinionDetail opinionDetail) {
        opinionService.delete(opinionDetail.getId());
        return CommonResult.success(null);
    }

}
