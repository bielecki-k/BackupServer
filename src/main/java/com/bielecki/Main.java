package com.bielecki;

import com.google.common.collect.ImmutableList;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;
import java.util.Objects;

import com.google.common.io.Files;
@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        listFiles("C:\\Users\\admin\\Documents");

    }

    public static void listFiles(String directoryPath){

        // Wykorzystanie Guava do stworzenia niemodyfikowalnej listy plików
        List<File> fileList = ImmutableList.copyOf(Objects.requireNonNull(new File(directoryPath).listFiles()));

        // Wyświetlanie nazw plików
        for (File file : fileList) {
            System.out.println(file.getName());
        }
    }

}