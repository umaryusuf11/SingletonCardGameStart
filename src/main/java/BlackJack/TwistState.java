package BlackJack;

import Player.Player;

public class TwistState implements PlayerState {

    public void setState(BlackJack game, Player player, BlackJackAction action) {
        player.getHand().add(game.getDeck().playACard());
        PlayerState state = this;
        if (game.getScore(player.getHand()) > game.maxScore){
            state = new EndState();
        }
        else {
            state = new ReadyToPlayState();
        }
        game.setPlayerState(state, player, action);
    }

    public BlackJackAction getState(){
        return BlackJackAction.TWIST;
    }

}
