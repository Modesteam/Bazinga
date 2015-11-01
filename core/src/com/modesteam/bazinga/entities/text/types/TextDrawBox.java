package com.modesteam.bazinga.entities.text.types;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.modesteam.bazinga.uniques.Bazinga;
import com.modesteam.bazinga.uniques.Font;
import com.modesteam.bazinga.uniques.measures.Measure;

public class TextDrawBox {

	private final float DEFAULT_X = 0;
	private final float DEFAULT_Y = 0;

	private final int DEFAULT_START = 0;

	private final float DEFAULT_TARGET_WIDTH = 1;
	private final int DEFAULT_HEIGHT_ALIGN = 1;
	private final boolean WITHOUT_WRAP = false;

	private final Color DEFAULT_COLOR = Color.WHITE;

	private String text;

	private boolean haveCenteredX;
	private float x;
	private float y;

	private int start;
	private int end;

	private float targetWidth;
	private int halign;
	private boolean wrap;

	private Color color;
	private GlyphLayout glyphLayout;

	public TextDrawBox(String text) {

		createGlyph(text);
		clearAllSettings();
	}

	public TextDrawBox(String text, float y) {

		createGlyph(text);
		clearAllSettings();
		setDrawPoint(y);
	}

	public TextDrawBox(String text, float x, float y) {

		createGlyph(text);
		clearAllSettings();
		setDrawPoint(x, y);
	}

	private void createGlyph(String text) {

		this.text = text;
		glyphLayout = new GlyphLayout();
	}

	public void clearAllSettings() {

		clearDrawPoint();
		clearStringBounds();
		clearDrawSettings();
		clearGlyphSettings();
	}

	public void clearDrawPoint() {

		x = DEFAULT_X;
		y = DEFAULT_Y;
	}

	public boolean isCenteredX() {

		return haveCenteredX;
	}

	public float getX() {

		return x;
	}

	public float getY() {

		return y;
	}

	public void setDrawPoint(float x, float y) {

		if (x == Measure.getCenterScreenX()) {

			haveCenteredX = true;
		}

		this.x = x;
		this.y = y;
	}

	public void setDrawPoint(float y) {

		x = Measure.getCenterScreenX();
		haveCenteredX = true;
		this.y = y;
	}

	public void clearStringBounds() {

		start = DEFAULT_START;
		end = text.length();
	}

	public void clearDrawSettings() {

		targetWidth = DEFAULT_TARGET_WIDTH;
		halign = DEFAULT_HEIGHT_ALIGN;
		wrap = WITHOUT_WRAP;
	}

	public void clearGlyphSettings() {

		color = DEFAULT_COLOR;
		glyphLayout.reset();
		glyphLayout.setText(Font.getFont(), text);
	}

	public GlyphLayout getGlyph() {

		return glyphLayout;
	}

	public void draw(Bazinga game) {

		Font.getFont().draw(game.getBatch(), text, x, y, start, end, targetWidth, halign, wrap);
	}
}
