package main.java.de.sauriel.dndtools.tools;

import java.util.TreeMap;

public class RangedTreeMap<V> extends TreeMap<Integer, V> {
	
	private static final long serialVersionUID = -2068256113400119328L;
	
	public void put(Integer keyStart,Integer keyEnd, V value) {
		for(int i = keyStart.intValue(); i <= keyEnd.intValue(); i++) {
			this.put(i, value);
		}
	}

}
