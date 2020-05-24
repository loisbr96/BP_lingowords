package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DatabaseService {
    @Value ("${application.api}")
    private String api;

    public String addWord(String word){
        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher = pattern.matcher(word);
        boolean find = matcher.find();
        if(!find){
            System.out.println(word);
        }
//        UrlResource url = url.createRelativeUrl(api + "/word/add/");

        return word;
    }
}
