package com.modesteam.bazinga.entities.text.types;

import com.badlogic.gdx.math.Rectangle;
import com.modesteam.bazinga.entities.Entity;

public interface TextBound extends Entity {

	void setPoint(float y);
	Rectangle getCollisionRect();
}