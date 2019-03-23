package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model;

public class Game {

    private int correctAnswers;
    private int incorrectAnswers;
    private int maxNumber;
    private int taskAmount;
    Task[] tasks;


    public Task[] generateTasks(int maxNumber, int taskAmount) {
        this.maxNumber = maxNumber;
        this.taskAmount = taskAmount;
        tasks = new Task[taskAmount];

        for (int i = 0; i < taskAmount; i++) {
            tasks[i] = new Task(5,1,2,3,11,'+','+','+');
        }
        return tasks;
    }
}
