package com.frank.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 14:49 2019/9/25
 */

@RestController
public class UploadController {
    @RequestMapping("/UploadController")
    public Map<String, Object> fileUpload(MultipartFile filename) throws IOException {
        System.out.println("上传：" + filename.getOriginalFilename());
        filename.transferTo(
            new File("d:/"+filename.getOriginalFilename()));
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }
}
