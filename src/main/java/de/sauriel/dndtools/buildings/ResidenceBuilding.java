package main.java.de.sauriel.dndtools.buildings;

public class ResidenceBuilding extends Building {

	public ResidenceBuilding(String type) {
		super.type = type;
	}

	@Override
	public String toString() {
		return "Residence Building: " + type;
	}

}
