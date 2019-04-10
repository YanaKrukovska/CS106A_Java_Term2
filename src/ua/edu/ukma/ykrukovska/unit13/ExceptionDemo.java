package ua.edu.ukma.ykrukovska.unit13;

import java.io.File;

public class ExceptionDemo {
    private final static String FOLDER = "C:\\IdeaProjects\\Files\\";

    public static void main(String[] args) {
        try {
            openFile();
        } catch (TooBigFileException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void openFile() throws TooBigFileException {
        File file = new File(FOLDER + "Text1.txt");

        if (file.length() > 100000) {
            throw new TooBigFileException(file.length());
        }
    }
}
