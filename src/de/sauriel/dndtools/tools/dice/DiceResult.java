package de.sauriel.dndtools.tools.dice;

public class DiceResult {

	private int result;
	private int sides;

	private DiceResult(int result, int sides) {
		this.result = result;
		this.sides = sides;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public static DiceResult create(int result, int sides) {
		return new DiceResult(result, sides);
	}
}
