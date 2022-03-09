package BlackJack;

import Player.Player;

public class StickState implements PlayerState {

    private static StickState uniqueStickState = null;

    private StickState(){}

    public static StickState getInstance(){
        if (uniqueStickState == null){
            uniqueStickState = new StickState();
        }
        return uniqueStickState;
    }

    public void setState(BlackJack game, Player player, BlackJackAction action){
        game.setPlayerState(EndState.getInstance(),  player, action);
    }

    public BlackJackAction getState(){
        return BlackJackAction.STICK;
    }
}
