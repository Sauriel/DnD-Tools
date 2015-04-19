package main.java.de.sauriel.dndtools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.de.sauriel.dndtools.buildings.Building;
import main.java.de.sauriel.dndtools.buildings.BuildingCreator;
import main.java.de.sauriel.dndtools.encounter.EncounterXpCalculation;
import main.java.de.sauriel.dndtools.settlements.Settlement;
import main.java.de.sauriel.dndtools.settlements.SettlementCreator;
import main.java.de.sauriel.dndtools.spells.Spell;
import main.java.de.sauriel.dndtools.spells.Spelllist;
import main.java.de.sauriel.dndtools.tools.importAndExportTools.JsonImporter;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	private BuildingCreator buildingCreator = new BuildingCreator();
	private SettlementCreator settlementCreator = new SettlementCreator(buildingCreator);
	private EncounterXpCalculation encounterCalculation = new EncounterXpCalculation();

	public void showMenu() {
		while (true) {
			System.out.println("### MENU ###");
			System.out.println("# 0.\tExit Program");
			System.out.println("# 1.\tCreate Settlement");
			System.out.println("# 2.\tCreate Building");
			System.out.println("# 3.\tCalculate Encounter");
			System.out.println("# 4.\tShow Spells");
			System.out.println("### Choose your action ###");
			try {
				selectAction();
			} catch (InputMismatchException e) {
				blankLine();
				System.out.println("YOUR INPUT IS NOT VALID, PLEASE TRY AGAIN.");
				blankLine();
			}
		}
	}

	private void selectAction() throws InputMismatchException {
		String input = scanner.next();
		switch (input) {
		case "0":
			System.exit(1);
			scanner.close();
			break;
		case "1":
			createSettlement();
			break;
		case "2":
			createBuilding();
			break;
		case "3":
			calculateEncounter();
			break;
		case "4":
			showSpells();
			break;
		default:
			throw new InputMismatchException();
		}
		blankLine();
	}

	private void blankLine() {
		System.out.println();
	}

	private void createSettlement() {
		System.out.print("Please enter a name for the settlement: ");
		String settlementName = scanner.next();
		System.out.print("How many specific buildings would you like to create for the settlement? ");
		try {
			int numberOfBuildings = scanner.nextInt();
			Settlement town = settlementCreator.create(settlementName, numberOfBuildings);
			blankLine();
			System.out.println(town);
		} catch (Exception e) {
			System.out.println("Invalid input.");
		}
	}

	private void createBuilding() {
		Building building = buildingCreator.create();
		System.out.println(building);
	}

	private void calculateEncounter() {
		System.out.print("How many players are in the party? ");
		try {
			int partySize = scanner.nextInt();
			if (partySize < 1) {
				throw new Exception();
			}

			ArrayList<Integer> partyLevel = new ArrayList<>();
			while (partyLevel.size() < partySize) {
				System.out.print("What level has Player " + (partyLevel.size() + 1) + "? ");
				try {
					int level = scanner.nextInt();
					partyLevel.add(Integer.valueOf(level));
				} catch (Exception e) {
					System.out.println("Invalid input.");
				}
			}

			System.out.print("How many monsters do you want? ");
			int numberOfMonsters = scanner.nextInt();

			System.out.print("What difficulty do you want? (Easy, Medium, Hard, Deadly) ");
			String difficultySelect = scanner.next();
			int[] difficulty;
			switch (difficultySelect.toLowerCase().charAt(0)) {
			case 'd':
				difficulty = EncounterXpCalculation.DEADLY_XP;
				break;
			case 'e':
				difficulty = EncounterXpCalculation.EASY_XP;
				break;
			case 'h':
				difficulty = EncounterXpCalculation.HARD_XP;
				break;
			case 'm':
			default:
				difficulty = EncounterXpCalculation.MEDIUM_XP;
				break;
			}

			int calculatedXP = encounterCalculation.calculateXP(partyLevel, numberOfMonsters, difficulty);
			System.out.println("You can use: " + calculatedXP + " XP");
		} catch (Exception e) {
			System.out.println("Invalid input.");
		}
	}

	private void showSpells() {
		JsonImporter importer = new JsonImporter();
		ArrayList<Spell> spells = importer.importSpells();
		ArrayList<Spelllist> spelllists = importer.importSpelllists(spells);

		HashMap<String, Spelllist> spellsMap = new HashMap<>();
		for (Spelllist list : spelllists) {
			spellsMap.put(list.getClassName(), list);
		}

		System.out.println("### Show spells for: ###");
		for (Spelllist spelllist : spelllists) {
			System.out.println("#\t" + spelllist.getClassName());
		}
		System.out.print("Class: ");
		String input = scanner.next();
		ArrayList<Spell> classSpells = spellsMap.get(input).getSpells();
		blankLine();
		for (Spell spell : classSpells) {
			System.out.println(spell);
			blankLine();
		}
	}

}
