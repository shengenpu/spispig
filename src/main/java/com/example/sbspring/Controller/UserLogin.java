package com.example.sbspring.Controller;

import com.example.sbspring.JWT.JWTUtils;

import com.example.sbspring.POJO.User;
import com.example.sbspring.Service.Userservice;
import com.example.sbspring.Tool.CUUID;
import com.example.sbspring.Tool.MD5;
import com.example.sbspring.Tool.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RestController
public class UserLogin {
    @Autowired
    Userservice userservice;
    @Autowired
    CUUID cuuid;
    MD5 md5=new MD5();
    @GetMapping("/select")
    public List<User> sb(){
        return  userservice.queryAll();
    }
    @GetMapping("/register")
    public Result<Integer> register(@RequestParam String username,@RequestParam String password){
        String uuid = cuuid.CreateUUID();
        String md5pwd = md5.MD5use(password);
        int register = userservice.register(uuid,username, md5pwd);
        return Result.success(register, "register success");
    }
    @PostMapping("/login")
    public Result<User> login(@RequestParam String username,@RequestParam String password){
        String md5pwd = md5.MD5use(password);
        User login = userservice.login(username, md5pwd);
        System.out.println(login);
        String token= JWTUtils.createToken(login);
        return Result.sgs(login,"login success",token);
    }

}
