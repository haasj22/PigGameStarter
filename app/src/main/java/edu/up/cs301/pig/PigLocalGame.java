package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    PigGameState officialGameState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        officialGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(officialGameState.getCurrentPlayerID() == playerIdx) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigHoldAction) {
            if(officialGameState.getCurrentPlayerID() == 0) {
                officialGameState.setPlayer0Score(officialGameState.getPlayer0Score()
                        + officialGameState.getCurrentRunningTotal());
                officialGameState.setCurrentRunningTotal(0);
                if (players.length > 1 ) {
                    officialGameState.setCurrentPlayerID(1);
                }
            } else {
                officialGameState.setPlayer1Score(officialGameState.getPlayer1Score()
                        + officialGameState.getCurrentRunningTotal());
                officialGameState.setCurrentRunningTotal(0);
                officialGameState.setCurrentPlayerID(0);
            }
            return true;
        }
        if(action instanceof PigRollAction) {
            int dieVal = (int)(Math.random() * 6) + 1;
            officialGameState.setCurrentDieValue(dieVal);
            if(dieVal != 1) {
                officialGameState.setCurrentRunningTotal(officialGameState.getCurrentRunningTotal() + dieVal);
            } else {
                officialGameState.setCurrentRunningTotal(0);
                if (players.length > 1 ) {
                    officialGameState.setCurrentPlayerID((officialGameState.getCurrentPlayerID() + 1) % 2);
                }
            }
            return true;
        }
            return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new PigGameState(officialGameState));
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(officialGameState.getPlayer0Score() >= 50 || officialGameState.getPlayer1Score() >= 50) {
            if(officialGameState.getPlayer0Score() >= 50) {
                return "Player 0 wins with a score of " + officialGameState.getPlayer0Score();
            } else {
                return "Player 1 wins with a score of " + officialGameState.getPlayer1Score();
            }
        }
        return null;
    }

}// class PigLocalGame
