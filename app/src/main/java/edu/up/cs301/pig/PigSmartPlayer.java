package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

public class PigSmartPlayer extends GameComputerPlayer {

    public PigSmartPlayer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        //Log.i("msg", "Part 1");
        if(info instanceof PigGameState) {
            PigGameState gameStateCopy = new PigGameState((PigGameState)info);

            if (gameStateCopy.getCurrentPlayerID() != this.playerNum) {
                //Log.i("msg", "Part 3");
                return;
            } else {
                if(this.playerNum == 0) {
                    if(gameStateCopy.getPlayer0Score() + gameStateCopy.getCurrentRunningTotal() >= 50) {
                        this.game.sendAction(new PigHoldAction(this));
                        return;
                    } else if (gameStateCopy.getCurrentRunningTotal() == 0){
                        this.game.sendAction(new PigRollAction(this));
                        return;
                    }  else if(gameStateCopy.getPlayer1Score() >= 45) {
                        this.game.sendAction(new PigRollAction(this));
                        return;
                    }  else if (gameStateCopy.getCurrentRunningTotal() >= 15) {
                        this.game.sendAction(new PigHoldAction(this));
                        return;
                    } else {
                        this.game.sendAction(new PigRollAction(this));
                        return;
                    }
                } else {
                    if(gameStateCopy.getPlayer1Score() + gameStateCopy.getCurrentRunningTotal() >= 50) {
                        this.game.sendAction(new PigHoldAction(this));
                        return;
                    } else if (gameStateCopy.getCurrentRunningTotal() == 0){
                        this.game.sendAction(new PigRollAction(this));
                        return;
                    } else if(gameStateCopy.getPlayer0Score() >= 45) {
                        this.game.sendAction(new PigRollAction(this));
                        return;
                    } else if (gameStateCopy.getCurrentRunningTotal() >= 15) {
                        this.game.sendAction(new PigHoldAction(this));
                        return;
                    } else {
                        this.game.sendAction(new PigRollAction(this));
                        return;
                    }
                }

            }
        }

    }//receiveInfo
}
