package main.java.de.sauriel.dndtools.tools.dice;

import java.util.ArrayList;
import java.util.Random;

public enum Dice {

	D100(100),
	D20(20),
	D12(12),
	D10(10),
	D8(8),
	D6(6),
	D4(4);

	private int sides;

	private Dice(int sides) {
		this.sides = sides;
	}

	public DiceResult roll() {
		int roll = -1;
		// TODO replace with a true random number generator
		Random rnd = new Random();
		roll = rnd.nextInt(sides) + 1;
		return DiceResult.create(roll, sides);
	}

	public ArrayList<DiceResult> multiRoll(int number) {
		ArrayList<DiceResult> rolls = new ArrayList<DiceResult>();
		for(int i = 0; i < number; i++) {
			rolls.add(roll());
		}
		return rolls;
	}

}
