package BlackJack;

import Player.Player;

public class EndState implements PlayerState {

    public void setState(BlackJack game, Player player, BlackJackAction action){
        game.determineWinner(game.players);
        if (action != BlackJackAction.END){
            game.showPlayers();
            game.resetPlayers();
            game.dealCards();
            game.setPlayerState(new ReadyToPlayState(), player, action);
        }
    }

    public BlackJackAction getState(){
        return BlackJackAction.END;
    }
}
