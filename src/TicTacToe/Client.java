package TicTacToe;

import TicTacToe.controller.GameController;
import TicTacToe.models.*;
import TicTacToe.strategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        GameController gc = new GameController();
        //Game g = gc.startgame();
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1,"Aman", PlayerType.HUMAN,new Symbol('0')));
        players.add(new BotPlayer(2,"Bot",PlayerType.BOT,new Symbol('X'),BotDifficultyLevel.EASY));


        Game game =gc.startgame(3,
                players,
                List.of(new RowWinningStrategy()));


        //Game g2 = gc.startgame();
        gc.display(game);
        while(gc.checkState(game).equals(GameState.IN_PROGRESS)){
            gc.makeMove(game);
            gc.display(game);

            System.out.println("do you want to udo?[Y/N]");
            String undoAnswer = scn.nextLine();
            if(undoAnswer.equals("Y")) {
                gc.Undo(game);
                System.out.println("Undo is successfull!");
                gc.display(game);
            }
        }

        if(gc.checkState(game).equals(GameState.SUCCESS)){
            System.out.println(gc.getWinner(game).getName() +"won the game");
        }else if(gc.checkState(game).equals(GameState.DRAW)){
            System.out.println("game results in draw");
        }

    }

}
