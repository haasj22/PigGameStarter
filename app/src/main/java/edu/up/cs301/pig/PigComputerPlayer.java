package edu.up.cs301.pig;

import android.util.Log;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        //Log.i("msg", "Part 1");
       if(info instanceof PigGameState) {
           PigGameState gameStateCopy = new PigGameState((PigGameState)info);

           if (gameStateCopy.getCurrentPlayerID() != this.playerNum) {
               //Log.i("msg", "Part 3");
               return;
           } else {
                int rando = (int)(Math.random() * 2);
              // Log.i("msg", "Part 4");
                if(rando == 0) {
                    this.game.sendAction(new PigRollAction(this));
                } else {
                    this.game.sendAction(new PigHoldAction(this));
                }
           }
       }

    }//receiveInfo

}
