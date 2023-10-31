package com.example.sbspring.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sbspring.POJO.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
