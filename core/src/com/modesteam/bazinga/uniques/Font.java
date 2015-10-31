package com.modesteam.bazinga.uniques;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.modesteam.bazinga.uniques.measures.Measure;

public abstract class Font {

	private static FreeTypeFontGenerator generator;
	private static FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	private static BitmapFont font;

	public static void generateStandardValues() {

		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/BPmono.ttf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

		parameter.size = Measure.getFontSize();
		font = generator.generateFont(parameter);
		font.setColor(Color.WHITE);
		generator.dispose();
	}

	public static BitmapFont getFont() {

		return font;
	}

	public static void dispose() {

		generator.dispose();
		font.dispose();
	}
}
