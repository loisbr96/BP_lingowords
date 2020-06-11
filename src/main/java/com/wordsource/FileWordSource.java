package com.wordsource;

import com.service.WordSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

public class FileWordSource implements WordSource {
    private File file;

    public FileWordSource(File file) {
        this.file = file;
    }


    @Override
    public List<String> read() throws Exception {

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
