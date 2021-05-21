package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String[][] tasksLinesElements1;

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
                      //  Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Please add task description");
                        String description = scanner.nextLine();
                        System.out.println("Please add task due date");
                        String dueDate = scanner.nextLine();
                        System.out.println("Is your task important: true/false");
                        String important = scanner.nextLine();
                        tasksLinesElements = Arrays.copyOf(tasksLinesElements, tasksLinesElements.length+1);
                        tasksLinesElements[tasksLinesElements.length-1] = new String[3];
                        tasksLinesElements[tasksLinesElements.length-1][0] = description;
                        tasksLinesElements[tasksLinesElements.length-1][1] = dueDate;
                        tasksLinesElements[tasksLinesElements.length-1][2] = important;
                       // System.out.println(Arrays.deepToString(tasksLinesElements));
                       // scanner.close();
                        break;
                    case "remove":
                        System.out.println("Please select number to remove");
                        String numberToRemove = scanner.nextLine();
                        Integer numberToRemoveChanged = Integer.parseInt(numberToRemove);
                        if (numberToRemoveChanged < tasksLinesElements.length) {
                            tasksLinesElements = ArrayUtils.remove(tasksLinesElements, numberToRemoveChanged);
                        }
                        break;
                    case "list":
                        for (int i = 0; i < tasksLinesElements.length; i++) {
                            System.out.print(i + " : ");
                            for (int j = 0; j < tasksLinesElements[i].length; j++) {
                                System.out.print(tasksLinesElements[i][j] + " ");
                            }
                            System.out.println();
                        }
                       // scanner.close();
                        break;
                    case "exit":
                        String[] lines = new String[tasksLinesElements.length];
                        for (int i = 0; i < tasksLinesElements.length; i++) {
                            lines[i] = String.join(",", tasksLinesElements[i]);
                            try {
                                Files.write(pathTasks, Arrays.asList(lines), StandardOpenOption.TRUNCATE_EXISTING);
                            } catch (IOException e) {
                                e.printStackTrace();
                                System.out.println("There is some problem with saving file!");
                            }
                            System.out.println(ConsoleColors.RED + "Bye, bye.");
                            System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("Type right option!");

                }
            }
        }
        }




