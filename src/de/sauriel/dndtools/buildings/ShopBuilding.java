package de.sauriel.dndtools.buildings;

public class ShopBuilding extends Building {

	public ShopBuilding(String type) {
		super.type = type;
	}

	@Override
	public String toString() {
		return "Shop Building: " + type;
	}
}
