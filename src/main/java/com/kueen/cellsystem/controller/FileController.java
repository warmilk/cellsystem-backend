package com.kueen.cellsystem.controller;

import com.kueen.cellsystem.util.FileUtil;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;




@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam MultipartFile file) {
        String projectRootPath = System.getProperty("user.dir"); //获取当前项目的根目录
        String projectImgPath = "/slice";
        String imgSaveFullPath = projectRootPath + projectImgPath;  //后台上传图片地址


        String uploadPath = FileUtil.fileUpload(file, imgSaveFullPath); //http://localhost:6660/sliceImg/D:\Program Files (x86)\cellsystem/sliceImg\1619775271248_slice.jpg



//        return "http://localhost:6660" + projectImgPath + FileUtil.base64Encode(uploadPath); // base64Encode base64加密防止目录被猜解，图片被遍历访问
        return "http://localhost:6660" + "/file/get/" + FileUtil.base64Encode(uploadPath);
    }

    @RequestMapping(value = "/get/{imgFullPath}", method = RequestMethod.GET)
    @ResponseBody
    public String fileUpload(@PathVariable String imgFullPath) {
        //1.url//decode
        //2."D:\\testUpload\\\\1619769996293_slice.jpg"
        //3.
//        String dirPath = "D:\\testUpload\\";
        return "你是煞笔";
    }

}
