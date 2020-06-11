package com.wordsource;

import com.service.WordSource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileWordSource implements WordSource {
    private File file;

    @Override
    public List<String> read(Object sourceObject) throws Exception {
        this.file = (File) sourceObject;
        ArrayList<String> words = new ArrayList<>();

        String filepath = file.getCanonicalPath();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))){
            String currentLine;
            while((currentLine = bufferedReader.readLine()) != null) {
                words.add(currentLine);
            }
        }
        return words;
    }
}
