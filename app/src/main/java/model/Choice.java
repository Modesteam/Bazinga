package model;

import java.util.Vector;

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

	protected Boolean compareChoice(Option otherChoice) {
		Vector<Option> options = buildOptions();
		Boolean iWin = false;
		for(Integer myOption = 0; myOption < 5; myOption++) {
			if(currentChoice == options.elementAt(myOption)) {
				if(otherChoice == options.elementAt(myOption+1) ||
						otherChoice == options.elementAt(myOption+2)) {
					iWin = true;
				}
			}
		}
		return iWin;
	}

	private Vector<Option> buildOptions() {
		Vector<Option> options = new Vector<Option>(7);
		options.add(Option.PEDRA);
		options.add(Option.TESOURA);
		options.add(Option.LAGARTO);
		options.add(Option.PAPEL);
		options.add(Option.SPOCK);
		options.add(Option.PEDRA);
		options.add(Option.TESOURA);
		return options;
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
