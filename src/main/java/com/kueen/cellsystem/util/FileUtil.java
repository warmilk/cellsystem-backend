package com.kueen.cellsystem.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class FileUtil {

    private static Logger log = LoggerFactory.getLogger(FileUtil.class);

    public static String fileUpload(MultipartFile file, String path) {
        String uploadPath = null;
        try {
            if (path.endsWith("/")) {
                uploadPath = path + System.currentTimeMillis() + ".jpg";
            } else {
                uploadPath = path + File.separator + System.currentTimeMillis() + ".jpg";
            }
            //log.info("uploadPath--{}", uploadPath);
            if (!new File(uploadPath).exists()) {
                //创建父级文件路径
                new File(uploadPath).getParentFile().mkdirs();
                //创建文件
                new File(uploadPath).createNewFile();
            }
            //通过MultipartFile的方法直接写文件
            file.transferTo(new File(uploadPath));
        } catch (Exception e) {
            log.error("fileUpload error", e);
        }
        return uploadPath;
    }

    public static HttpServletResponse webDownload(HttpServletResponse response) {
        response.reset();
        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "attachment;filename=1619802456949_slice.jpg");
        return response;
    }

    public static void getImage(HttpServletResponse response, String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            response.setHeader("Content-Type", "image/gif, image/png, image/jpeg, image/bmp, image/webp, image/x-icon, image/vnd.microsoft.icon"); //设置响应头，告诉浏览器，这个请求返回的内容类型是图片
            FileInputStream in = new FileInputStream(file); //根据文件路径读取文件流
            OutputStream out = response.getOutputStream();
            IOUtils.copy(in, out); //把读取到的文件流写入响应体
            out.close();
            in.close();
        } else {
            throw new FileNotFoundException();
        }
    }


    public static Boolean deleteFile(String path) {
        try {
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static String base64Encode(String filePath) {
        byte[] encodedBytes = java.util.Base64.getEncoder().encode(filePath.getBytes());
        return new String(encodedBytes, java.nio.charset.Charset.forName("UTF-8"));
    }

    public static String base64Decode(String filePath) {
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(filePath.getBytes());
        return new String(decodedBytes, java.nio.charset.Charset.forName("UTF-8"));
    }

}
