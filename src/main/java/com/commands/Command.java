package com.commands;

import com.service.WordService;
import com.wordsource.FileWordSource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;

@ShellComponent
public class Command {
    private final WordService wordService;

    Command(WordService wordService) {
        this.wordService = wordService;
    }

    @ShellMethod(value = "welcome", key = "welcome")
    public String welcome(){
        return "Welcome to the LoLingo words application.\n " +
                "What would you like to do?\n" +
                "type the command 'help' for the commands";
    }

   @ShellMethod(value ="Read the words from . ", key = "import")
    public void importFromFile(@ShellOption(help = "filename to be uploaded") File file)throws Exception{
        wordService.importFromWordSource(new FileWordSource(file));
   }
}
