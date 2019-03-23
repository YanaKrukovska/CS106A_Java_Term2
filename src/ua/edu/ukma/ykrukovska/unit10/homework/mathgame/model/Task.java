package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model;

public class Task {


    private int a;
    private int b;
    private int c;
    private int d;
    private int result;
    private char action1;
    private char action2;
    private char action3;

    public Task(int a, int b, int c, int d, int result, char action1, char action2, char action3) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.result = result;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
    }


    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public int getResult() {
        return result;
    }

    public char getAction1() {
        return action1;
    }

    public char getAction2() {
        return action2;
    }

    public char getAction3() {
        return action3;
    }
}

