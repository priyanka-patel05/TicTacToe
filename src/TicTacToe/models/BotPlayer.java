package TicTacToe.models;

public class BotPlayer extends Player {
    private BotDifficultyLevel difficultylevel;


    //constructor for botplayer
    public BotPlayer(int id,String name,PlayerType playertype,Symbol symbol,BotDifficultyLevel difficultylevel){
        //super keyword :to access methods of immediate parent class
        super(id,name,playertype,symbol);
        this.difficultylevel = difficultylevel;
    }
}
