package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.entity.MofidyCellParam;
import com.kueen.cellsystem.service.CellService;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cell")
public class CellController {

    @Autowired
    private CellService cellService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAll() {
        return CommonResult.success(cellService.getAll());
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult modify(@RequestBody MofidyCellParam mofidyCellParam) {
        String filename = "./slice/" + mofidyCellParam.getSliceId() + "/" + mofidyCellParam.getIdx() + ".json";
        cellService.modifyCell(filename, mofidyCellParam.getData());
        return CommonResult.success(null);
    }

}
