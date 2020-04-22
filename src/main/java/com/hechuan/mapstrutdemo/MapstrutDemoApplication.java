package com.hechuan.mapstrutdemo;

import com.hechuan.mapstrutdemo.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping(value = "/main")
public class MapstrutDemoApplication {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(MapstrutDemoApplication.class, args);
    }

//    /**
//     * 测试mapping映射转换
//     */
//    @RequestMapping("test")
//    @ResponseBody
//    public void mappingTest(){
//        userMapper
//    }
}
