package com.basejava.webapp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainFileRecursion {
    public static void main(String[] args) {
        // TODO: сделать рекурсивный обход и вывод имени файлов в каталогах и подкаталогах (корневой каталоог - мой проек)
        long start = System.currentTimeMillis();
        File project = new File("C:\\Users\\Евгения\\IdeaProjects\\basejava");
        List<File> result = new ArrayList<>();
        if (!project.exists()) {
            System.out.printf("\nProject %s directory not found", project.getAbsolutePath());
        }
        if (!project.isDirectory()) {
            System.out.printf("\nProject in the path: %s is not directory", project.getAbsolutePath());
        }
        System.out.println("File search started");

        doRecursion(project, result);

        System.out.println("\nFile search completed \n \nResult:");
        for (File file : result) {
            System.out.println(file.getName());
        }

        System.out.printf("\nFinding files with extension \".java\" and outputting to console took: %s milliseconds", System.currentTimeMillis() - start);
    }

    private static void doRecursion(File project, List<File> result) {
        System.out.printf("\nThe search in folder %s completed", project);
        File[] files = project.listFiles();

        if (files == null) {
            System.out.println("Project does not contain files");
        } else {
            for (File file : files) {
                if (!file.isDirectory()) {
                    if (file.getName().toLowerCase().endsWith(".java")) {
                        result.add(file);
                    }
                } else {
                    doRecursion(file, result);
                }
            }
        }
    }
}
