package ua.edu.ukma.ykrukovska.unit13;

public class TooBigFileException extends Exception {

    public TooBigFileException(long fileSize) {
        super("File is too big. It's size = " + fileSize);
    }
}
