package main.java.de.sauriel.dndtools.encounter;

import java.util.ArrayList;

import main.java.de.sauriel.dndtools.tools.RangedTreeMap;

public class EncounterXpCalculation {
	
	public static final int[] EASY_XP = {25,50,75,125,250,300,350,450,550,600,800,1000,1100,1250,1400,1600,2000,2100,2400,2800};
	public static final int[] MEDIUM_XP = {50,100,150,250,500,600,750,900,1100,1200,1600,2000,2200,2500,2800,3200,3900,4200,4900,5700};
	public static final int[] HARD_XP = {75,150,225,375,750,900,1100,1400,1600,1900,2400,3000,3400,3800,4300,4800,5900,6300,7300,8500};
	public static final int[] DEADLY_XP = {100,200,400,500,1100,1400,1700,2100,2400,2800,3600,4500,5100,5700,6400,7200,8800,9500,10900,12700};
	
	private final int MAX_NUMBER_OF_MONSTERS_MULTIPLIER = 15;
	private final float[] ENCOUTNER_MULTIPLIERS = {0.5f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 4.0f, 5.0f};
	private RangedTreeMap<Integer> encounterSize;
	
	public EncounterXpCalculation() {
		encounterSize = new RangedTreeMap<>();
		encounterSize.put(0, 0);
		encounterSize.put(1, 1);
		encounterSize.put(2, 2);
		encounterSize.put(3, 6, 3);
		encounterSize.put(7, 10, 4);
		encounterSize.put(11, 14, 5);
		encounterSize.put(MAX_NUMBER_OF_MONSTERS_MULTIPLIER, 6);
		encounterSize.put(MAX_NUMBER_OF_MONSTERS_MULTIPLIER+1, 7);
	}
	
	public int calculateXP(ArrayList<Integer> partyLevel, int numberOfMonsters, int[] difficulty) {
		int calculatedXP = 0;
		for (Integer level : partyLevel) {
			calculatedXP += difficulty[level.intValue()-1];
		}
		
		int partySizeModifier = 0;
		if (partyLevel.size() < 3) {
			partySizeModifier = 1;
		}
		if (partyLevel.size() > 5) {
			partySizeModifier = -1;
		}

		numberOfMonsters = Math.abs(numberOfMonsters);
		numberOfMonsters = Math.min(numberOfMonsters, MAX_NUMBER_OF_MONSTERS_MULTIPLIER);
		
		float modifiedXP = (float) calculatedXP / ENCOUTNER_MULTIPLIERS[encounterSize.get(numberOfMonsters) + partySizeModifier];
		calculatedXP = (int) modifiedXP;
		
		return calculatedXP;
	}

}
