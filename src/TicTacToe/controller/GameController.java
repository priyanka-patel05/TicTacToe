package TicTacToe.controller;

import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;
import TicTacToe.strategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startgame(
        int dimension,
        List<Player> players ,
        List<WinningStrategy> winningStrategies
        ) {
        return new Game();
    }
    public GameState checkState(Game game){
        return null;

    }
    public void makeMove(Game game){

    }
    public void display (Game game) {
        return game.getdisplay();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void Undo(){


    }
}
