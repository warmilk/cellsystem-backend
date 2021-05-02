package com.kueen.cellsystem.service;

import com.kueen.cellsystem.entity.FileDetail;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;


public interface FileService {
    FileDetail uploadImgFile(MultipartFile multipartFiles);
    void accessImgFile(HttpServletResponse response, String imgFullPath);
}
