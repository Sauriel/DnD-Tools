package main.java.de.sauriel.dndtools.buildings;

public abstract class Building {
	
	protected String type;

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
		return type + ": " + this.getClass().getSimpleName();
	}
}
