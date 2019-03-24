package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model;

public class Task {


    private int a;
    private int b;
    private int c;
    private int result;
    private char action1;
    private char action2;


    public Task(int a, int b, int c, int result, char action1, char action2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.result = result;
        this.action1 = action1;
        this.action2 = action2;

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



    public int getResult() {
        return result;
    }

    public char getAction1() {
        return action1;
    }

    public char getAction2() {
        return action2;
    }

    @Override
    public String toString() {
        return ""+a+action1+b+action2+c;
    }
}

