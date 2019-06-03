package com.wfj.learn.apiserver.controller;

import com.wfj.learn.apiserver.base.utils.FtpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class UploadController {


    @GetMapping("/img")
    public void upload() {
        FtpUtil.upload();
    }

}
