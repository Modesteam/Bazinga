package model;

import java.util.Vector;

public class Game {

	public enum PlayerName {
		PLAYER_ONE, PLAYER_TWO, NO_ONE
	}

	private final int P_ONE_INDEX = 0;
	private final int P_TWO_INDEX = 1;

	private Vector<Player> players;
	private PlayerName playersTurn;

	public Game() {
		players = new Vector<Player>(2);
		setStandardValues();
	}

	private void setStandardValues() {
		Player playerOne = new Player(this);
		this.players.add(this.P_ONE_INDEX, playerOne);

		Player playerTwo = new Player(this);
		this.players.add(this.P_TWO_INDEX, playerTwo);

		this.playersTurn = PlayerName.PLAYER_TWO;
	}

	public PlayerName getCurrentPlayer() {
		return this.playersTurn;
	}

	protected void setPlayersChoice(PlayerName player, Choice.Option choice) {
		switch(player) {
			case PLAYER_ONE:
				players.elementAt(P_ONE_INDEX).newChoice(choice);
				break;
			case PLAYER_TWO:
				players.elementAt(P_TWO_INDEX).newChoice(choice);
				break;
			default:
				// TODO THROW UNEXPECTED REFERENCE OF PLAYER EXCEPTION
		}
	}

	private PlayerName setWinningPlayer() {
		PlayerName winner = PlayerName.NO_ONE;

		Boolean isPlayerOneTheWinner = players.elementAt(P_ONE_INDEX).
				compareChoices(players.elementAt(P_TWO_INDEX));
		Boolean isPlayerTwoTheWinner = players.elementAt(P_TWO_INDEX).
				compareChoices(players.elementAt(P_ONE_INDEX));
		if(!isPlayerOneTheWinner && !isPlayerTwoTheWinner) {
			winner = PlayerName.NO_ONE;
		}
		else if(isPlayerOneTheWinner) {
			winner = PlayerName.PLAYER_ONE;
			setVictory(PlayerName.PLAYER_ONE);
		}
		else if(isPlayerTwoTheWinner) {
			winner = PlayerName.PLAYER_TWO;
			setVictory(PlayerName.PLAYER_TWO);
		}

		return winner;
	}

	private void setVictory(PlayerName player) {
		switch(player) {
			case PLAYER_ONE:
				players.elementAt(P_ONE_INDEX).incrementVictory();
				break;

			case PLAYER_TWO:
				players.elementAt(P_TWO_INDEX).incrementVictory();
				break;

			default:
				// TODO THROW UNEXPECTED REFERENCE OF PLAYER EXCEPTION

		}
	}

	public void cleanGame() {
		players.clear();
		setStandardValues();
	}
}
