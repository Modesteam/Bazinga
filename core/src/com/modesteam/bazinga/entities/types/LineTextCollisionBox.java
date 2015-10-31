package com.modesteam.bazinga.entities.types;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.modesteam.bazinga.uniques.measures.Measure;

import static java.lang.Math.round;

public class LineTextCollisionBox extends Rectangle {

	public LineTextCollisionBox(LineTextDrawBox drawBox) {

		updateCollisionBox(drawBox);
	}

	public void updateCollisionBox(LineTextDrawBox drawBox) {

		GlyphLayout glyph = drawBox.getGlyph();
		height = glyph.height;
		width = glyph.width;

		setCollisionX(drawBox);
	}

	private void correctCenteredX() {

		x = x - round(width / 2f);
	}

	public void setCollisionPoint(LineTextDrawBox drawBox) {

		setCollisionX(drawBox);
		this.y = Measure.getScreenHeight() - drawBox.getY();
	}

	private void setCollisionX(LineTextDrawBox drawBox) {

		this.x = drawBox.getX();

		if (drawBox.isCenteredX()) {

			correctCenteredX();
		} else {

			// Do Nothing
		}
	}
}
