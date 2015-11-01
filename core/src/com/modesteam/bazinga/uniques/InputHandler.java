package com.modesteam.bazinga.uniques;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.entities.text.TextEntity;
import com.modesteam.bazinga.uniques.measures.RectangleCollider;
import com.modesteam.bazinga.uniques.screens.ScreenType;

public abstract class InputHandler {

	private static final float MENU_INPUT_DELAY = 0.5f;
	private static float elapsed = 0f;

	public static void handleTextEntities(Array<TextEntity> texts, Bazinga game, float delta) {

		if (elapsed > MENU_INPUT_DELAY) {
			ScreenType screenType = getTextEntitiesScreenType(texts);

			if (screenType != ScreenType.NO_SCREEN) {
				elapsed = 0;
				game.setScreen(game.getScreenHandler().get(getTextEntitiesScreenType(texts), game));
			}
		} else {
			elapsed += delta;
		}
	}

	public static ScreenType getTextEntitiesScreenType(Array<TextEntity> texts) {

		ScreenType screenType = ScreenType.NO_SCREEN;

		if (Gdx.input.isTouched()) {

			float x = Gdx.input.getX();
			float y = Gdx.input.getY();

			SEARCHING:
			for (TextEntity text : texts) {

				for (Rectangle rect : text.getCollisionRects()) {

					if (RectangleCollider.areCollided(x, y, rect)) {

						screenType = text.getScreenType();
						break SEARCHING;
					}
				}
			}
		}

		return screenType;
	}

	public static void handleKeyCommand(int keyCode, ScreenType screenType, Bazinga game, float delta) {

		if (Gdx.input.isKeyPressed(keyCode)) {

			game.setScreen(game.getScreenHandler().get(screenType, game));
		}
	}
}
