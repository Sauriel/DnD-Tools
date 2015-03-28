package de.sauriel.dndtools.settlements;

public class Settlement {
	
	String name;
	String raceRelations;
	String rulersStatus;
	String notableTraits;
	String knownFor;
	String currentCalamity;
	
	public Settlement(String name) {
		this.name = name;
	}

	public void setRaceRelations(String raceRelations) {
		this.raceRelations = raceRelations;
	}

	public void setRulersStatus(String rulersStatus) {
		this.rulersStatus = rulersStatus;
	}

	public void setNotableTraits(String notableTraits) {
		this.notableTraits = notableTraits;
	}

	public void setKnownFor(String knownFor) {
		this.knownFor = knownFor;
	}

	public void setCurrentCalamity(String currentCalamity) {
		this.currentCalamity = currentCalamity;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n" + 
				"Race Relations: " + raceRelations +  "\n" + 
				"Ruler's Status: " + rulersStatus +  "\n" + 
				"Notable Trits: " + notableTraits +  "\n" + 
				"Known For Its ...: " + knownFor +  "\n" + 
				"Current Calamity: " + currentCalamity;
	}

}
