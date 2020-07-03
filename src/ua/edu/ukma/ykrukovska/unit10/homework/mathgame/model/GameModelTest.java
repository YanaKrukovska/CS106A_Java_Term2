package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model;

import org.junit.Test;

public class GameModelTest {

    @Test
    public void generateTasks() {

        GameModel gameModel = new GameModel();
        Task[] tasks = gameModel.generateTasks(100, 5);
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(tasks[i].toString());

        }

    }
}