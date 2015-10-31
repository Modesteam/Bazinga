package com.modesteam.bazinga.entities;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Rectangle;
import com.modesteam.bazinga.uniques.Bazinga;
import com.modesteam.bazinga.entities.types.LineTextBound;


public class TextEntity {

	private Screen screen;
	private LineTextBound bound;

	public TextEntity(String text, float yRatio, Screen screen) {

		bound = new LineTextBound(text);
		bound.setPoint(yRatio);

		this.screen = screen;
	}

	public void draw(Bazinga game) {

		bound.draw(game);
	}

	public Screen getScreen() {

		return this.screen;
	}

	public Rectangle getCollisionRect() {

		return bound.getCollisionRect();
	}
}
