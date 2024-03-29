package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.service.FileService;
import com.kueen.cellsystem.entity.FileDetail;
import com.kueen.cellsystem.util.FileUtil;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public FileDetail uploadImgFile(MultipartFile file) {
        String projectRootPath = System.getProperty("user.dir");
        String projectImgPath = "/src/main/resources/static";
        String imgSaveFullPath = projectRootPath + projectImgPath;
        String uploadPath = FileUtil.fileUpload(file, imgSaveFullPath);
        //String imgPath = FileUtil.base64Decode(uploadPath);
        //System.out.println(imgPath);
        FileDetail fileDetail = new FileDetail();
        //fileDetail.setImgUrl("http://localhost:6660" + "/file/get/" + FileUtil.base64Encode(uploadPath));
        fileDetail.setPartimgUrl(FileUtil.base64Encode(uploadPath));
        fileDetail.setImgUrl("http://localhost:6660" + "/file/get/" + fileDetail.getPartimgUrl());
        return fileDetail;
    }

    @Override
    public void accessImgFile(HttpServletResponse response, String imgFullPath) {
        String imgPath = FileUtil.base64Decode(imgFullPath);
        System.out.println(imgPath);
        try {
            FileUtil.getImage(response, imgPath);
        } catch (Exception e) {
            System.out.println("图片回显异常");
        }
    }
}
