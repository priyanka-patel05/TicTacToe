package TicTacToe.models;

import TicTacToe.strategies.BotPlayingStrategy;
import TicTacToe.strategies.BotPlayingStrategyFactory;

public class BotPlayer extends Player {
    private BotDifficultyLevel difficultylevel;
    private BotPlayingStrategy botPlayingStrategy;


    //constructor for botplayer
    public BotPlayer(int id,String name,PlayerType playertype,Symbol symbol,BotDifficultyLevel difficultylevel){
        //super keyword :to access methods of immediate parent class
        super(id,name,playertype,symbol);
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultylevel);
        this.difficultylevel = difficultylevel;
    }

    @Override
    public Move makeMove(Board board){
        return botPlayingStrategy.makeMove(board);
    }
}
