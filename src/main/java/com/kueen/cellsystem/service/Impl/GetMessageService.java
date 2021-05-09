package com.kueen.cellsystem.service.Impl;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
public interface GetMessageService {
    void uploadImgMessage(MultipartFile multipartFiles);

}
