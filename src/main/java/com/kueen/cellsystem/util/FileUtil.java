package com.kueen.cellsystem.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 文件操作
 *
 * @author guoqinghua
 * @create 2019-07-30 14:36
 */
public class FileUtil {

    private static Logger log = LoggerFactory.getLogger(FileUtil.class);

    private static String ftpStartAndEnd = "/";

    /**
     * 文件上传
     *
     * @param file
     * @param path
     * @return
     * @throws Exception
     */
    public static String fileUpload(MultipartFile file, String path) {
        log.info("fileUpload -- fileName：{},---path--{}", file.getOriginalFilename(), path);
        String uploadPath = null;
        try {
            String fileName = URLDecoder.decode(file.getOriginalFilename(), "utf-8");
            if (path.endsWith(ftpStartAndEnd)) {
                uploadPath = path + System.currentTimeMillis() + "_" + fileName;
            } else {
                uploadPath = path + File.separator + System.currentTimeMillis() + "_" + fileName;
            }
            log.info("uploadPath--{}", uploadPath);
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

    /**
     * 通过浏览器下载
     *
     * @param name
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    public static HttpServletResponse webDownload(String name, String fileName, HttpServletRequest request, HttpServletResponse response) {
        try {
            //获得浏览器代理信息
            final String userAgent = request.getHeader("USER-AGENT");
            //如果fileName为空，默认为文件名称
//            if (StringUtils.isEmpty(fileName)) {
//                fileName = name;
//            }
            String finalFileName;
            //判断浏览器代理并分别设置响应给浏览器的编码格式
            //其他浏览器
            finalFileName = URLEncoder.encode(fileName, "UTF8");
            //设置HTTP响应头
            // 重置 响应头
            response.reset();
            //告知浏览器下载文件，而不是直接打开，浏览器默认为打开
            response.setContentType("application/x-download");
            //下载文件的名称
            response.addHeader("Content-Disposition", "attachment;filename=\"" + finalFileName + "\"");
        } catch (Exception e) {
            log.info("---download error--", e);
        }

        return response;
    }


    /**
     * 删除文件
     *
     * @param path 路径
     * @return
     */
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


    public static String base64Encode(String token) {
        byte[] encodedBytes = java.util.Base64.getEncoder().encode(token.getBytes());
        return new String(encodedBytes, java.nio.charset.Charset.forName("UTF-8"));
    }

    // 解码
    public static String base64Decode(String token) {
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(token.getBytes());
        return new String(decodedBytes, java.nio.charset.Charset.forName("UTF-8"));
    }

}
