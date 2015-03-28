package de.sauriel.dndtools.buildings;

public class ReligiousBuilding extends Building {

	public ReligiousBuilding(String type) {
		super.type = type;
	}

	@Override
	public String toString() {
		return "Religious Building: " + type;
	}
}
