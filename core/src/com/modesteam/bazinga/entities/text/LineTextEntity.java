package com.modesteam.bazinga.entities.text;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.entities.*;
import com.modesteam.bazinga.entities.text.types.LineTextBound;
import com.modesteam.bazinga.uniques.Bazinga;
import com.modesteam.bazinga.uniques.screens.ScreenType;

public class LineTextEntity implements TextEntity {

	private ScreenType screenType;
	private LineTextBound bound;

	public LineTextEntity(String text, float y, ScreenType screenType) {

		bound = new LineTextBound(text, y);
		this.screenType = screenType;
	}

	public LineTextEntity(String text, float x, float y, ScreenType screenType) {

		bound = new LineTextBound(text, x, y);
		this.screenType = screenType;
	}

	@Override
	public void draw(Bazinga game) {

		bound.draw(game);
	}

	@Override
	public ScreenType getScreenType() {

		return screenType;
	}

	@Override
	public Array<Rectangle> getCollisionRects() {

		Array<Rectangle> rects = new Array<Rectangle>(1);
		rects.add(bound.getCollisionRect());
		return rects;
	}
}
