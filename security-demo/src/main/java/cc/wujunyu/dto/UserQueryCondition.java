package cc.wujunyu.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserQueryCondition {
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    private int age;
    private int ageTo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }
}
