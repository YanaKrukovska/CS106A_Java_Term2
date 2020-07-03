package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.controller;

import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model.GameModel;
import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.view.GameView;

public class GameController {

    private GameModel gameModel = new GameModel();
    private GameView view;

    public GameController() {
        view = new GameView(this, gameModel);
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();
    }

    public int checkIfInputIsNumber(String input) {
        int number;
        try {
            number = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return -1;
        }
        return number;
    }
}
