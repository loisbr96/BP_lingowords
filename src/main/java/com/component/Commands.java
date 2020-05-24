package com.component;

import com.service.DatabaseService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.*;


@ShellComponent
public class Commands {
    private final DatabaseService databaseService;

    @ShellMethod("Welcome")
    public String welcome(){
        return "Welcome to the LoLingo words application.\n " +
                "What would you like to do?\n" +
                "type the command 'help' for the commands";
    }

   @ShellMethod(value ="Read the words from . ", key = "read")
    public String readWord(@ShellOption(help = "filename to be uploaded") File file) throws IOException {
        String filepath = file.getCanonicalPath();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))){
            String currentLine;
            while((currentLine = bufferedReader.readLine()) != null) {
                databaseService.addWord(currentLine);//
            }

        }catch (IOException e){
            return e.getMessage();
        }
        return "The words of file " + file + " have been uploaded in the database";
   }

   Commands(DatabaseService databaseService){
        this.databaseService = databaseService;
   }
}
