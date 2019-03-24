package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model;

import java.util.concurrent.ThreadLocalRandom;


public class GameModel {

    private int correctAnswers;
    private int incorrectAnswers;
    private int maxNumber;
    private int taskAmount;
    Task[] tasks;

    public Task[] generateTasks() {

        return generateTasks(maxNumber, taskAmount);
    }


    public Task[] generateTasks(int maxNumber, int taskAmount) {
        this.maxNumber = maxNumber;
        this.taskAmount = taskAmount;
        tasks = new Task[taskAmount];


        int randomNum;

        for (int i = 0; i < taskAmount; i++) {
            int result, a, b, c;
            char action1, action2;
            do {
                a = ThreadLocalRandom.current().nextInt(0, maxNumber + 1);
                action1 = (ThreadLocalRandom.current().nextInt(1, 3) == 1) ? '+' : '-';
                b = ThreadLocalRandom.current().nextInt(0, maxNumber + 1);
                action2 = (ThreadLocalRandom.current().nextInt(1, 3) == 1) ? '+' : '-';
                c = ThreadLocalRandom.current().nextInt(0, maxNumber + 1);

                result = calculateAnswer(a, action1, b, action2, c);
            } while (result > maxNumber || result < 0);
            tasks[i] = new Task(a, b, c, result, action1, action2);
        }

        return tasks;
    }

    private int calculateAnswer(int a, char action1, int b, char action2, int c) {

        int result = (action1 == '+') ? a + b : a - b;
        result = (action2 == '+') ? (result + c ): result - c;

        return result;
    }


    public int getTaskAmount() {
        return taskAmount;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void setTaskAmount(int taskAmount) {
        this.taskAmount = taskAmount;
    }

    public Task[] getTasks() {
        return tasks;
    }
}