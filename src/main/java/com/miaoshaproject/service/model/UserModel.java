package com.miaoshaproject.service.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * MVC架构中，UserDO、UserPasswordDO等data object对应数据库的表信息，是纯粹的ORM映射，不涉及业务逻辑的处理
 * 而在service层相关方法中，不可以直接返回查询到的data object对象，应该使用Model进一步封装
 * 【在该类中，将encryptPassword字段也封装到UserModel中】
 *
 * NOTE: @NotBlank注解使用javax.validation包时，无法校验，且会抛出异常，推测是版本问题
 */
public class UserModel {
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotNull(message = "性别不能为空")
    private Byte gender;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄必须大于等于0岁")
    @Max(value = 150, message = "年龄必须小于等于150岁")
    private Integer age;

    @NotBlank(message = "手机号不能为空")
    private String telephone;
    private String registerMode;
    private String thirdPartyId;

    @NotBlank(message = "密码不能为空")
    private String encryptPassword;

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }
}
