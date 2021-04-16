package com.kueen.cellsystem.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {

    String uploadSlices(MultipartFile[] multipartFiles) throws IOException;

}
