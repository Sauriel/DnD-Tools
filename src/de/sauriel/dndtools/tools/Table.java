package de.sauriel.dndtools.tools;

import java.util.TreeMap;

public class Table {
	
	private TreeMap<Integer, String> table;
	
	public Table() {
		table = new TreeMap<Integer, String>();
	}
	
	private void sortTable() {
		table.descendingKeySet();
	}
	
	public void addValue(int start, int end, String value) {
		for(int i = start; i <= end; i++) {
			table.put(i, value);
		}
		sortTable();
	}
	
	public void addValue(int position, String value) {
		table.put(position, value);
		sortTable();
	}
	
	public String getValue(int key) {
		return table.get(key);
	}

}
