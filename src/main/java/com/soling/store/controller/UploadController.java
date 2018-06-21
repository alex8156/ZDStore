package com.soling.store.controller;

import com.soling.store.model.Package;
import com.soling.store.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Controller
public class UploadController {

    private static Logger Log = Logger.getLogger(UploadController.class);

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping(value = "/upload/{type}")
    public String uploadIcon(HttpServletRequest request,
                             HttpServletResponse response, @RequestParam(value="file") MultipartFile multipartFile,@PathVariable String type) throws IOException {
        URL url = request.getServletContext().getResource("/");
        String foldPath = url.getFile()+"resources/"+type+"/";
        Log.info("保存文件的目录为:url.getFile()="+foldPath);
        Log.info("原始文件名称:"+multipartFile.getOriginalFilename());
        File foldFile = new File(foldPath);
        if(!foldFile.exists())foldFile.mkdirs();
        File dest = new File(foldFile,multipartFile.getOriginalFilename());
        multipartFile.transferTo(dest);
        return "/resources/"+type+"/"+multipartFile.getOriginalFilename();
    }


    @PostMapping(value = "/upload/packageInfo")
    @ResponseBody
    public String uploadAppInfo(HttpServletRequest request, Package packageInfo) {
        Log.info("包信息:"+packageInfo);
        packageInfo.setAppIcon(request.getLocalAddr()+packageInfo.getAppIcon());
        packageInfo.setAppFile(request.getLocalAddr()+packageInfo.getAppFile());
        userService.insert(Package.class,packageInfo);
        return "上传成功";
    }

    @GetMapping(value = "/packages")
    @ResponseBody
    public List<Package> findAll() {
        return userService.findAll(Package.class);
    }


}
