package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] availableOptions = {"add", "remove", "list", "exit"};
        Path tasks = Paths.get("tasks.csv");

        printOptions(availableOptions);


        }



        public static void printOptions(String[] tab) {
            System.out.println(ConsoleColors.BLUE + "Please select an option:");
            System.out.print(ConsoleColors.RESET);
            for (String opt : tab) {
                System.out.println(opt);
            }
        }








    }

