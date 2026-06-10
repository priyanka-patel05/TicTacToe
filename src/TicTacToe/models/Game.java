package TicTacToe.models;

import TicTacToe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private int nextPlayerIndex;
    private List<Move> moves;
    private GameState gameState;
    private List<WinningStrategy> WinningStrategies;

    //private obj of builder so that nobody can create game obj directly.
    private Game (Builder builder){
        Board b = new Board(builder.dimension);
        players = builder.players;
        WinningStrategies = builder.winningStrategies;
        winner = null;
        nextPlayerIndex = 0;
        moves = new ArrayList<>();
        gameState = GameState.IN_PROGRESS;

    }

    public Board getBoard() {

        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return WinningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        WinningStrategies = winningStrategies;
    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public void displayBoard(){
        board.display();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public void validate(){
            //check player count
            if(players.size()!=dimension-1){
                throw new RuntimeException("invalid player count");

            }
            //we wnat only one bot in the game
            int botCount = 0;
            for (Player player:players)
            {
            if(player.getPlayerType().equals(PlayerType.BOT))
            {
            botCount++;
            }
            }
            if (botCount>1){
                throw new RuntimeException("more than one bot is not allowed");

            }
            //3.every player should have a separate symbol
            Set<Character> symbolSet = new java.util.HashSet<>();
            for(Player player:players){
                if(symbolSet.contains(player.getSymbol().getSym())){
                    throw new RuntimeException("multiple players have same symbol");
                }
                symbolSet.add(player.getSymbol().getSym());
            }
        }
        //build method
        public Game build(){
            //validation
            validate();
            return new Game(this);
        }
    }
}
