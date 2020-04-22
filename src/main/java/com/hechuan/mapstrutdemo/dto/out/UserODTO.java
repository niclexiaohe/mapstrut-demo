package com.hechuan.mapstrutdemo.dto.out;

import java.util.Date;

/**
 * 用户ODTO
 */
public class UserODTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户出生日期
     */
    private Date UserBirthday;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Date getUserBirthday() {
        return UserBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        UserBirthday = userBirthday;
    }
}
