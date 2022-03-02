package BlackJack;

import Player.Player;

public class TwistState {

    public static TwistState uniqueInstance = null;
    public static TwistState getInstance(){
        if (uniqueInstance == null){
            uniqueInstance =  new TwistState();
        }
        return uniqueInstance;
    }

    public void setState(BlackJack game, Player player, BlackJackAction action) {
        game.userOutput.output("Twist");
    }
    public BlackJackAction getState(){
        return null;
    }

}
