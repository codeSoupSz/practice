package com.songzhou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songzhou.domain.User;

import java.util.List;
//@Mapper在使用MybatisPlus的情况下可省略
public interface UserMapper extends BaseMapper<User> {
    List<String> queryForAuthorities(Long id);
}
