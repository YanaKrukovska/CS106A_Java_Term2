package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.controller;

import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model.Game;
import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model.Task;
import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.view.GameView;
import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.view.MathGameView;

public class GameController {

    private Game gameModel;
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
      } catch (NumberFormatException e){
          return -1;
      }
      return number;
    }



}
