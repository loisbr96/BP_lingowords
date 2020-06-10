package com.component;

import com.service.WordService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;

@ShellComponent
public class CommandComponent {
    private final WordService wordService;

    CommandComponent(WordService wordService){
        this.wordService = wordService;
    }

    @ShellMethod("Welcome")
    public String welcome(){
        return "Welcome to the LoLingo words application.\n " +
                "What would you like to do?\n" +
                "type the command 'help' for the commands";
    }

   @ShellMethod(value ="Read the words from . ", key = "read")
    public void readFile(@ShellOption(help = "filename to be uploaded") File file) throws IOException {
        String filepath = file.getCanonicalPath();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))){
            String currentLine;
            while((currentLine = bufferedReader.readLine()) != null) {
                wordService.addWord(currentLine);
            }
        }
   }
}
