package ua.edu.ukma.ykrukovska.unit4.practice;

public class CaesarCipher {

    private String line;

    public void saveString(String line) {
        this.line = line;
    }

    public String encode(int shift) {

        if (line == null || line.length() == 0) {
            throw new IllegalStateException("Line to encode is not specified");
        }

        String result = "";
        for (int pos = 0; pos < line.length(); pos++) {
            int c = line.charAt(pos) + shift;

            if (c > 126) {
                c -= 95;
            } else if (c < 32) {
                c += 95;
            }
            result += (char) c;
        }
        return result;
    }
}
