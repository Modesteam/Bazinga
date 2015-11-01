package com.modesteam.bazinga.entities.text.types;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.modesteam.bazinga.uniques.measures.Measure;

import static java.lang.Math.round;

public class TextCollisionBox extends Rectangle {

	public TextCollisionBox(TextDrawBox drawBox) {

		super();
		updateCollisionBox(drawBox);
	}

	public void updateCollisionBox(TextDrawBox drawBox) {

		GlyphLayout glyph = drawBox.getGlyph();
		height = glyph.height;
		width = glyph.width;

		setCollisionPoint(drawBox);
	}

	private void correctCenteredX() {

		x = x - round(width / 2f);
	}

	public void setCollisionPoint(TextDrawBox drawBox) {

		setCollisionX(drawBox);
		this.y = Measure.getScreenHeight() - drawBox.getY();
	}

	private void setCollisionX(TextDrawBox drawBox) {

		this.x = drawBox.getX();

		if (drawBox.isCenteredX()) {

			correctCenteredX();
		}
	}
}
