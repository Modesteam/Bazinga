package com.modesteam.bazinga.uniques.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.entities.text.LineTextEntity;
import com.modesteam.bazinga.entities.text.TextEntity;
import com.modesteam.bazinga.entities.text.types.ParagraphBound;
import com.modesteam.bazinga.entities.text.types.TextDrawBox;
import com.modesteam.bazinga.uniques.Bazinga;
import com.modesteam.bazinga.uniques.InputHandler;
import com.modesteam.bazinga.uniques.measures.Measure;

public class HowToPlayScreen implements Screen {

	private final float SLIDER_POS_Y = Measure.getProportionalY((1f / 9f));
	private final float SLIDER_POS_X_RATIO = Measure.getProportionalX((1f / 8f));

	private final int NUMBER_OF_SLIDES = 7;
	private final ScreenType[] sliderScreens = {ScreenType.HOW_TO_PLAY__INTRO,
			ScreenType.HOW_TO_PLAY__TUTORIAL, ScreenType.HOW_TO_PLAY__PAPER,
			ScreenType.HOW_TO_PLAY__SPOCK, ScreenType.HOW_TO_PLAY__ROCK,
			ScreenType.HOW_TO_PLAY__SCISSORS, ScreenType.HOW_TO_PLAY__LIZARD};

	private Bazinga game;
	private OrthographicCamera camera;

	private ScreenType currentScreen;

	private Array<TextEntity> slider;
	private Array<ParagraphBound> instructions;
	private TextDrawBox marker;


	public HowToPlayScreen(Bazinga game) {

		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Measure.getScreenWidth(), Measure.getScreenHeight());

		currentScreen = ScreenType.HOW_TO_PLAY__INTRO;

		instructions = new Array<ParagraphBound>();
		instructions.add(new ParagraphBound(
				"Bazinga is similar to the Jo-Ken-Po game, or Rock-Scissor-Paper.",
				Measure.getProportionalY((1f / 2f))));

		instructions.add(new ParagraphBound(
				"But, instead of 3 possible actions, this game have 5.",
				Measure.getProportionalY((1f / 2f))));

		instructions.add(new ParagraphBound(
				"PAPER disproves SPOCK and covers ROCK.",
				Measure.getProportionalY((1f / 2f))));

		instructions.add(new ParagraphBound(
				"SPOCK vaporizes ROCK and smashes SCISSORS.",
				Measure.getProportionalY((1f / 2f))));

		instructions.add(new ParagraphBound(
				"ROCK crushes SCISSORS and LIZARD.",
				Measure.getProportionalY((1f / 2f))));

		instructions.add(new ParagraphBound(
				"SCISSORS decapitates LIZARD and cuts PAPER.",
				Measure.getProportionalY((1f / 2f))));

		instructions.add(new ParagraphBound(
				"LIZARD eats PAPER and poisons SPOCK.",
				Measure.getProportionalY((1f / 2f))));

		marker = new TextDrawBox("X");

		slider = new Array<TextEntity>();
		for(int slideNumber = 1; slideNumber <= NUMBER_OF_SLIDES; slideNumber++) {

			slider.add(new LineTextEntity("O", (SLIDER_POS_X_RATIO * slideNumber),
					SLIDER_POS_Y, sliderScreens[slideNumber-1]));
		}
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		game.getBatch().begin();

		ScreenType currentSlide = InputHandler.getTextEntitiesScreenType(slider);
		if( currentSlide != ScreenType.NO_SCREEN) {

			currentScreen = currentSlide;
		}

		boolean isSlideUpdated = false;
		for(int slideNumber = 0; slideNumber < NUMBER_OF_SLIDES || !isSlideUpdated; slideNumber++) {

			if(currentScreen == sliderScreens[slideNumber]) {

				instructions.get(slideNumber).draw(game);
				marker.draw(game, (SLIDER_POS_X_RATIO * (slideNumber+1)), SLIDER_POS_Y);
				isSlideUpdated = true;
			}
		}

		for (TextEntity button : slider) {

			button.draw(game);
		}

		InputHandler.handleKeyCommand(Input.Keys.BACK, ScreenType.MAIN_MENU, game, delta);

		game.getBatch().end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}
}
