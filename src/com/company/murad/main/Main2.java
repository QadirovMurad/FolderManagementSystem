package com.company.murad.main;

import com.company.murad.members.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Users\\hp\\Desktop\\Java\\qaqa.txt");
        Path target = Paths.get("C:\\Users\\hp\\Desktop\\Java\\lale.txt");

        Files.move(source,target);

    }
}
