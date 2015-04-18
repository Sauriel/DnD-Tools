package main.java.de.sauriel.dndtools.buildings;


public class WarehouseBuilding extends Building {

	public WarehouseBuilding(String type) {
		super.type = type;
	}

	@Override
	public String toString() {
		return "Warehouse Building: " + type;
	}
}
