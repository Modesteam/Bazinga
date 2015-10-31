package com.modesteam.bazinga.entities.types;

import com.badlogic.gdx.math.Rectangle;
import com.modesteam.bazinga.uniques.Bazinga;

public class LineTextBound {

	private LineTextDrawBox drawBox;
	private LineTextCollisionBox collisionBox;

	public LineTextBound(String text) {

		drawBox = new LineTextDrawBox(text);
		collisionBox = new LineTextCollisionBox(drawBox);
	}


	public void setPoint(float yRatio) {

		drawBox.setDrawPoint(yRatio);
		collisionBox.setCollisionPoint(drawBox);
	}

	public void draw(Bazinga game) {

		drawBox.draw(game);
	}

	public Rectangle getCollisionRect() {

		return collisionBox;
	}
}
