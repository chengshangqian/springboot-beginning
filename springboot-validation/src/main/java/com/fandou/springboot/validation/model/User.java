package com.fandou.springboot.validation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class User {
    private String id;

    @NotEmpty(message = "用户名不能为空")
    @Size(min = 4, max = 128, message = "用户名长度应为4到128位")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 8, max = 64, message = "密码长度应为8到64位")
    private String password;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Pattern(regexp = "[0-9]{11}", message = "手机号码格式不正确")
    private String phone;

    @Past(message = "出生日期不能大于现在")
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate birthday;

    @Range(min = -1L, max = 1L, message = "性别取值范围为未知(-1)、男(0)、女(1)")
    private Integer sex;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                '}';
    }
}
