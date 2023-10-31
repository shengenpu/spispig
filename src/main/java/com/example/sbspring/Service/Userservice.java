package com.example.sbspring.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sbspring.Dao.UserMapper;
import com.example.sbspring.POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice implements UserserviceI {
    @Autowired
    private UserMapper userMapper;

    public List<User> queryAll() {
        return userMapper.selectList(null);
    }

    @Override
    public int register(String uuid,String username, String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setId(Integer.parseInt(uuid));
        return userMapper.insert(user);
    }
    @Override
    public User login(String username, String password) {
        System.out.println(username+password);
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        return userMapper.selectOne(queryWrapper);
    }


}
