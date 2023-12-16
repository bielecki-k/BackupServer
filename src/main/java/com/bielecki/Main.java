package com.bielecki;

import com.google.common.collect.ImmutableList;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");
//        List<File> files = listFiles("C:\\Users\\admin\\Documents");
        copyFile();

    }

    public static void copyFile() throws IOException {

        File fileToCopy = new File("C:\\Users\\admin\\Documents\\konto xbox.txt");
        File destinationFolder = new File("C:\\Users\\admin\\Documents\\backupSystem");

//        String destinationPath = "C:\\Users\\admin\\Documents\\backupSystem\\konto xbox.txt"; // Zastąp ścieżką do nowego pliku

//        File newFile = new File(destinationPath);
//        newFile.createNewFile();

        Path sourcePath = new File("C:\\Users\\admin\\Documents\\konto xbox.txt").toPath();
        Path destinationPath = new File("C:\\Users\\admin\\Documents\\backupSystem\\konto xbox.txt").toPath();

        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

//        com.google.common.io.Files.copy(fileToCopy, destinationFolder);

    }

    public static List<File> listFiles(String directoryPath){
        List<File> fileList = ImmutableList.copyOf(Objects.requireNonNull(new File(directoryPath).listFiles()));
        for (File file : fileList) {
            System.out.println(file.getName());
        }
        return fileList;
    }

}