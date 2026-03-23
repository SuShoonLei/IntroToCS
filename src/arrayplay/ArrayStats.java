/*
 * Program featuring an array to store, manipulate, and compute stats about a list of numbers.
 */

package arrayplay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayStats {

    private static int[ ] numbers = new int[10];
    private static int numberOfNumbers = 0;
    private static boolean sorted = false;

    public static void main(String[] args) {
        try {
            readNumbers();
            interpreter(new Scanner(System.in));
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found. Please think again.");
            System.exit(-1);
        }
    }

    private static void interpreter(Scanner commandReader) {
        System.out.print(">>> ");
        String command = commandReader.next();
        if (command.equalsIgnoreCase("DISPLAY")) {
            interpreterDisplayCommand();
        } else if (command.equalsIgnoreCase("SORT")) {
            interpretSortCommand();
        } else if (command.equalsIgnoreCase("ADD")) {
            interpretAddCommand(commandReader);
        } else if (command.equalsIgnoreCase("MIN")) {
            interpretMinCommand();
        } else if (command.equalsIgnoreCase("MAX")) {
            interpretMaxCommand();
        } else if (command.equalsIgnoreCase("AVG")) {
            interpretAvgCommand();
        } else if (command.equalsIgnoreCase("MEDIAN")) {
            interpretMedianCommand();
        } else if (command.equalsIgnoreCase("HELP")) {
            interpretHelpCommand();
        } else if (command.equalsIgnoreCase("EXIT")) {
            System.exit(0);
        } else {
            System.out.println("### Unrecognizable command: " + command);
        }
        interpreter(commandReader);
    }

    private static void interpreterDisplayCommand() {
        displayNumbers();
    }

    private static void interpretAddCommand(Scanner commandReader) {
        int value = 0;
        try {
            value = commandReader.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You didn't enter an integer value to add.");
            return;
        }
        ensureCapacity();
        numbers[numberOfNumbers] = value;
        numberOfNumbers++;
        sorted = false;
    }

    private static void interpretSortCommand() {
        bubbleSort();
    }

    private static void interpretHelpCommand() {
        System.out.println("HELP - display a menu of commands");
        System.out.println("DISPLAY - display the list of numbers");
        System.out.println("SORT - sort the numbers");
        System.out.println("ADD - add a number to the end of the list");
        System.out.println("MIN - print the minimum value, requires a sorted list");
        System.out.println("MAX - print the maximum value, requires a sorted list");
        System.out.println("AVG - print the average value");
        System.out.println("MEDIAN - print the median value");
        System.out.println("EXIT - terminate execution of the program");
    }

    private static void interpretMinCommand() {
        if (numberOfNumbers == 0) {
            System.out.println("There are no numbers, so there is no minimum.");
            return;
        }
        if (!sorted) {
            System.out.println("The list isn't sorted, please sort first.");
            return;
        }
        System.out.println("MIN: " + numbers[0]);
    }

    private static void interpretMaxCommand() {
        if (numberOfNumbers == 0) {
            System.out.println("There are no numbers, so there is no maximum.");
            return;
        }
        if (!sorted) {
            System.out.println("The list isn't sorted, please sort first.");
            return;
        }
        System.out.println("MAX: " + numbers[numberOfNumbers - 1]);
    }

    private static void interpretAvgCommand() {
        if (numberOfNumbers == 0) {
            System.out.println("There are no numbers, so there is no average.");
            return;
        }
        double sum = 0;
        for (double number: numbers){
            sum = sum+ number;
        }
        double avg = (sum/numberOfNumbers);
        System.out.println(avg);
    }

    private static void interpretMedianCommand() {
        if (numberOfNumbers == 0) {
            System.out.println("There are no numbers, so there is no median.");
            return;
        }
        double median;
        if (sorted) {
            if (numberOfNumbers % 2 == 0) {
                median = (numbers[numberOfNumbers / 2 - 1] + numbers[numberOfNumbers / 2]) / 2.0;
            } else {
                median = numbers[numberOfNumbers / 2];
            }
            System.out.println("MEDIAN: " + median);
        } else {
            System.out.println("The list isn't sorted, please sort first.");
        }
    }

    private static void displayNumbers() {
        for (int x = 0; x < numberOfNumbers; x++) {
            System.out.println(numbers[x]);
        }
    }

    private static Scanner establishScanner(String fileName) throws FileNotFoundException {
        String separator = File.separator;
        String homeDirectory = System.getProperty("user.home");
        String path = homeDirectory + separator + "public_html" + separator + "data" + separator;
        String fullFileName = path + fileName;
        System.out.println(fullFileName);
        return new Scanner(new File(fullFileName ));
    }

    private static void readNumbers() throws FileNotFoundException {
        Scanner scanner = establishScanner("NumberSet.txt");
        while (scanner.hasNext()) {
            ensureCapacity();
            numbers[numberOfNumbers] = scanner.nextInt();
            numberOfNumbers++;
        }
    }

    private static void ensureCapacity() {
        if (numberOfNumbers == numbers.length) {
            numbers = Arrays.copyOf(numbers, numbers.length * 2);
        }
    }

    private static void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static void bubbleSort() {
        for (int i = 0; i < numberOfNumbers; i++) {
            for (int j = 1; j < (numberOfNumbers - i); j++) {
                if (numbers[j - 1] > numbers[j]) {
                    swap(j, j - 1);
                }
            }
        }
        sorted = true;
    }
}