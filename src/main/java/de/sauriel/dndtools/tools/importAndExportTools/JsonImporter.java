package main.java.de.sauriel.dndtools.tools.importAndExportTools;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeMap;

import main.java.de.sauriel.dndtools.spells.Spell;
import main.java.de.sauriel.dndtools.spells.Spelllist;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonImporter {

	private final String SPELLS_FOLDER_NAME = "spells/";
	private final String SPELLLISTS_FOLDER_NAME = "spelllists/";

	public ArrayList<Spell> importSpells() {
		return getObjects(SPELLS_FOLDER_NAME, Spell.class);
	}

	public ArrayList<Spelllist> importSpelllists(ArrayList<Spell> spells) {
		TreeMap<String, Spell> spellsMap = new TreeMap<>();
		for (Spell spell : spells) {
			spellsMap.put(spell.getName(), spell);
		}
		ArrayList<Spelllist> spelllists = new ArrayList<>();
		ArrayList<ImportedSpelllist> importedSpelllist = getObjects(SPELLLISTS_FOLDER_NAME, ImportedSpelllist.class);
		for (ImportedSpelllist list : importedSpelllist) {
			spelllists.add(Spelllist.convert(list, spellsMap));
		}
		return spelllists;
	}

	private <T> ArrayList<T> getObjects(String folderName, Class<T> clazz) {

		ArrayList<T> objects = new ArrayList<>();

		ClassLoader classLoader = getClass().getClassLoader();

		URL resourceFolder = classLoader.getResource(folderName);

		try {
			Files.walk(Paths.get(resourceFolder.toURI())).forEach(filePath -> {
				if (Files.isRegularFile(filePath)) {
					String file = filePath.toString();
					if (file.endsWith(".json")) {
						//System.out.println("Read: " + file + " as " + clazz.getSimpleName() + ".");
						T object = readJsonFile(file, clazz);
						objects.add(object);
					}
				}
			});
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objects;

	}

	private <T> T readJsonFile(String file, Class<T> clazz) {

		ObjectMapper mapper = new ObjectMapper();

		T object = null;

		try {
			object = mapper.readValue(new File(file), clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;
	}

}
