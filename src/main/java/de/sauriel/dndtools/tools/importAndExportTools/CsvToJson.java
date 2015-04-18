package main.java.de.sauriel.dndtools.tools.importAndExportTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.TreeMap;

import main.java.de.sauriel.dndtools.spells.Spell;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class CsvToJson {

	private final String FOLDER = "C:\\Users\\Sascha\\Downloads\\DnD CSVs\\Spells\\";
	private TreeMap<String, Spell> spells = new TreeMap<>();

	public static void main(String[] args) {

		CsvToJson importer = new CsvToJson();
		importer.run();

	}

	public void run() {
		try {
			Files.walk(Paths.get(FOLDER)).forEach(filePath -> {
				if (Files.isRegularFile(filePath)) {
					String file = filePath.toString();
					if (file.endsWith(".csv")) {
						System.out.println("Read: " + file);
						readCsvFile(file);
					}
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Found " + spells.size() + " Spells.");
		exportSpells(spells);
	}

	private void readCsvFile(String csvFile) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				Spell spell = parseCsvSpell(line.split(cvsSplitBy));
				String key = spell.getName();
				key = key.replace("/", "+");
				spells.put(key, spell);
				// System.out.println(spell.toString());

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Spell parseCsvSpell(String[] spellText) {
		Spell spell = Spell.create();

		spell.setLevel(Integer.valueOf(spellText[0]));

		String name = spellText[1];
		if (name.toLowerCase().contains("ritual")) {
			name = name.substring(0, name.toLowerCase().indexOf("ritual") - 2);
			spell.setRitual(true);
		}
		spell.setName(name);

		String type = spellText[2];
		if (type.toLowerCase().contains("level")) {
			type = type.substring(type.toLowerCase().indexOf("level") + 6);
		} else if (type.toLowerCase().contains("cantrip")) {
			type = type.substring(0, type.toLowerCase().indexOf("cantrip") - 1);
		}
		spell.setType(type);

		spell.setCastTime(spellText[3]);

		spell.setRange(spellText[4]);

		spell.setDuration(spellText[6]);

		String description = spellText[7];

		String components = spellText[5];
		if (components.toLowerCase().contains("v")) {
			spell.setVerbal(true);
		}
		if (components.toLowerCase().contains("s")) {
			spell.setSomatic(true);
		}
		if (components.toLowerCase().contains("m")) {
			spell.setMaterial(true);
			if (description.startsWith("(")) {
				int splitPoint = description.indexOf(")");
				spell.setMaterials(description.substring(1, splitPoint));
				description = description.substring(splitPoint + 2);
			}
		}

		description = description.replaceAll("\\s+", " ").trim();

		spell.setDescription(description);
		return spell;
	}

	private void exportSpells(TreeMap<String, Spell> spellList) {
		ObjectMapper mapper = new ObjectMapper();

		for (Entry<String, Spell> entry : spellList.entrySet()) {
			try {
				File jsonFile = new File(FOLDER + "spells\\" + entry.getKey() + ".json");
				System.out.println("Exporting to: " + jsonFile);
				mapper.writeValue(jsonFile, entry.getValue());
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
