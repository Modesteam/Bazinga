package model;

public class Player {

	private Choice currentChoice;
	private Integer quantityOfVictories;
	private Game game;

	protected Player(Game game) {
		this.currentChoice = new Choice(this);
		this.quantityOfVictories = 0;
		this.game = game;
	}

	protected Boolean compareChoices(Player otherPlayer) {
		return currentChoice.compareChoice(otherPlayer.getCurrentChoice());
	}

	protected Choice.Option getCurrentChoice() {
		return this.currentChoice.getCurrentChoice();
	}

	protected void newChoice(Choice.Option newChoice) {
		this.currentChoice.setCurrentChoice(newChoice);
	}

	protected Integer getVictories() {
		return this.quantityOfVictories;
	}

	protected void incrementVictory() {
		this.quantityOfVictories = quantityOfVictories+1;
	}

	protected void updateGame(Game game) {
		this.game = game;
	}
}