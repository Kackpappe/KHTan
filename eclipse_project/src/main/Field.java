package main;

import java.util.HashMap;

public class Field {
	
	private HashMap<Integer, Hexagon> hexagons;
	private HashMap<Integer, Crossing> crossings;
	private InitField initField;
	
	
	public Field() {
		hexagons = new HashMap<Integer, Hexagon>();
		crossings = new HashMap<Integer, Crossing>();
		initField = new InitField(this);
	}
	
	
	public void init() {
		initField.initialIzeFierld();
	}
	
	
	public HashMap<Integer, Hexagon> getHexagons() {
		return hexagons;
	}
	
	
	public HashMap<Integer, Crossing> getCrossings() {
		return crossings;
	}


	public InitField getInitField() {
		return initField;
	}
	
}
