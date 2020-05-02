package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IntroductionService {

    @Value("${message.default}")
    private String message;

    public String getMessage(){
        return message;
    }

    public String getMessage(String message){
        return "Hey, " + message;
    }
}
