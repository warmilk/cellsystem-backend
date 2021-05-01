package com.kueen.cellsystem.controller;

import com.kueen.cellsystem.util.FileUtil;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam MultipartFile file) {
        String projectRootPath = System.getProperty("user.dir");
        String projectImgPath = "//src//main//resources//static";
        String imgSaveFullPath = projectRootPath + projectImgPath;
        String uploadPath = FileUtil.fileUpload(file, imgSaveFullPath);
        return "http://localhost:6660" + "/file/get/" + FileUtil.base64Encode(uploadPath);
    }

    @RequestMapping(value = "/get/{imgFullPath}", method = RequestMethod.GET)
    @ResponseBody
    public void fileAccess(HttpServletResponse response, @PathVariable String imgFullPath) {
        String imgPath = FileUtil.base64Decode(imgFullPath);
        try {
            FileUtil.getImage(response, imgPath);
        }catch (Exception e){
            System.out.println("图片回显异常");
        }
    }

}
