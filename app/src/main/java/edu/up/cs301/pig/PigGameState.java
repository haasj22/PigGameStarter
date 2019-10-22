package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    int currentPlayerID;
    int player0Score;
    int player1Score;
    int currentRunningTotal;
    int currentDieValue;

    public PigGameState() {
        currentPlayerID = 0;
        player0Score = 0;
        player1Score = 0;
        currentRunningTotal = 0;
        currentDieValue = 1;
    }

    public PigGameState(PigGameState original) {
        this.currentPlayerID = original.currentPlayerID;
        this.player0Score = original.player0Score;
        this.player1Score = original.player1Score;
        this.currentRunningTotal = original.currentRunningTotal;
        this.currentDieValue = original.currentDieValue;
    }

    public int getCurrentPlayerID() {
        return currentPlayerID;
    }

    public void setCurrentPlayerID(int currentPlayerID) {
        this.currentPlayerID = currentPlayerID;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getCurrentRunningTotal() {
        return currentRunningTotal;
    }

    public void setCurrentRunningTotal(int currentRunningTotal) {
        this.currentRunningTotal = currentRunningTotal;
    }

    public int getCurrentDieValue() {
        return currentDieValue;
    }

    public void setCurrentDieValue(int currentDieValue) {
        this.currentDieValue = currentDieValue;
    }
}
