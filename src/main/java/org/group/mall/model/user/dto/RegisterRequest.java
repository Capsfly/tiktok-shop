package org.group.mall.model.user.dto;


import jakarta.validation.constraints.Size;
import lombok.Data;
import org.group.mall.constant.UserConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Data
public class RegisterRequest {
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "密码不能为空")
    @Size(min = UserConstants.PASSWORD_MIN_LENGTH, message = "密码至少6位")
    private String password;

    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;
}