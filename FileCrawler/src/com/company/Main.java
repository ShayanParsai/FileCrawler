package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            File startingFolder = new File("C:\\Users\\Chalamdor\\IdeaProjects\\FileCrawler\\TESTUPPGIFT");

            Scanner sc = new Scanner(System.in);
            System.out.print("Sök efter text: ");
            String input = sc.next();

            printInfo(startingFolder,input);
    }

    public static void printInfo(File file, String input) {

        if (file.isFile()) {

            readFile(file,input);

        } else if (file.isDirectory()) {
            try {
                File[] folderContents = file.listFiles();
                for (File f : folderContents) {

                    printInfo(f, input);
                }
            } catch (Exception e) {
                System.out.println("Oops 2");
            }
        }
    }

    public static void readFile(File file, String input) {

        try {
            Scanner sc = new Scanner(file);
            String fileText;
            while (sc.hasNext()) {

                fileText = (sc.next());

                if (fileText.contains(input)) {
                    System.out.println(input + " Can be found in: " + file.getAbsolutePath());
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("oops 3");
        }
    }
}
