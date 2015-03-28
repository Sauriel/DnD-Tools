package de.sauriel.dndtools.settlements;

import java.util.ArrayList;

import de.sauriel.dndtools.buildings.Building;

public class Settlement {
	
	private String name;
	private String raceRelations;
	private String rulersStatus;
	private String notableTraits;
	private String knownFor;
	private String currentCalamity;
	
	private ArrayList<Building> buildings = new ArrayList<>();
	
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

	public ArrayList<Building> getBuildings() {
		return buildings;
	}
	
	public void addBuilding(Building building) {
		buildings.add(building);
	}

	public void setBuildings(ArrayList<Building> buildings) {
		this.buildings = buildings;
	}

	@Override
	public String toString() {
		String returnValue = "Name: " + name + "\n" + 
				"Race Relations: " + raceRelations +  "\n" + 
				"Ruler's Status: " + rulersStatus +  "\n" + 
				"Notable Trits: " + notableTraits +  "\n" + 
				"Known For Its ...: " + knownFor +  "\n" + 
				"Current Calamity: " + currentCalamity +  "\n" + 
				"Buildings:\n";
		for (Building building : buildings) {
			returnValue += "\t" + building + "\n";
		}
		return returnValue;
	}

}
