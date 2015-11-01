package com.modesteam.bazinga.entities.text.types;

import com.badlogic.gdx.math.Rectangle;
import com.modesteam.bazinga.uniques.Bazinga;

public class LineTextBound implements TextBound {

	private TextDrawBox drawBox;
	private TextCollisionBox collisionBox;

	public LineTextBound(String text, float y) {

		drawBox = new TextDrawBox(text, y);
		collisionBox = new TextCollisionBox(drawBox);
	}

	public LineTextBound(String text, float x, float y) {

		drawBox = new TextDrawBox(text, x, y);
		collisionBox = new TextCollisionBox(drawBox);
	}

	@Override
	public void setPoint(float y) {

		drawBox.setDrawPoint(y);
		collisionBox = new TextCollisionBox(drawBox);
	}

	@Override
	public void draw(Bazinga game) {

		drawBox.draw(game);
	}

	@Override
	public Rectangle getCollisionRect() {

		return collisionBox;
	}
}
