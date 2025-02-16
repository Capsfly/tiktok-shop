package org.group.mall.model.user.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Integer userId;
    private String email;
    private LocalDateTime createTime;
}