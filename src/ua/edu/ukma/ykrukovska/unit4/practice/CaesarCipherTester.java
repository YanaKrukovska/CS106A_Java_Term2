package ua.edu.ukma.ykrukovska.unit4.practice;

import java.io.IOException;

import static ua.edu.ukma.ykrukovska.unit4.practice.DataInput.getInt;
import static ua.edu.ukma.ykrukovska.unit4.practice.DataInput.getString;

public class CaesarCipherTester {

    public static void main(String[] args) throws IOException {

        CaesarCipher encoder = new CaesarCipher();
        System.out.println(("Line to encode: "));
        String lineToEncode = getString();
        encoder.saveString(lineToEncode);
        System.out.println("Insert shift: ");
        int shift = getInt();

        System.out.println("Encoded line: " + encoder.encode(shift));
    }
}
