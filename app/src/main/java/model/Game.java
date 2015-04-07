package model;

import java.util.ArrayList;

public class Game {

    private Player playerOne;
    private Player playerTwo;
    private GameLogger gameLog;

    public Game(Player playerOne, Player playerTwo) {

        setPlayerOne(playerOne);
        setPlayerTwo(playerTwo);

    }

    private Player getPlayerOne() {

        return this.playerOne;

    }

    private void setPlayerOne(Player playerOne) {

        this.playerOne = playerOne;

    }

    private Player getPlayerTwo() {

        return this.playerTwo;

    }

    private void setPlayerTwo(Player playerTwo) {

        this.playerTwo = playerTwo;

    }

    private ArrayList<Player> getPlayers() {

        ArrayList<Player> players = new ArrayList<Player>();

        players.add(getPlayerOne());
        players.add(getPlayerTwo());

        return players;

    }
}
