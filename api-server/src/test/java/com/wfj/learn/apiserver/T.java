package com.wfj.learn.apiserver;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

public class T {

    public static void main(String[] args) {
        File file =new File("C:\\Users\\mrwfj\\Desktop\\q\\1.png");
        try {
            writeFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("发送成功!");

    }

    private static String writeFile(File file) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        FileInputStream fis = new FileInputStream(file);
        // 获得文件上传流


        byte[] fileBytes = new byte[1024];
        int n;
        while ((n = fis.read(fileBytes)) != -1) {
            bos.write(fileBytes, 0, n);
        }
        fis.close();
        bos.close();
        byte[] buffer = bos.toByteArray();

        // 获取文件后缀
        String fileName = file.getName();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        // 设置文件在服务器的随机名字
        String newFileName = UUID.randomUUID() + fileSuffix;
        // 创建jersey服务器，进行跨服务器上传
        Client client = Client.create();
        // 将文件关联到远程服务器（Constant.FILE_HOST ="http://127.0.0.1:8080/upload/"）
        WebResource resource = client.resource("http://114.55.242.55/img/" + newFileName);
        // 上传
        resource.put(String.class, fileBytes);
        //返回文件名
        return newFileName;
    }
}
