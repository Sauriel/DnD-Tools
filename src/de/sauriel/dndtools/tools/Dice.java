package de.sauriel.dndtools.tools;

import java.util.ArrayList;
import java.util.Random;

public class Dice {

	public static int roll(int sides) {
		int roll = -1;
		Random rnd = new Random();
		roll = rnd.nextInt(sides) + 1;
		return roll;
	}
	
	public static ArrayList<Integer> multiRoll(int number, int sides) {
		ArrayList<Integer> rolls = new ArrayList<Integer>();
		for(int i = 0; i < number; i++) {
			rolls.add(roll(sides));
		}
		return rolls;
	}
}
