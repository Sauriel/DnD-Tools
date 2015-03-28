package de.sauriel.dndtools;

import de.sauriel.dndtools.settlements.Settlement;
import de.sauriel.dndtools.settlements.SettlementCreator;
import de.sauriel.dndtools.tools.Dice;

public class Main {
	
	public static void main(String[] args) {
		SettlementCreator creator = new SettlementCreator();
		Settlement town = creator.create("Higgins");
		System.out.println(town);
	}

}
