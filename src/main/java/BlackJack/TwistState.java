package BlackJack;

import Player.Player;

public class TwistState implements PlayerState {

    private static TwistState uniqueTwistState = null;

    private TwistState(){}

    public static TwistState getInstance(){
        if (uniqueTwistState == null) {
            uniqueTwistState = new TwistState();
        }
        return uniqueTwistState;
    }

    public void setState(BlackJack game, Player player, BlackJackAction action) {
        player.getHand().add(game.getDeck().playACard());
        PlayerState state = this;
        if (game.getScore(player.getHand()) > game.maxScore){
            state = EndState.getInstance();
        }
        else {
            state = ReadyToPlayState.getInstance();
        }
        game.setPlayerState(state, player, action);
    }

    public BlackJackAction getState(){
        return BlackJackAction.TWIST;
    }

}
