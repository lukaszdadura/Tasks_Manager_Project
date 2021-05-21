package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Path pathTasks = Paths.get("tasks.csv");
        if (!Files.exists(pathTasks)) {
            System.out.println("There is no task file!");
        }

        //Czytam plik i wpisuje do listy. Do tablicy dwuwymiarowej wpisuje eleemnty przyjmujac za wiersze ilosc linii, a za kolumny Stringi po przecinku w linii
        String[][] tasksLinesElements = null;
        try {
            List<String> tasksLines = Files.readAllLines(pathTasks);
           // System.out.println(tasksLines);
           // System.out.println(tasksLines.get(0).split(",").length);
            tasksLinesElements = new String[tasksLines.size()][tasksLines.get(0).split(",").length];
            for (int i = 0; i < tasksLines.size(); i++) {
                String[] elements = tasksLines.get(i).split(",");
                for (int j = 0; j < elements.length; j++) {
                    tasksLinesElements[i][j] = elements[j];
                }
            }
         //   System.out.println(Arrays.deepToString(tasksLinesElements));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There is some problem with file!");
        }
        //System.out.println(Arrays.deepToString(tasksLinesElements));

        //Deklaruje opcje w tablicy Stringow i wyswietlam w menu

        String[] availableOptions = {"add", "remove", "list", "exit"};
        System.out.println(ConsoleColors.BLUE + "Please select an option:");
            System.out.print(ConsoleColors.RESET);
            for (String options : availableOptions) {
                System.out.println(options);
            }

        Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String typedOption = scanner.nextLine();
                switch (typedOption) {
                    case "add":
                        break;
                    case "remove":
                        break;
                    case "list":
                        for (int i = 0; i < tasksLinesElements.length; i++) {
                            System.out.print(i + " : ");
                            for (int j = 0; j < tasksLinesElements[i].length; j++) {
                                System.out.print(tasksLinesElements[i][j] + " ");
                            }
                            System.out.println();
                        }
                        break;
                    case "exit":
                        break;
                    default:
                        System.out.println("Type right option!");

                }
            }
        }
        }




