package com.modesteam.bazinga.entities;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Rectangle;
import com.modesteam.bazinga.Bazinga;
import com.modesteam.bazinga.measures.Measure;


public class TextEntity {

	private final float DEFAULT_TARGET_WIDTH = 1;
	private final int DEFAULT_HEIGHT_ALIGN = 1;
	private final boolean DEAFULT_WRAP = false;

	private Rectangle rect;
	private Rectangle boundingBox;
	private String text;
	private Screen screen;

	public TextEntity(String text, float yNumerator, float yDenominator, Bazinga game, Screen screen) {

		this.screen = screen;

		this.text = text;
		game.getGlyphLayout().setText(game.getFont(), text);
		this.rect = new Rectangle(Measure.getCenterScreenX(false),
				Measure.getProportionalY(yNumerator, yDenominator, false),
				game.getGlyphLayout().width, game.getGlyphLayout().height);
		updateBoundingBox();
	}

	public void draw(Bazinga gameInstance) {

		gameInstance.getFont().draw(gameInstance.getBatch(), text, rect.getX(),
				rect.getY(), DEFAULT_TARGET_WIDTH, DEFAULT_HEIGHT_ALIGN, DEAFULT_WRAP);
	}

	public Rectangle getBoundingBox() {

		return this.boundingBox;
	}

	public Screen getScreen() {

		return this.screen;
	}

	private void updateBoundingBox() {
		this.boundingBox = new Rectangle(this.rect);
		this.boundingBox.x = this.boundingBox.x - (this.boundingBox.width / 2f);
	}
}
