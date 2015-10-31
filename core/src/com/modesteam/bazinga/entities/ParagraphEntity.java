package com.modesteam.bazinga.entities;

import com.badlogic.gdx.Screen;

public class ParagraphEntity extends TextEntity {

	public ParagraphEntity(String text, float yRatio, Screen screen) {

		super(text, yRatio, screen);
	}

	/*public TextEntity(String text, float yNumerator, float yDenominator, Bazinga game, Screen screen,
					  boolean wrap, float targetWidth) {

		this.targetWidth = targetWidth;
		this.wrap = wrap;
		this.screen = screen;
		this.text = text;
		this.vectorEnds = generateVectorEnds(this.text.length(), getMaxQuantityChars(game));
		System.out.println(toStringVectorEnds(this.vectorEnds));

		game.getGlyphLayout().setText(game.getFont(), text);
		this.rect = new Rectangle(Measure.getCenterScreenX(false),
				Measure.getProportionalY(yNumerator, yDenominator, false),
				game.getGlyphLayout().width, game.getGlyphLayout().height);
		updateBoundingBox();
	}*/

	/*
	public void draw(Bazinga gameInstance) {
		int aux;
		int breakLine;
		final float EXTRASPACE = (float) 1.2;

		for (aux = 0, breakLine = 0; aux < vectorEnds.size(); aux++, breakLine++) {
			if (aux == 0) {
				gameInstance.getFont().draw(gameInstance.getBatch(), text, rect.getX(),
						(rect.getY()), 0, vectorEnds.get(aux), targetWidth, DEFAULT_HEIGHT_ALIGN, wrap);
			} else {
				gameInstance.getFont().draw(gameInstance.getBatch(), text, rect.getX(),
						(rect.getY() - ((breakLine * getMinimalY(gameInstance)) * EXTRASPACE)), vectorEnds.get(aux - 1),
						vectorEnds.get(aux), targetWidth, DEFAULT_HEIGHT_ALIGN, wrap);
			}
		}
	}*/

	/*
		public ArrayList<Integer> generateVectorEnds(int stringLegnth, int ct) {

		int aux = 0;
		boolean exit = false;
		ArrayList<Integer> vectorEnds = new ArrayList<Integer>();

		while (!exit) {
			if (aux == 0) {
				vectorEnds.add(Integer.valueOf(0));
			} else {
				if ((vectorEnds.get(vectorEnds.size() - 1) + ct) < stringLegnth) {
					vectorEnds.add(Integer.valueOf(vectorEnds.get(vectorEnds.size() - 1) + ct));
				} else {
					vectorEnds.add(Integer.valueOf(stringLegnth));
					exit = true;
				}
			}
			aux++;
		}
		return vectorEnds;
	}
	 */

	/*
	public float getMinimalX(Bazinga game) {

		game.getGlyphLayout().setText(game.getFont(), "W");
		return (game.getGlyphLayout().width);
	}

	public float getMinimalY(Bazinga game) {

		game.getGlyphLayout().setText(game.getFont(), "W");
		return (game.getGlyphLayout().height);
	}

	public int getMaxQuantityChars(Bazinga game) {

		int result = (int) (getScreenWidth(false) / getMinimalX(game));
		return result - CORRECTION_FACTOR;
	}

	public String toStringVectorEnds(ArrayList<Integer> vectorEnds) {

		StringBuffer string = new StringBuffer();
		for (Integer elemento : vectorEnds) {
			string.append(elemento.toString());
		}
		return string.toString();
	}*/

}
