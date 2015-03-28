package de.sauriel.dndtools.settlements;

import de.sauriel.dndtools.tools.Dice;
import de.sauriel.dndtools.tools.RangedTreeMap;

public class SettlementCreator {
	
	private RangedTreeMap<String> raceRelations;
	private RangedTreeMap<String> rulersStatus;
	private RangedTreeMap<String> notableTraits;
	private RangedTreeMap<String> knownFor;
	private RangedTreeMap<String> currentCalamity;
	
	public SettlementCreator() {
		// Fill Race Relations Table
		raceRelations = new RangedTreeMap<>();
		raceRelations.put(1, 10, "Harmony");
		raceRelations.put(11, 14, "Tension or rivalry");
		raceRelations.put(15, 16, "Racial majority are conquerors");
		raceRelations.put(17, "Racial minority are rulers");
		raceRelations.put(18, "Racial minority are refugees");
		raceRelations.put(19, "Racial majority oppresses minority");
		raceRelations.put(20, "Racial minority oppresses mojority");
		
		// Fill Ruler's Status Table
		rulersStatus = new RangedTreeMap<>();
		rulersStatus.put(1, 5, "Respected, fair, and just");
		rulersStatus.put(6, 8, "Feared tyrant");
		rulersStatus.put(9, "Weakling manipulated by others");
		rulersStatus.put(10, "Illegitimate ruler, simmering civil war");
		rulersStatus.put(11, "Ruled or controlled by a powerful monster");
		rulersStatus.put(12, "Mysterious, anonymous cabal");
		rulersStatus.put(13, "Contested leadership, open fighting");
		rulersStatus.put(14, "Cabal seized power openly");
		rulersStatus.put(15, "Doltish lout");
		rulersStatus.put(16, "On deathbed, claimants compete for power");
		rulersStatus.put(17, 18, "Iron-willed but respected");
		rulersStatus.put(19, 20, "Religous leader");
		
		// FIll Notable Traits Table
		notableTraits = new RangedTreeMap<>();
		notableTraits.put(1, "Canals in place of streets");
		notableTraits.put(2, "Massive statue or monument");
		notableTraits.put(3, "Grand temple");
		notableTraits.put(4, "Large fortress");
		notableTraits.put(5, "Verdant parks and orchards");
		notableTraits.put(6, "River divides town");
		notableTraits.put(7, "Major trade center");
		notableTraits.put(8, "Headquarters of a powerful family or guild");
		notableTraits.put(9, "Population mostly wealthy");
		notableTraits.put(10, "Destitute, rundown");
		notableTraits.put(11, "Awful smell (tanneries, open sewers)");
		notableTraits.put(12, "Center of trade for one specific good");
		notableTraits.put(13, "Site of many battles");
		notableTraits.put(14, "Site of a mythic or magical event");
		notableTraits.put(15, "Important library or archive");
		notableTraits.put(16, "Worship of all gods banned");
		notableTraits.put(17, "Sinister reputation");
		notableTraits.put(18, "Notable library or academy");
		notableTraits.put(19, "Site of important tomb or graveyard");
		notableTraits.put(20, "Built atop ancient ruins");
		
		// FIll Known For Its... Table
		knownFor = new RangedTreeMap<>();
		knownFor.put(1, "Delicious cuisine");
		knownFor.put(2, "Rude people");
		knownFor.put(3, "Greedy merchants");
		knownFor.put(4, "Artists and writers");
		knownFor.put(5, "Great hero/savior");
		knownFor.put(6, "Flowers");
		knownFor.put(7, "Hordes of beggars");
		knownFor.put(8, "Tough warriors");
		knownFor.put(9, "Dark magic");
		knownFor.put(10, "Decadence");
		knownFor.put(11, "Piety");
		knownFor.put(12, "Gambling");
		knownFor.put(13, "Godlessness");
		knownFor.put(14, "Education");
		knownFor.put(15, "Wines");
		knownFor.put(16, "High fashion");
		knownFor.put(17, "Political intrigue");
		knownFor.put(18, "Powerful guilds");
		knownFor.put(19, "Strong drink");
		knownFor.put(20, "Patriotism");
		
		// Fill Current Calamity Table
		currentCalamity = new RangedTreeMap<>();
		currentCalamity.put(1, "Suspected vampire infestation");
		currentCalamity.put(2, "New cult seeks converts");
		currentCalamity.put(3, "Important figure died (murder suspected)");
		currentCalamity.put(4, "War between rival thieves' guilds");
		currentCalamity.put(5, 6, "Plague or famine (sparks riot)");
		currentCalamity.put(7, "Corrupt officials");
		currentCalamity.put(8, 9, "Marauding monsters");
		currentCalamity.put(10, "Powerful wizard has moved into town");
		currentCalamity.put(11, "Economic depression (trade disrupted)");
		currentCalamity.put(12, "Flooding");
		currentCalamity.put(13, "Undead stirring in cemeteries");
		currentCalamity.put(14, "Prophecy of doom");
		currentCalamity.put(15, "Brink of war");
		currentCalamity.put(16, "Internal strife (leads to anarchy)");
		currentCalamity.put(17, "Besieged by enemies");
		currentCalamity.put(18, "Scandal threatens powerful families");
		currentCalamity.put(19, "Dungeon discovered (adventurers flock to town)");
		currentCalamity.put(20, "Religious sects struggle for power");
	}
	
	public Settlement create(String name) {
		Settlement settlement = new Settlement(name);
		
		settlement.setRaceRelations(raceRelations.get(Dice.roll(20)));
		settlement.setRulersStatus(rulersStatus.get(Dice.roll(20)));
		settlement.setNotableTraits(notableTraits.get(Dice.roll(20)));
		settlement.setKnownFor(knownFor.get(Dice.roll(20)));
		settlement.setCurrentCalamity(currentCalamity.get(Dice.roll(20)));
		
		return settlement;
	}

}
