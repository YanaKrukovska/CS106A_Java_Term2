package ua.edu.ukma.ykrukovska.unit9.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputUtils {


    public static double getUserInput(double min, double max, String prompt) {
     Scanner scanner = new Scanner(System.in);
        System.out.println("Insert " + prompt);
        double userInput = scanner.nextDouble();

        if (userInput < min || userInput > max) {
            System.out.println("Wrong value of " + prompt);
            while (userInput < min && userInput > max) {
                System.out.println("Insert " + prompt);
                userInput = scanner.nextDouble();
            }
        }

        return userInput;
    }


    public static String getCorrectUserString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        boolean exitFlag = false;
        do {
            System.out.println("Insert: " + prompt);

            if (scanner.hasNextLine()) {
                userInput = scanner.nextLine();
            }
            if (userInput == null || userInput.length() == 0 || userInput.trim().length() == 0) {
                System.out.println("Wrong value of: " + prompt);
            } else {
                exitFlag = true;
            }
        } while (!exitFlag);
        return userInput;
    }


    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

}
