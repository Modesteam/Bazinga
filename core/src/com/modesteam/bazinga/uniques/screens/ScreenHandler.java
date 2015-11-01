package com.modesteam.bazinga.uniques.screens;

import com.badlogic.gdx.Screen;
import com.modesteam.bazinga.uniques.Bazinga;

public class ScreenHandler {

	private ScreenType currentScreenType;
	private MainMenuScreen mainMenuScreen;
	private HowToPlayScreen howToPlayScreen;
	private GameScreen gameScreen;
	private ExitScreen exitScreen;

	public ScreenHandler(Bazinga game) {

		get(ScreenType.MAIN_MENU, game);
	}

	public ScreenType getCurrentScreenType() {

		return currentScreenType;
	}


	public Screen get(ScreenType screenType, Bazinga game) {

		Screen screen;

		switch (screenType) {
			case MAIN_MENU:
				screen = getMainMenuScreen(game);
				break;
			case HOW_TO_PLAY:
				screen = getHowToPlayScreen(game);
				break;
			case GAME_SCREEN:
				screen = getGameScreen(game);
				break;
			case EXIT_SCREEN:
				screen = getExitScreen(game);
				break;
			default:
				screen = getMainMenuScreen(game);
		}

		return screen;
	}

	private MainMenuScreen getMainMenuScreen(Bazinga game) {

		if (mainMenuScreen == null) {
			mainMenuScreen = new MainMenuScreen(game);
		}

		currentScreenType = ScreenType.MAIN_MENU;

		return mainMenuScreen;
	}

	private HowToPlayScreen getHowToPlayScreen(Bazinga game) {

		if (howToPlayScreen == null) {
			howToPlayScreen = new HowToPlayScreen(game);
		}

		currentScreenType = ScreenType.HOW_TO_PLAY;

		return howToPlayScreen;
	}

	private GameScreen getGameScreen(Bazinga game) {

		if (gameScreen == null) {
			gameScreen = new GameScreen(game);
		}

		currentScreenType = ScreenType.GAME_SCREEN;

		return gameScreen;
	}

	private ExitScreen getExitScreen(Bazinga game) {

		if (exitScreen == null) {
			exitScreen = new ExitScreen(game);
		}

		currentScreenType = ScreenType.EXIT_SCREEN;

		return exitScreen;
	}
}
