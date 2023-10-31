package com.example.sbspring.Tool;

import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CUUID {
    public String CreateUUID(){
        UUID uuid=UUID.randomUUID();
        System.out.println(uuid);
        return uuid.toString();
    }
}
