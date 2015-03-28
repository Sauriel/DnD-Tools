package de.sauriel.dndtools.settlements;

import de.sauriel.dndtools.tools.Dice;
import de.sauriel.dndtools.tools.Table;

public class SettlementCreator {
	
	Table raceRelations;
	Table rulersStatus;
	Table notableTraits;
	Table knownFor;
	Table currentCalamity;
	
	public SettlementCreator() {
		// Fill Race Relations Table
		raceRelations = new Table();
		raceRelations.addValue(1, 10, "Harmony");
		raceRelations.addValue(11, 14, "Tension or rivalry");
		raceRelations.addValue(15, 16, "Racial majority are conquerors");
		raceRelations.addValue(17, "Racial minority are rulers");
		raceRelations.addValue(18, "Racial minority are refugees");
		raceRelations.addValue(19, "Racial majority oppresses minority");
		raceRelations.addValue(20, "Racial minority oppresses mojority");
		
		// Fill Ruler's Status Table
		rulersStatus = new Table();
		rulersStatus.addValue(1, 5, "Respected, fair, and just");
		rulersStatus.addValue(6, 8, "Feared tyrant");
		rulersStatus.addValue(9, "Weakling manipulated by others");
		rulersStatus.addValue(10, "Illegitimate ruler, simmering civil war");
		rulersStatus.addValue(11, "Ruled or controlled by a powerful monster");
		rulersStatus.addValue(12, "Mysterious, anonymous cabal");
		rulersStatus.addValue(13, "Contested leadership, open fighting");
		rulersStatus.addValue(14, "Cabal seized power openly");
		rulersStatus.addValue(15, "Doltish lout");
		rulersStatus.addValue(16, "On deathbed, claimants compete for power");
		rulersStatus.addValue(17, 18, "Iron-willed but respected");
		rulersStatus.addValue(19, 20, "Religous leader");
		
		// FIll Notable Traits Table
		notableTraits = new Table();
		notableTraits.addValue(1, "Canals in place of streets");
		notableTraits.addValue(2, "Massive statue or monument");
		notableTraits.addValue(3, "Grand temple");
		notableTraits.addValue(4, "Large fortress");
		notableTraits.addValue(5, "Verdant parks and orchards");
		notableTraits.addValue(6, "River divides town");
		notableTraits.addValue(7, "Major trade center");
		notableTraits.addValue(8, "Headquarters of a powerful family or guild");
		notableTraits.addValue(9, "Population mostly wealthy");
		notableTraits.addValue(10, "Destitute, rundown");
		notableTraits.addValue(11, "Awful smell (tanneries, open sewers)");
		notableTraits.addValue(12, "Center of trade for one specific good");
		notableTraits.addValue(13, "Site of many battles");
		notableTraits.addValue(14, "Site of a mythic or magical event");
		notableTraits.addValue(15, "Important library or archive");
		notableTraits.addValue(16, "Worship of all gods banned");
		notableTraits.addValue(17, "Sinister reputation");
		notableTraits.addValue(18, "Notable library or academy");
		notableTraits.addValue(19, "Site of important tomb or graveyard");
		notableTraits.addValue(20, "Built atop ancient ruins");
		
		// FIll Known For Its... Table
		knownFor = new Table();
		knownFor.addValue(1, "Delicious cuisine");
		knownFor.addValue(2, "Rude people");
		knownFor.addValue(3, "Greedy merchants");
		knownFor.addValue(4, "Artists and writers");
		knownFor.addValue(5, "Great hero/savior");
		knownFor.addValue(6, "Flowers");
		knownFor.addValue(7, "Hordes of beggars");
		knownFor.addValue(8, "Tough warriors");
		knownFor.addValue(9, "Dark magic");
		knownFor.addValue(10, "Decadence");
		knownFor.addValue(11, "Piety");
		knownFor.addValue(12, "Gambling");
		knownFor.addValue(13, "Godlessness");
		knownFor.addValue(14, "Education");
		knownFor.addValue(15, "Wines");
		knownFor.addValue(16, "High fashion");
		knownFor.addValue(17, "Political intrigue");
		knownFor.addValue(18, "Powerful guilds");
		knownFor.addValue(19, "Strong drink");
		knownFor.addValue(20, "Patriotism");
		
		// Fill Current Calamity Table
		currentCalamity = new Table();
		currentCalamity.addValue(1, "Suspected vampire infestation");
		currentCalamity.addValue(2, "New cult seeks converts");
		currentCalamity.addValue(3, "Important figure died (murder suspected)");
		currentCalamity.addValue(4, "War between rival thieves' guilds");
		currentCalamity.addValue(5, 6, "Plague or famine (sparks riot)");
		currentCalamity.addValue(7, "Corrupt officials");
		currentCalamity.addValue(8, 9, "Marauding monsters");
		currentCalamity.addValue(10, "Powerful wizard has moved into town");
		currentCalamity.addValue(11, "Economic depression (trade disrupted)");
		currentCalamity.addValue(12, "Flooding");
		currentCalamity.addValue(13, "Undead stirring in cemeteries");
		currentCalamity.addValue(14, "Prophecy of doom");
		currentCalamity.addValue(15, "Brink of war");
		currentCalamity.addValue(16, "Internal strife (leads to anarchy)");
		currentCalamity.addValue(17, "Besieged by enemies");
		currentCalamity.addValue(18, "Scandal threatens powerful families");
		currentCalamity.addValue(19, "Dungeon discovered (adventurers flock to town)");
		currentCalamity.addValue(20, "Religious sects struggle for power");
	}
	
	public Settlement create(String name) {
		Settlement settlement = new Settlement(name);
		
		settlement.setRaceRelations(raceRelations.getValue(Dice.roll(20)));
		settlement.setRulersStatus(rulersStatus.getValue(Dice.roll(20)));
		settlement.setNotableTraits(notableTraits.getValue(Dice.roll(20)));
		settlement.setKnownFor(knownFor.getValue(Dice.roll(20)));
		settlement.setCurrentCalamity(currentCalamity.getValue(Dice.roll(20)));
		
		return settlement;
	}

}
