package de.sauriel.dndtools.buildings;

import de.sauriel.dndtools.tools.Dice;
import de.sauriel.dndtools.tools.RangedTreeMap;

public class BuildingCreator {
	
	private final Class<? extends Building> RESIDENCE = ResidenceBuilding.class;
	private final Class<? extends Building> RELIGIOUS = ReligiousBuilding.class;
	private final Class<? extends Building> TAVERN = TavernBuilding.class;
	private final Class<? extends Building> WAREHOUSE = WarehouseBuilding.class;
	private final Class<? extends Building> SHOP = ShopBuilding.class;
	
	private RangedTreeMap<Class<? extends Building>> buildingTypes;
	
	public BuildingCreator() {
		buildingTypes = new RangedTreeMap<>();
		buildingTypes.put(1, 10, RESIDENCE);
		buildingTypes.put(11, 12, RELIGIOUS);
		buildingTypes.put(13, 15, TAVERN);
		buildingTypes.put(16, 17, WAREHOUSE);
		buildingTypes.put(18, 20, SHOP);
	}

	public Building create() {
		Class<? extends Building> type = buildingTypes.get(Dice.roll(20));
		
		if (type.equals(RESIDENCE)) {
			return new ResidenceBuilding();
		}
		if (type.equals(RELIGIOUS)) {
			return new ReligiousBuilding();
		}
		if (type.equals(TAVERN)) {
			return new TavernBuilding();
		}
		if (type.equals(WAREHOUSE)) {
			return new WarehouseBuilding();
		}
		if (type.equals(SHOP)) {
			return new ShopBuilding();
		}
		
		return null;
	}

}
