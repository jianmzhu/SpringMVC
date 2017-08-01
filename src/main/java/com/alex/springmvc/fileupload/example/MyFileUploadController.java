package com.alex.springmvc.fileupload.example;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
 

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
 
@Controller
public class MyFileUploadController {
 
    // Upload One File.登录地址http://localhost:8080/SpringMVC/upload/uploadOneFile进入views/uploadFolder/uploadOneFile.jsp页面
    @RequestMapping(value = "/upload/uploadOneFile")
    public String uploadOneFileHandler() {
        // Forward to "/WEB-INF/pages/uploadOneFile.jsp".
        return "uploadFolder/uploadOneFile";
    }
 
    // Upload Multi File.登录地址http://localhost:8080/SpringMVC/upload/uploadMultiFile进入views/uploadFolder/uploadMultiFile.jsp页面
    @RequestMapping(value = "/upload/uploadMultiFile")
    public String uploadMultiFileHandler() {
        // Forward to "/WEB-INF/pages/uploadMultiFile.jsp".
        return "uploadFolder/uploadMultiFile";
    }
    //页面中/upload/doUpload跳转到该类
    // uploadOneFile.jsp, uploadMultiFile.jsp submit to.
    @RequestMapping(value = "/upload/doUpload", method = RequestMethod.POST)
    public String uploadFileHandler(HttpServletRequest request, Model model,
            @RequestParam("file") MultipartFile[] files) {
 
        // Root Directory.服务器绝对路径
        String uploadRootPath = request.getSession().getServletContext().getRealPath("upload");//获取upload在服务器路径中的位置
        System.out.println("uploadRootPath=" + uploadRootPath);
 
        File uploadRootDir = new File(uploadRootPath);
        //
        // Create directory if it not exists.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        //
        List<File> uploadedFiles = new ArrayList<File>();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
 
            // Client File Name
            String name = file.getOriginalFilename();
            System.out.println("Client File Name = " + name);
 
            if (name != null && name.length() > 0) {
                try {
                    byte[] bytes = file.getBytes();
 
                    // Create the file on server
                    File serverFile = new File(uploadRootDir.getAbsolutePath()
                            + File.separator + name);
 
                    // Stream to write data to file in server.
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(serverFile));
                    stream.write(bytes);//将上传文件用输出流写入到服务器路径中
                    stream.close();
                    //
                    uploadedFiles.add(serverFile);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                }
            }
        }
        model.addAttribute("uploadedFiles", uploadedFiles);
        return "uploadFolder/uploadResult";
    }
 
}