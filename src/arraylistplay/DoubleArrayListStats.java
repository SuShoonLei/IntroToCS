/*
 * Program featuring an array to store, manipulate, and compute stats about a list of numbers.
 */

package arraylistplay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DoubleArrayListStats {

    // Initially, we will assume we're only reading 10 numbers.
    private static ArrayList<Double> numbers = new ArrayList<Double>( 10);
    private static int numberOfNumbers = 0;
    private static boolean sorted = false;

    public static void main(String[] args) {
        try {
            readNumbers();
            //displayNumbers(); // Uncomment this to check that your numbers are reading right!
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
            intepretMaxCommand();
        } else if (command.equalsIgnoreCase("MED")) {
            intepretMedCommand();
        } else if (command.equalsIgnoreCase("AVG")) {
            intepretAvgCommand();
        } else if (command.equalsIgnoreCase("HELP")) {
            interpretHelpCommand();
        } else if (command.equalsIgnoreCase("EXIT")) {
            System.exit(0);
        }else {
            System.out.println("### Unrecognizable command: " + command);
        }
        interpreter(commandReader);
    }

    private static void intepretMedCommand() {
        if (numberOfNumbers == 0) {
            System.out.println("There are no numbers, so there is no medium.");
            return;
        }
        if (!sorted) {
            System.out.println("The list isn't sorted, please sort first.");
            return;
        }
        double med =0;
        if (numberOfNumbers %2 ==0){
            med = ((numbers.get(((numberOfNumbers - 1) / 2)) + numbers.get((numberOfNumbers / 2)))/2.0);
        } else {
            med = (numbers.get((numberOfNumbers) / 2));
        }
        System.out.println(med);
    }

    private static void intepretAvgCommand() {
        if (numberOfNumbers == 0) {
            System.out.println("There are no numbers, so there is no average.");
            return;
        }
        double sum = 0;
        for (double number: numbers){
            sum = sum+ number;
        }
        double avg = ( sum/numberOfNumbers);
        System.out.println(avg);
    }

    private static void intepretMaxCommand() {
        if (numberOfNumbers == 0) {
            System.out.println("There are no numbers, so there is no maximum.");
            return;
        }
        if (!sorted) {
            System.out.println("The list isn't sorted, please sort first.");
            return;
        }
        System.out.println(numbers.get(numberOfNumbers - 1));
    }


    private static void interpreterDisplayCommand() {
        displayNumbers();
    }

    private static void interpretAddCommand(Scanner commandReader) {
        double value = 0;
        try {
            value = commandReader.nextDouble();
        } catch(InputMismatchException e) {
            System.out.println("You didn't enter an double value to add.");
            return;
        }
        numbers.add(value);
        numberOfNumbers = numberOfNumbers + 1;
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
        System.out.println("MED - print the medium value, requires a sorted list");
        System.out.println("MAX - print the maximum value, requires a sorted list");
        System.out.println("AVG - print the average value");
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
        System.out.println(numbers.get(0));
    }

    private static void displayNumbers() {
        for (int x = 0; x < numberOfNumbers; x = x + 1) {
            System.out.println(numbers.get(x));
        }
    }

    // Assuming that the data file will be found in the public_html/data
    // subdirectory of the user’s home directory.
    private static Scanner establishScanner(String fileName) throws FileNotFoundException {
        String separator = File.separator;
        String homeDirectory = System.getProperty("user.home");
        String path = homeDirectory + separator + "public_html" + separator + "data" + separator;
        String fullFileName = path + fileName;
        System.out.println(fullFileName);
        return new Scanner(new File(fullFileName));
    }

    private static void readNumbers() throws FileNotFoundException {
        Scanner scanner = establishScanner("DoubleSet.txt");
        while (scanner.hasNext()) {
            numbers.add(numberOfNumbers, scanner.nextDouble());
            numberOfNumbers += 1;
        }
    }

    // Ensures the numbers array has room for a next element.
    // If not, it makes a new array twice the size,
    // and copies over the old array to the new one.



    private static void swap(int i, int j){
        double temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }

    private static void bubbleSort(){
        for(int i = 0; i < numberOfNumbers; i = i + 1){
            for(int j = 1; j < (numberOfNumbers - i); j = j + 1){
                if(numbers.get(j - 1) > numbers.get(j)){
                    swap(j, j-1);
                }
            }
        }
        sorted = true;
    }

}