package model;

public class Choice {

	public enum Option {
		PEDRA, TESOURA, LAGARTO, PAPEL, SPOCK
	}

	private Option currentChoice;
	private Player player;

	protected Choice(Player player) {
		this.currentChoice = Option.PEDRA;
		this.player = player;
	}

	protected Option getCurrentChoice() {
		return this.currentChoice;
	}

	protected void setCurrentChoice(Option choice) {
		this.currentChoice = choice;
	}

	protected void updatePlayer(Player player) {
		this.player = player;
	}
}
