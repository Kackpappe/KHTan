package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Field {
	
	private HashMap<Integer, Hexagon> hexagons;
	private HashMap<Integer, Crossing> crossings;
	private HashMap<Integer, Path> paths;
	private InitField initField;
	
	
	public Field() {
		hexagons = new HashMap<Integer, Hexagon>();
		crossings = new HashMap<Integer, Crossing>();
		paths = new HashMap<Integer, Path>();
		initField = new InitField(this);
	}
	
	
	public void init() {
		initField.initializeFierld();
	}
	
	
	public void placeGameTileOnCrossing(int crossingId, GameTile gameTile) {
		Crossing crossing = crossings.get(crossingId);
		
		if (crossing != null) {
			crossing.setGameTile(gameTile);
		}
	}
	
	
	public void removeGameTileFromCrossing(int crossingId) {
		placeGameTileOnCrossing(crossingId, null);
	}
	
	
	public void placeGameTileOnPath(int pathId, GameTile gameTile) {
		Path path = paths.get(pathId);
		
		if (path != null) {
			path.setGameTile(gameTile);
		}
	}
	
	
	public boolean crossingHasGameTile(int crossingId) {
		Crossing crossing = crossings.get(crossingId);
		
		if (crossing == null) {
			return false;
		}
		
		if (crossing.getGameTile() == null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public boolean pathHasGameTile(int pathId) {
		Path path = paths.get(pathId);
		
		if (path == null) {
			return false;
		}
		
		if (path.getGameTile() == null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public ArrayList<Earning> getEarnings(int number) {
		ArrayList<Earning> earnings = new ArrayList<Earning>();
		
		for (Hexagon hex : hexagons.values()) {
			if (hex.getNumberChip() == number) {
				earnings.addAll(hex.getEarningsCalc().getEarnings());
			}
		}
		
		return earnings;
	}
	
	
	public HashMap<Integer, Hexagon> getHexagons() {
		return hexagons;
	}
	
	
	public HashMap<Integer, Crossing> getCrossings() {
		return crossings;
	}
	
	
	public HashMap<Integer, Path> getPaths() {
		return paths;
	}
	
	
	public InitField getInitField() {
		return initField;
	}
	
}
