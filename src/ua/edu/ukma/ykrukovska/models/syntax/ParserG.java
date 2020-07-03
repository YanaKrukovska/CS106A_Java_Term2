package ua.edu.ukma.ykrukovska.models.syntax;

public class ParserG {

    /* S -> abС
     * A -> aAb | d
     * B -> bD
     * C -> ABd | b
     * D -> cAD | e
     */

    private Letter input;
    private char next;

    public static void main(String[] args) {

        String[] st = new String[]{""};
        ParserG g = new ParserG();
        for (int i = 0; i < st.length; i++)
            System.out.println("... " + st[i] + " analys: " + g.analys(st[i]));
    }

    void S() throws SyntaxError {
        if (next == 'a') {
            next = input.nextChar();
            match('b');
            next = input.nextChar();
            C();
        }
    }

    private void A() throws SyntaxError {
        if (next == 'a') {
            next = input.nextChar();
            A();
            match('b');
        } else match('d');
    }

    void C() throws SyntaxError {
        if (next == 'A') {
            A();
            B();
            match('d');

        } else match('b');
    }

    private void B() throws SyntaxError {
        if (next == 'b') {
            next = input.nextChar();
            D();
        }
    }

    private void D() throws SyntaxError {
        if (next == 'C') {
            next = input.nextChar();
            match('c');
            A();
            D();
        } else match(' ');
    }

    public ParserG() {
        analys("a");
    }

    public boolean analys(String word) {
        input = new Letter(word);
        try {
            next = input.nextChar();
            S();
            match('$');
        } catch (SyntaxError ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;

    }

    private void match(char c) throws SyntaxError {
        if (next == c) next = input.nextChar();
        else throw new SyntaxError("Expecting " + c + ", found " + next);
    }

}
