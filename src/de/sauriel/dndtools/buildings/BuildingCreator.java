package de.sauriel.dndtools.buildings;

import java.util.TreeMap;

import de.sauriel.dndtools.tools.RangedTreeMap;
import de.sauriel.dndtools.tools.dice.Dice;

public class BuildingCreator {

	private final Class<? extends Building> RESIDENCE = ResidenceBuilding.class;
	private final Class<? extends Building> RELIGIOUS = ReligiousBuilding.class;
	private final Class<? extends Building> TAVERN = TavernBuilding.class;
	private final Class<? extends Building> WAREHOUSE = WarehouseBuilding.class;
	private final Class<? extends Building> SHOP = ShopBuilding.class;

	private RangedTreeMap<Class<? extends Building>> buildingTypes;

	private RangedTreeMap<String> residenceSubtypes;
	private RangedTreeMap<String> religiousSubtypes;
	private RangedTreeMap<String> tavernSubtypes;
	private RangedTreeMap<String> warehouseSubtypes;
	private TreeMap<Integer, String> shopSubtypes;

	private TreeMap<Integer, String> tavernNameFirstPart;
	private TreeMap<Integer, String> tavernNameSecondPart;

	public BuildingCreator() {
		// add building types
		buildingTypes = new RangedTreeMap<>();
		buildingTypes.put(1, 10, RESIDENCE);
		buildingTypes.put(11, 12, RELIGIOUS);
		buildingTypes.put(13, 15, TAVERN);
		buildingTypes.put(16, 17, WAREHOUSE);
		buildingTypes.put(18, 20, SHOP);

		// add residence subtypes
		residenceSubtypes = new RangedTreeMap<>();
		residenceSubtypes.put(1, 2, "Abandoned squat");
		residenceSubtypes.put(3, 8, "Middle-class home");
		residenceSubtypes.put(9, 10, "Upper-class home");
		residenceSubtypes.put(11, 15, "Crowded tenement");
		residenceSubtypes.put(16, 17, "Orphanage");
		residenceSubtypes.put(18, "Hidden slavers' den");
		residenceSubtypes.put(19, "Front for a secret cult");
		residenceSubtypes.put(20, "Lavish, guarded mansion");

		// add religous subtypes
		religiousSubtypes = new RangedTreeMap<>();
		religiousSubtypes.put(1, 10, "Temple to a good or neutral deity");
		religiousSubtypes.put(11, 12, "Temple to a false deity (run by charlatan priests)");
		religiousSubtypes.put(13, "Home of ascetics");
		religiousSubtypes.put(14, 15, "Abandoned shrine");
		religiousSubtypes.put(16, 17, "Library dedicated to religious study");
		religiousSubtypes.put(18, 20, "Hidden shrine to a fiend or an evil deity");

		// add tavern subtypes
		tavernSubtypes = new RangedTreeMap<>();
		tavernSubtypes.put(1, 5, "Quiet, low-key bar");
		tavernSubtypes.put(6, 9, "Raucous dive");
		tavernSubtypes.put(10, "Thieves' guild hangout");
		tavernSubtypes.put(11, "Gathering place for a secret society");
		tavernSubtypes.put(12, 13, "Upper-class dining club");
		tavernSubtypes.put(14, 15, "Gambling den");
		tavernSubtypes.put(16, 17, "Caters to a specific race or guild");
		tavernSubtypes.put(18, "Members-only club");
		tavernSubtypes.put(19, 20, "Brothel");

		// add warehouse subtypes
		warehouseSubtypes = new RangedTreeMap<>();
		warehouseSubtypes.put(1, 4, "Empty or abandoned");
		warehouseSubtypes.put(5, 6, "Heavily guarded, expensive goods");
		warehouseSubtypes.put(7, 10, "Cheap goods");
		warehouseSubtypes.put(11, 14, "Bulk goods");
		warehouseSubtypes.put(15, "Live Animals");
		warehouseSubtypes.put(16, 17, "Weapons/armor");
		warehouseSubtypes.put(18, 19, "Goods from a distant land");
		warehouseSubtypes.put(20, "Secret smugler's den");

		// add shop subtypes
		shopSubtypes = new TreeMap<>();
		shopSubtypes.put(1, "Pawnshop");
		shopSubtypes.put(2, "Herbs/incense");
		shopSubtypes.put(3, "Fruits/vegetables");
		shopSubtypes.put(4, "Dried meats");
		shopSubtypes.put(5, "Pottery");
		shopSubtypes.put(6, "Undertaker");
		shopSubtypes.put(7, "Books");
		shopSubtypes.put(8, "Moneylender");
		shopSubtypes.put(9, "Weapons/armor");
		shopSubtypes.put(10, "Chandler");
		shopSubtypes.put(11, "Smithy");
		shopSubtypes.put(12, "Carpenter");
		shopSubtypes.put(13, "Weaver");
		shopSubtypes.put(14, "Jeweler");
		shopSubtypes.put(15, "Baker");
		shopSubtypes.put(16, "Mapmaker");
		shopSubtypes.put(17, "Tailor");
		shopSubtypes.put(18, "Ropemaker");
		shopSubtypes.put(19, "Mason");
		shopSubtypes.put(20, "Scribe");

		// add tavern name first part
		tavernNameFirstPart = new TreeMap<>();
		tavernNameFirstPart.put(1, "The Silver");
		tavernNameFirstPart.put(2, "The Golden");
		tavernNameFirstPart.put(3, "The Staggering");
		tavernNameFirstPart.put(4, "The Laughing");
		tavernNameFirstPart.put(5, "The Prancing");
		tavernNameFirstPart.put(6, "The Gilded");
		tavernNameFirstPart.put(7, "The Running");
		tavernNameFirstPart.put(8, "The Howling");
		tavernNameFirstPart.put(9, "The Slaughtered");
		tavernNameFirstPart.put(10, "The Leering");
		tavernNameFirstPart.put(11, "The Drunken");
		tavernNameFirstPart.put(12, "The Leaping");
		tavernNameFirstPart.put(13, "The Roaring");
		tavernNameFirstPart.put(14, "The Frowning");
		tavernNameFirstPart.put(15, "The Lonely");
		tavernNameFirstPart.put(16, "The Wandering");
		tavernNameFirstPart.put(17, "The Mysterious");
		tavernNameFirstPart.put(18, "The Barking");
		tavernNameFirstPart.put(19, "The Black");
		tavernNameFirstPart.put(20, "The Gleaming");

		// add tavern name second part
		tavernNameSecondPart = new TreeMap<>();
		tavernNameSecondPart.put(1, "Eel");
		tavernNameSecondPart.put(2, "Dolphin");
		tavernNameSecondPart.put(3, "Dwarf");
		tavernNameSecondPart.put(4, "Pegasus");
		tavernNameSecondPart.put(5, "Pony");
		tavernNameSecondPart.put(6, "Rose");
		tavernNameSecondPart.put(7, "Stag");
		tavernNameSecondPart.put(8, "Wolf");
		tavernNameSecondPart.put(9, "Lamb");
		tavernNameSecondPart.put(10, "Demon");
		tavernNameSecondPart.put(11, "Goat");
		tavernNameSecondPart.put(12, "Spirit");
		tavernNameSecondPart.put(13, "Horde");
		tavernNameSecondPart.put(14, "Jester");
		tavernNameSecondPart.put(15, "Mountain");
		tavernNameSecondPart.put(16, "Eagle");
		tavernNameSecondPart.put(17, "Satyr");
		tavernNameSecondPart.put(18, "Dog");
		tavernNameSecondPart.put(19, "Spider");
		tavernNameSecondPart.put(20, "Star");
	}

	public Building create() {
		Class<? extends Building> type = buildingTypes.get(Dice.D20.roll().getResult());

		if (type.equals(RESIDENCE)) {
			return createResidence();
		}
		if (type.equals(RELIGIOUS)) {
			return createReligious();
		}
		if (type.equals(TAVERN)) {
			return createTavern();
		}
		if (type.equals(WAREHOUSE)) {
			return createWarehouse();
		}
		if (type.equals(SHOP)) {
			return createShop();
		}

		return null;
	}

	private ResidenceBuilding createResidence() {
		return new ResidenceBuilding(residenceSubtypes.get(Dice.D20.roll().getResult()));
	}

	private ReligiousBuilding createReligious() {
		return new ReligiousBuilding(religiousSubtypes.get(Dice.D20.roll().getResult()));
	}

	private TavernBuilding createTavern() {
		String tavernName = String.join(" ", tavernNameFirstPart.get(Dice.D20.roll().getResult()), tavernNameSecondPart.get(Dice.D20.roll().getResult()));
		return new TavernBuilding(tavernSubtypes.get(Dice.D20.roll().getResult()), tavernName);
	}

	private WarehouseBuilding createWarehouse() {
		return new WarehouseBuilding(warehouseSubtypes.get(Dice.D20.roll().getResult()));
	}

	private ShopBuilding createShop() {
		return new ShopBuilding(shopSubtypes.get(Dice.D20.roll().getResult()));
	}

}
