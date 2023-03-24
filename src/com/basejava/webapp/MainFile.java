package com.basejava.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Евгения\\Desktop\\Заметки.txt";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalFile());
        } catch (IOException e) {
            throw new RuntimeException("Exception: ", e);
        }

        File dir = new File("C:\\Users\\Евгения\\IdeaProjects\\basejava\\basejava\\src\\com\\basejava\\webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            System.out.println(fileInputStream.read());
        } catch (IOException e) {
            throw new RuntimeException("Exception: ", e);
        }

        System.out.println("\nВыполнение рекурсивного обхода и вывода имен файлов\n");
        doRecursion(dir);
    }

    //TODO: make pretty output
    public static void doRecursion(File dir) {
//        System.out.printf("\nThe search in folder %s completed", project);
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Project does not contain files");
        } else {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    doRecursion(file);
                }
            }
        }
    }
}
