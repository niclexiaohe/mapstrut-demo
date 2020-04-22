package com.hechuan.mapstrutdemo.dto.in;

import java.util.Date;

/**
 * 用户IDTO
 */
public class UserIDTO {

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户出生日期
     */
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
