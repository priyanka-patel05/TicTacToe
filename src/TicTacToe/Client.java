package TicTacToe;

import TicTacToe.controller.GameController;
import TicTacToe.models.Game;

public class Client {
    public static void main(String[] args){
        GameController gc = new GameController();
        Game g = gc.startgame();

        Game g2 = gc.startgame();
        gc.makeMove(g);
    }

}
