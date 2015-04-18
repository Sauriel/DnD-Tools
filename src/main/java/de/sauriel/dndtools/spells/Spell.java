package main.java.de.sauriel.dndtools.spells;

public class Spell {

	private int level;
	private String type;
	private String name;
	private String castTime;
	private String range;
	private boolean verbal;
	private boolean somatic;
	private boolean material;
	private String materials;
	private String duration;
	private boolean ritual;
	private boolean concentrate;
	private String description;

	public Spell() {
		// Default constructor for json import
	}

	private Spell(int level, String type, String name, String castTime,
			String range, boolean verbal, boolean somatic, boolean material,
			String materials, String duration, boolean ritual,
			boolean concentrate, String description) {
		this.level = level;
		this.type = type;
		this.name = name;
		this.castTime = castTime;
		this.range = range;
		this.verbal = verbal;
		this.somatic = somatic;
		this.material = material;
		this.materials = materials;
		this.duration = duration;
		this.ritual = ritual;
		this.concentrate = concentrate;
		this.description = description;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCastTime() {
		return castTime;
	}
	public void setCastTime(String castTime) {
		this.castTime = castTime;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public boolean isVerbal() {
		return verbal;
	}
	public void setVerbal(boolean verbal) {
		this.verbal = verbal;
	}
	public boolean isSomatic() {
		return somatic;
	}
	public void setSomatic(boolean somatic) {
		this.somatic = somatic;
	}
	public boolean isMaterial() {
		return material;
	}
	public void setMaterial(boolean material) {
		this.material = material;
	}
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public boolean isRitual() {
		return ritual;
	}
	public void setRitual(boolean ritual) {
		this.ritual = ritual;
	}
	public boolean isConcentrate() {
		return concentrate;
	}
	public void setConcentrate(boolean concentrate) {
		this.concentrate = concentrate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public static Spell create() {
		return new Spell(-1, "", "", "", "", false, false, false, "", "", false, false, "");
	}

	@Override
	public String toString() {
		String rep = "";

		String ritualTag = ritual ? " (ritual)" : "";
		String allComponents = verbal ? "V" : "";
		allComponents = allComponents + (somatic ? ", S" : "");
		allComponents = allComponents + (material ? ", M (" + materials + ")" : "");
		allComponents = allComponents.startsWith(",") ? allComponents.substring(2) : allComponents;
		String concentrationTag = concentrate ? "Concentration, " : "";

		rep = name + "\n" +
				"Level " + level + " " + type + ritualTag + "\n" +
				"Casting Time: " + castTime + "\n" +
				"Range: " + range + "\n" +
				"Components: " + allComponents + "\n" +
				"Duration: " + concentrationTag + duration + "\n" +
				description;

		return rep;
	}
}
