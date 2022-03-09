package BlackJack;

import Player.Player;

public class EndState implements PlayerState {

    private static EndState uniqueEndState = null;

    private EndState(){}

    public static EndState getInstance(){
        if (uniqueEndState == null) {
            uniqueEndState = new EndState();
        }
        return uniqueEndState;
    }

    public void setState(BlackJack game, Player player, BlackJackAction action){
        game.determineWinner(game.players);
        if (action != BlackJackAction.END){
            game.showPlayers();
            game.resetPlayers();
            game.dealCards();
            game.setPlayerState(ReadyToPlayState.getInstance(), player, action);
        }
    }

    public BlackJackAction getState(){
        return BlackJackAction.END;
    }
}
