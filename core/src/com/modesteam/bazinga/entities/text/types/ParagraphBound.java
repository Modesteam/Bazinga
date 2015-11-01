package com.modesteam.bazinga.entities.text.types;


import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.uniques.Bazinga;
import com.modesteam.bazinga.uniques.Font;
import com.modesteam.bazinga.uniques.measures.Measure;

public class ParagraphBound implements TextBound {

	private Array<TextDrawBox> drawBoxes;
	private Array<TextCollisionBox> collisionBoxes;

	public ParagraphBound(String text, float centerY) {

		drawBoxes = new Array<TextDrawBox>();
		collisionBoxes = new Array<TextCollisionBox>();

		generateBoxes(text, centerY);
	}

	private void generateBoxes(String text, float centerY) {

		GlyphLayout glyph = new GlyphLayout(Font.getFont(), "%");
		final int maxLettersPerLine = Math.round(Measure.getScreenWidth() / (glyph.width * 1.5f));
		Array<String> textLines = new Array<String>();
		String[] tokens = text.split(" ");
		for (String token : tokens) {

			textLines = analyzeToken(token, textLines, maxLettersPerLine);
		}

		int quantityOfLines = textLines.size;
		final int lineSpace = Math.round(glyph.height * 1.5f);
		float initialY = centerY + (lineSpace * Math.round(quantityOfLines / 2f));
		for (int line = 0; line < quantityOfLines; line++) {

			TextDrawBox drawBox = new TextDrawBox(textLines.get(line), (initialY - (lineSpace * line)));
			drawBoxes.add(drawBox);
			collisionBoxes.add(new TextCollisionBox(drawBox));
		}
	}

	private Array<String> analyzeToken(String token, Array<String> textLines, int maxLettersPerLine) {

		Array<String> updatedTextLines = textLines;
		if (token.length() <= maxLettersPerLine) {

			if (updatedTextLines.size == 0) {

				updatedTextLines.add(token);
			} else {

				if ((updatedTextLines.get(updatedTextLines.size - 1).length()
						+ token.length()) < maxLettersPerLine) {

					String spacedToken = " " + token;
					String updatedLine = updatedTextLines.get(updatedTextLines.size - 1).concat(spacedToken);
					updatedTextLines.set(updatedTextLines.size - 1, updatedLine);
				} else {

					updatedTextLines.add(token);
				}
			}
		} else {

			String splitToken = token.substring(0, maxLettersPerLine - 1);
			if (Character.isLetter(splitToken.charAt(splitToken.length() - 1))) {
				splitToken = splitToken.concat("_");
			}
			updatedTextLines.add(splitToken);
			String remainedToken = token.substring(maxLettersPerLine - 1, token.length());
			updatedTextLines = analyzeToken(remainedToken, updatedTextLines, maxLettersPerLine);
		}

		return updatedTextLines;
	}

	@Override
	public void draw(Bazinga game) {

		for (TextDrawBox drawBox : drawBoxes) {

			drawBox.draw(game);
		}
	}

	@Override
	public void setPoint(float y) {

		// TODO
	}

	@Override
	public Rectangle getCollisionRect() {

		return getCollisionBoxes().first();
	}

	public Array<TextCollisionBox> getCollisionBoxes() {
		return collisionBoxes;
	}
}
