package com.hechuan.mapstrutdemo;

import com.hechuan.mapstrutdemo.vo.in.UserIVO;
import com.hechuan.mapstrutdemo.vo.out.UserOVO;
import com.hechuan.mapstrutdemo.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@SpringBootApplication
@Controller
@RequestMapping(value = "/main")
public class MapstrutDemoApplication {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(MapstrutDemoApplication.class, args);
    }

    /**
     * 测试mapping映射转换
     */
    @RequestMapping("test")
    @ResponseBody
    public UserOVO mappingTest(){
        UserIVO userIDTO = new UserIVO();
        userIDTO.setName("何川");
        userIDTO.setAge(18);
        userIDTO.setBirthday(new Date());
        userIDTO.setGender("1");
//        userIDTO = null;
        UserOVO userODTO = userMapper.toODTO(userIDTO);
        return userODTO;
    }
}
