package com.lockers.ltd;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("*** Wellcome to the Lockers.***");
        System.out.println("To continue to the MENU type 1 the enter and to close type 0 and enter");
        while (true) {
            Integer in = input.nextInt();
            if (in == 1) {
                menu();
            } else if (in == 0) {
                System.out.println("GoodBye!!!");
                System.exit(1);
            } else {
                System.out.println("Wrong Input, try again");
            }
        }
    }

    private static void menu() {
        System.out.println("1: View Files\n2: File Operations\n0: Exit");
        Scanner input = new Scanner(System.in);
        while (true) {
            Integer in = input.nextInt();
            switch (in) {
                case 1:
                    retrieve();
                    break;
                case 2:
                    fileOperations();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong Input, Try again or 0 to exit");
            }
        }
    }

    private static void fileOperations() {
        System.out.println("1: Add File\n2: Delete File\n3: Search File\n4: Return to previous menu\n0: Exit");

        Scanner input = new Scanner(System.in);
        while (true) {
            Integer in = input.nextInt();
            switch (in) {
                case 1:
                    addFile();
                    break;
                case 2:
                    deleteFile();
                    break;
                case 3:
                    searchFile();
                    break;
                case 4:
                    menu();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong Input, Try again or 0 to exit");
            }
        }

    }

    private static void searchFile() {
        String in = inputFileName();
        File files = new File("./main/");
        FilenameFilter filter = (dir, name) -> name.startsWith(in);
        int i = 0;
        for (File file : files.listFiles(filter)) {
            i++;
            System.out.println(i + ". " + file.getName());
        }
        System.out.println();
        menu();
    }

    private static void deleteFile() {
        String in = inputFileName();

        File file = new File("./main/" + in + ".txt");
        if (file.delete()) {
            System.out.println("Success! Deleted the file: " + file.getName() + "\n\n");
        } else {
            System.out.println("Failed to delete the file.Make sure the file exists\n\n");
        }
        fileOperations();

    }

    private static void addFile() {
        String in = inputFileName();
        try {
            File file = new File("./main/" + in + ".txt");
            if (file.createNewFile()) {
                System.out.println("Success! File created: " + file.getName() + "\n\n");
            } else {
                System.out.println("File already exists.\n\n");
            }
            fileOperations();
        } catch (IOException e) {
            System.out.println("An error occurred. \n\n");
            e.printStackTrace();
            fileOperations();
        }
    }

    private static String inputFileName() {
        System.out.println("Please enter the file name: ");
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        if (in.trim() == "") {
            inputFileName();
        }
        return in;
    }

    private static void retrieve() {
        File files = new File("./main/");
        int i = 0;
        for (File file : files.listFiles()) {
            i++;
            System.out.println(i + ". " + file.getName());
        }
        System.out.println();
        menu();
    }


}
