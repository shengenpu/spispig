package com.example.sbspring.Service;

import com.example.sbspring.POJO.User;

import java.util.List;

public interface UserserviceI {
     List<User> queryAll();
     int register(String uuid,String username, String password);
     User login(String username,String password);
}
