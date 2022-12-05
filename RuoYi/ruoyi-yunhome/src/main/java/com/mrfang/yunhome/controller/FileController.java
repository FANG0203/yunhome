package com.mrfang.yunhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;


/**
 * @ Author: Fang
 * @ Date: 2022/11/24 9:11
 * @ Project: RuoYi
 */

@Controller
@RequestMapping("/yunhome/file")
public class FileController {

    @ResponseBody
    @PostMapping("upload")
    public String upload(MultipartFile file) throws IOException {
        File file1 = new File("D:\\ruoyi\\uploadPath\\tenant\\");

        //如果目录不存在，则创建目录
        if(!file1.exists()){
            file1.mkdirs();
        }

        //生成一串无意义的字符串
        String fileName = UUID.randomUUID().toString();
        //使用时间+3位流水号
//        String str = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
        //得到新的文件名
        fileName = file1.getPath() +"/"+ fileName + ".jpg";
        File file2 = new File(fileName);

        //文件复制
        file.transferTo(file2);

        return file2.getName();
    }

    @GetMapping("showImage")
    public void showImage(String fileName, HttpServletResponse response) throws IOException {
        File file = new File("D:\\ruoyi\\uploadPath\\tenant\\" + fileName);

        response.setContentType("image/jpeg");

        FileInputStream in = new FileInputStream(file);
        byte[] data = new byte[in.available()];
        in.read(data);

        response.getOutputStream().write(data);
    }
}
