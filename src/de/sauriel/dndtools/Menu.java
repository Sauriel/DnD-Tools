package de.sauriel.dndtools;

import java.util.InputMismatchException;
import java.util.Scanner;

import de.sauriel.dndtools.buildings.Building;
import de.sauriel.dndtools.buildings.BuildingCreator;
import de.sauriel.dndtools.settlements.Settlement;
import de.sauriel.dndtools.settlements.SettlementCreator;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	private BuildingCreator buildingCreator = new BuildingCreator();
	private SettlementCreator settlementCreator = new SettlementCreator(buildingCreator);

	public void showMenu() {
		while (true) {
			System.out.println("### MENU ###");
			System.out.println("# 0.\tExit Program");
			System.out.println("# 1.\tCreate Settlement");
			System.out.println("# 2.\tCreate Building");
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
		default:
			throw new InputMismatchException();
		}
		blankLine();
	}
	
	private void blankLine() {
		System.out.println();
	}
	
	private void createSettlement() {
		System.out.print("Please enter a name for the Settlement: ");
		String settlementName = scanner.next();
		System.out.print("How many specific buildings would you like to create for the Settlement? ");
		int numberOfBuildings = 0;
		try {
			numberOfBuildings = scanner.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Settlement town = settlementCreator.create(settlementName, numberOfBuildings);
		blankLine();
		System.out.println(town);
	}
	
	private void createBuilding() {
		Building building = buildingCreator.create();
		System.out.println(building);
	}

}
