package de.sauriel.dndtools;

import java.util.InputMismatchException;
import java.util.Scanner;

import de.sauriel.dndtools.settlements.Settlement;
import de.sauriel.dndtools.settlements.SettlementCreator;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	private SettlementCreator creator = new SettlementCreator();

	public void showMenu() {
		while (true) {
			System.out.println("### MENU ###");
			System.out.println("# 0.\tExit Program");
			System.out.println("# 1.\tCreate Settlement");
			System.out.println("### Choose your action ###");
			try {
				selectAction();
			} catch (InputMismatchException e) {
				System.out.println("\nYOUR INPUT IS NOT VALID, PLEASE TRY AGAIN.\n");
			}
		}
	}
	
	private void selectAction() throws InputMismatchException {
		scanner.reset();
		int input = scanner.nextInt();
		switch (input) {
		case 0:
			System.exit(1);
			scanner.close();
			break;
		case 1:
			createSettlement();
			break;
		}
		System.out.println();
	}
	
	private void createSettlement() {
		Settlement town = creator.create("Higgins");
		System.out.println(town);
	}

}
