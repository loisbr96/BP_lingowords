package com.component;

import com.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import static org.springframework.shell.standard.ShellOption.NULL;

@ShellComponent
public class Commands {
//    private final TranslationService service;
//
//    @Autowired
//    public TranslationCommands(TranslationService service){
//        this.service = service;
//    }

    @ShellMethod("Welcome")
    public String welcome(){
        return "Welcome to the LoLingo words application";
    }

   @ShellMethod(value ="Add numbers. ", key = "sum")
    public int add(int a, int b){
       return a+b;
   }

    @ShellMethod(key = "upload", value = "Upload a file.")
    public String upload(@ShellOption(help = "the file to be uploaded") String path,
                         @ShellOption(help = "the local repository name to upload to", defaultValue = NULL) String repoName) {
//        UploadRequest uploadRequest = new UploadRequest();
        Object fileByte;
        String fileName;
        try {
            File file = ResourceUtils.getFile(path);
            fileName = file.getName();
//            fileName = zipFileName.substring(0, zipFileName.lastIndexOf("-"));
//            String versionAndExtension = zipFileName.substring(fileName.length() + 1);
//            String extension = versionAndExtension.substring(versionAndExtension.lastIndexOf(".") + 1);
//            String version = versionAndExtension.replaceAll("." + extension, "");
//            uploadRequest.setName(fileName);
//            uploadRequest.setVersion(version);
//            uploadRequest.setExtension(extension);
//            uploadRequest.setRepoName(StringUtils.hasText(repoName) ? repoName : "local");
//            uploadRequest.setPackageFileAsBytes(Files.readAllBytes(file.toPath()));
            fileByte = Files.readAllBytes(file.toPath());
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File Not found: " + e.getMessage());
        }
        catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
//        PackageMetadata packageMetadata = skipperClient.upload(fileByte);
        return "file uploaded successfully:" + fileByte ;
    }



}
