package com.kueen.cellsystem.controller;

import com.kueen.cellsystem.util.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/file")
public class FileController {

    @PostMapping("/upload")
    public String fileUpload(@RequestParam MultipartFile file) {
        String dirPath = "D:\\testUpload\\";//后台上传图片默认地址
        String uploadPath = FileUtil.fileUpload(file, dirPath);
//        uploadPath = uploadPath.replace("/", "_");
        return "http://localhost:6660/admin/file/get/path/" + FileUtil.base64Encode(uploadPath);
    }


//    @PostMapping("/get/path/{filePath}")
//    public String fileUpload(@PathVariable String filePath) {}

}
