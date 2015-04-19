package main.java.de.sauriel.dndtools.spells;

import java.util.ArrayList;
import java.util.TreeMap;

import main.java.de.sauriel.dndtools.tools.importAndExportTools.ImportedSpelllist;

public class Spelllist {

	private String className;
	private ArrayList<Spell> spells;

	public Spelllist() {
		// Default constructor for json import
	}

	private Spelllist(String className, ArrayList<Spell> spells) {
		this.className = className;
		this.spells = spells;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ArrayList<Spell> getSpells() {
		return spells;
	}

	public void setSpells(ArrayList<Spell> spells) {
		this.spells = spells;
	}

	public static Spelllist create() {
		return new Spelllist("", new ArrayList<>());
	}

	@Override
	public String toString() {
		return "Spelllist [className=" + className + ", spells=" + spells + "]";
	}

	public static Spelllist convert(ImportedSpelllist importedSpelllist, TreeMap<String, Spell> spells) {
		ArrayList<String> importedSpells = importedSpelllist.getSpells();
		ArrayList<Spell> newSpells = new ArrayList<>();

		for (String spell : importedSpells) {
			newSpells.add(spells.get(spell));
		}

		return new Spelllist(importedSpelllist.getClassName(), newSpells);
	}
}
