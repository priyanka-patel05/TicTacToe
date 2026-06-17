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
        return Game.getBuilder().
        setDimension(dimension).
        setPlayers(players).
        setwinningStrategies(winningStrategies).build();
    }
    public GameState checkState(Game game){
        return game.getGameState();

    }
    public void makeMove(Game game){
        game.makeMove();


    }
    public void display (Game game) {
        game.displayBoard();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void Undo(Game game){
   game.undo();

    }
}
