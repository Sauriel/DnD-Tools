package main.java.de.sauriel.dndtools.buildings;

public class TavernBuilding extends Building {
	
	private String name;

	public TavernBuilding(String type, String name) {
		super.type = type;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tavern Building: " + type + ", Name: " + name;
	}
}
