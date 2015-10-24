package com.modesteam.bazinga.entities;

import com.badlogic.gdx.math.Rectangle;
import com.modesteam.bazinga.Bazinga;
import com.modesteam.bazinga.measures.Measure;


public class TextEntity {

	private final float DEFAULT_TARGET_WIDTH = 1;
	private final int DEFAULT_HEIGHT_ALIGN = 1;
	private final boolean DEAFULT_WRAP = false;

	private Rectangle boundingBox;
	private String text;

	public TextEntity() {

		boundingBox = new Rectangle();
	}

	public void draw(Bazinga gameInstance) {

		gameInstance.getFont().draw(gameInstance.getBatch(), text, boundingBox.getX(),
				boundingBox.getY(), DEFAULT_TARGET_WIDTH, DEFAULT_HEIGHT_ALIGN, DEAFULT_WRAP);
	}

	public void setPosition(float x, float y) {

		this.boundingBox.setPosition(x, y);
	}

	public void setSize(float height, float width) {

		this.boundingBox.setSize(height, width);
	}

	public void setText(String text) {

		this.text = text;
	}

	public void setRect(float x, float y, float height, float width) {

		this.boundingBox.set(x, y, height, width);
	}
}
