package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.util.api.CommonResult;
import com.kueen.cellsystem.service.FileService;
import com.kueen.cellsystem.entity.FileDetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService; //之所以import了FileService进来还需要@Autowired private FileService fileService; ，是因为不写这个的话，下面的FileDetail fileDetail = fileService.uploadImgFile(file); 会报错【无法从静态上下文中引用非静态方法】需要手动new实例化对象才能用 https://www.jianshu.com/p/203d03f98aa6

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult fileUpload(@RequestParam MultipartFile file) {
        FileDetail fileDetail = fileService.uploadImgFile(file);
        return CommonResult.success(fileDetail);

    }

    @RequestMapping(value = "/get/{imgFullPath}", method = RequestMethod.GET)
    @ResponseBody
    public void fileAccess(HttpServletResponse response, @PathVariable String imgFullPath) {
        fileService.accessImgFile(response, imgFullPath);
    }

}
