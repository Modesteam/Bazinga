package com.modesteam.bazinga.uniques;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.entities.text.TextEntity;
import com.modesteam.bazinga.uniques.measures.RectangleCollider;

public abstract class InputHandle {

	public static void handleTextEntities(Array<TextEntity> texts, Bazinga game) {

		if (Gdx.input.isTouched()) {

			float x = Gdx.input.getX();
			float y = Gdx.input.getY();

			for (TextEntity text : texts) {

				for(Rectangle rect : text.getCollisionRects()) {

					if (RectangleCollider.areCollided(x, y, rect)) {

						game.setScreen(game.getScreenHandler().get(text.getScreenType(), game));
					}
				}
			}
		}
	}
}
