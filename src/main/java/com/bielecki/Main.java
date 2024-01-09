package com.bielecki;

import com.google.common.collect.ImmutableList;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class Main {

    static Path destinationPath = new File("C:\\Users\\admin\\Documents\\backupSystem").toPath();

    static String sourcePath = "C:\\Users\\admin\\Documents";

    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");
        listFilesFromDirectory(sourcePath);

    }

    public static void listFilesFromDirectory(String sourceDirPath){
        listFiles(sourceDirPath).forEach(Main::copyFile);

    }

    public static void copyFile(File fileToCopy )  {
        String dest = destinationPath+"\\"+ fileToCopy.getName();
        try {
            Files.copy(fileToCopy.toPath(), Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Exception: "+e);
        }
    }

    public static List<File> listFiles(String directoryPath){
        List<File> fileList = ImmutableList.copyOf(Objects.requireNonNull(new File(directoryPath).listFiles()));
        for (File file : fileList) {
            System.out.println("to copy: "+directoryPath+"\\"+file.getName());
        }
        return fileList;
    }

}