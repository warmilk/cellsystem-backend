package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.service.CategoryService;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAll() {
        return CommonResult.success(categoryService.getAll());
    }


}
