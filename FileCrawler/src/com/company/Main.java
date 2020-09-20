package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main { // Shayan / Islam / Leszek

    public static void main(String[] args) {

        boolean loop = true;
        while (loop) {
            File startingFolder = new File("C:\\Users\\Chalamdor\\IdeaProjects\\FileCrawler\\TESTUPPGIFT");
            Scanner sc = new Scanner(System.in);
            System.out.println("================");
            System.out.println("[1] Sök efter en text");
            System.out.println("[2] Exit");
            System.out.print("Choice: ");
            String input1 = sc.next();

            switch (input1) {
                case "1" -> {
                    System.out.print("Sök efter text: ");
                    String input = sc.next();
                    printInfo(startingFolder, input);
                } case "2" -> loop = false;
            }
        }
    }

    public static void printInfo(File file, String input) {
        if (file.isFile() && file.canRead()) {
            readFile(file,input);
        }
        else if (file.isDirectory()) {
            try {
                File[] folderContents = file.listFiles();
                for (File f : folderContents) {
                    printInfo(f, input);
                }
            } catch (Exception e) {
                System.err.print(file.getAbsoluteFile());
            }
        }
        else {
            System.err.print(file.getAbsoluteFile());
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
            System.err.print(file.getAbsoluteFile());
        }
    }
}