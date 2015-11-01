package com.modesteam.bazinga.entities.text;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.entities.text.types.ParagraphBound;
import com.modesteam.bazinga.entities.text.types.TextCollisionBox;
import com.modesteam.bazinga.uniques.Bazinga;
import com.modesteam.bazinga.uniques.screens.ScreenType;

public class ParagraphEntity implements TextEntity {

	private ScreenType screenType;
	private ParagraphBound bound;

	public ParagraphEntity(String text, float y, ScreenType screenType) {

		bound = new ParagraphBound(text, y);
		this.screenType = screenType;
	}

	public void draw(Bazinga game) {

		bound.draw(game);
	}

	public ScreenType getScreenType() {

		return screenType;
	}

	@Override
	public Array<Rectangle> getCollisionRects() {

		Array<TextCollisionBox> boxes = bound.getCollisionBoxes();
		Array<Rectangle> rects = new Array<Rectangle>();

		for (Rectangle rect : boxes) {

			rects.add(rect);
		}

		return rects;
	}
}
