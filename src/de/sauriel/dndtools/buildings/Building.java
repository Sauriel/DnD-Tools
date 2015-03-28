package de.sauriel.dndtools.buildings;

public abstract class Building {
	
	private String type;

	public Building() {
		this.type = "Building";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
