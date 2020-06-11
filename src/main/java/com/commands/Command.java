package com.commands;

import com.service.WordService;
import com.service.WordSource;
import com.wordsource.FileWordSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;
import java.util.List;

@ShellComponent
public class Command {
    private final WordService wordService;

    private final WordSource wordSource;

    Command(WordService wordService, WordSource wordSource) {
        this.wordService = wordService;
        this.wordSource = wordSource;
    }

    @ShellMethod(value = "Welcome message", key = "Welcome")
    public String welcome(){
        return "Welcome to the LoLingo words application.\n " +
                "What would you like to do?\n" +
                "type the command 'help' for the commands";
    }

   @ShellMethod(value ="Read the words from . ", key = "import")
    public void importFromFile(@ShellOption(help = "filename to be uploaded") File file)throws Exception{
        List<String> wordList = wordSource.read(file);

        for(String word : wordList){
            wordService.addWord(word);
        }
   }
}
