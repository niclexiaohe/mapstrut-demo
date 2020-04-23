package com.hechuan.mapstrutdemo.vo.out;

/**
 * 用户OVO
 */
public class UserOVO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户出生日期(格式：yyyy-MM-dd)
     */
    private String userBirthday;

    /**
     * 用户性别
     */
    private Integer userGender;

    /**
     * 兴趣爱好
     */
    private String favorite;

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

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }
}
