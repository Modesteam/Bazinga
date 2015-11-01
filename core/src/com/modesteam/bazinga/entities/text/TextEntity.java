package com.modesteam.bazinga.entities.text;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.entities.Entity;
import com.modesteam.bazinga.uniques.screens.ScreenType;

public interface TextEntity extends Entity {

	ScreenType getScreenType();
	Array<Rectangle> getCollisionRects();
}
