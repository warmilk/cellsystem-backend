package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public String uploadSlices(MultipartFile[] multipartFiles) throws IOException {
        String sliceId = System.currentTimeMillis() + "";
        File slicePath = new File("./slice/" + sliceId);
        if (!slicePath.exists()) {
            slicePath.mkdir();
        }
        for (int i = 0; i < multipartFiles.length; i++) {
            multipartFiles[i].transferTo(Paths.get(slicePath + "/" + i + ".jpg"));
        }
        return sliceId;
    }
}
