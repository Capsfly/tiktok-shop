package org.group.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.group.mall.model.user.User;

import java.util.Optional;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT COUNT(*) FROM users WHERE email = #{email}")
    boolean existsByEmail(String email);

    @Select("SELECT * FROM users WHERE email = #{email}")
    Optional<User> findByEmail(String email);
}