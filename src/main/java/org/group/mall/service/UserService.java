package org.group.mall.service;


import lombok.RequiredArgsConstructor;
import org.group.mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.group.mall.model.user.User;


import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    // 注册用户
    public Integer register(String email, String password) {
        if (userMapper.existsByEmail(email)) {
            throw new RuntimeException("Email已存在");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
        return user.getUserId();
    }

    // 用户登录
    public Integer login(String email, String password) {
        User user = userMapper.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        return user.getUserId();
    }
}