package ua.edu.ukma.ykrukovska.numeral_systems;

import java.io.IOException;

public class NumeralSystems {

    public static void main(String[] args) throws IOException {
        System.out.println("Insert p (source system)(from 2 to 16): ");

        int sourceSystem = DataInputUtil.getInt();
        if (sourceSystem < 2 || sourceSystem > 16) {
            do {
                System.out.println("source system must be from 2 to 16. Insert sourceSystem:");
                sourceSystem = DataInputUtil.getInt();
            } while (sourceSystem < 2 || sourceSystem > 16);
        }

        System.out.println("Insert N: ");
        String sourceValue = DataInputUtil.getString();
        if (!validateNumeralSystem(sourceSystem, sourceValue)) {
            do {
                System.out.println("Number is not valid. Try again: ");
                sourceValue = DataInputUtil.getString();
            } while (!validateNumeralSystem(sourceSystem, sourceValue));
        }

        System.out.println("Insert q (destination system) (from 2 to 16): ");
        int destinationSystem = DataInputUtil.getInt();
        if (destinationSystem < 2 || destinationSystem > 16) {
            do {
                System.out.println("q must be from 2 to 16. Insert q:");
                destinationSystem = DataInputUtil.getInt();
            } while (destinationSystem < 2 || destinationSystem > 16);
        }
        System.out.println("Result = " + convertToSystem(sourceValue, sourceSystem, destinationSystem));
    }


    public static String convertToSystem(String sourceValue, int sourceSystem, int destinationSystem) {
        String result = "";
        int convertedToTen = convertToTen(sourceValue, sourceSystem);

        int temporary;

        while (convertedToTen > 0) {
            temporary = convertedToTen % destinationSystem;
            result = digitToChar(temporary) + result;
            convertedToTen = convertedToTen / destinationSystem;
        }

        return result;
    }

    public static int convertToTen(String number, int system) {
        int result = 0;
        int power = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            result += convertCharToInt(number.charAt(i)) * (int) Math.pow(system, power++);

        }

        return result;
    }

    private static char digitToChar(int digit) {
        switch (digit) {
            case 0:
                return '0';
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
            default:
                return ' ';
        }
    }

    private static int convertCharToInt(char symbol) {
        switch (symbol) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
            case 'a':
                return 10;
            case 'B':
            case 'b':
                return 11;
            case 'C':
            case 'c':
                return 12;
            case 'D':
            case 'd':
                return 13;
            case 'E':
            case 'e':
                return 14;
            case 'F':
            case 'f':
                return 15;
            default:
                throw new IllegalArgumentException("Wrong symbol");
        }
    }

    public static boolean validateNumeralSystem(int system, String number) {
        boolean result = true;
        char[] symbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < number.length(); i++) {
            for (int j = system; j < symbols.length; j++) {
                if (number.charAt(i) == symbols[j]) {
                    return false;
                }
            }
        }
        return result;
    }

}






