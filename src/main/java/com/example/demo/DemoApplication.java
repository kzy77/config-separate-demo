package com.example.demo;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("hello")
    public String hello() throws IOException {
        //读取config中自定义的文件 如果是打在jar内，用此方法读取会报找不到文件，只能使用流读取
        File file = ResourceUtils.getFile("classpath:config/test.txt");
        return IOUtils.toString(new FileInputStream(file));
    }
}
