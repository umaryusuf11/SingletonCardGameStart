package BlackJack;

import Player.Player;

public class ReadyToPlayState implements PlayerState{

    private static ReadyToPlayState uniqueReadyToPlayState = null;

    private ReadyToPlayState(){}

    public static ReadyToPlayState getInstance() {
        if (uniqueReadyToPlayState == null) {
            uniqueReadyToPlayState = new ReadyToPlayState();
        }
        return uniqueReadyToPlayState;
    }

    public void setState(BlackJack game, Player player, BlackJackAction action) {
        action = game.getPlayerAction(player);
        PlayerState state = this;
        if (action == BlackJackAction.TWIST) {
            state = TwistState.getInstance();
        } else if (action == BlackJackAction.STICK){
            state = StickState.getInstance();
        } else if ( action == BlackJackAction.END){
            state = EndState.getInstance();
        }
        else {
            game.userOutput.output("Please select a different action");
        }
        game.setPlayerState(state, player, action);
    }

    public BlackJackAction getState(){
        return BlackJackAction.READY_TO_PLAY;
    }
}
