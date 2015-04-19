package main.java.de.sauriel.dndtools.tools.importAndExportTools;

import java.util.ArrayList;

public class ImportedSpelllist {

	private String className;
	private ArrayList<String> spells;

	public ImportedSpelllist() {
		// Default constructor for json import
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ArrayList<String> getSpells() {
		return spells;
	}

	public void setSpells(ArrayList<String> spells) {
		this.spells = spells;
	}

	@Override
	public String toString() {
		return "ImportedSpelllist [className=" + className + ", spells="
				+ spells + "]";
	}
}
