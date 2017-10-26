package main;

import java.util.HashMap;

public class Crossing {
	
	private int id;
	private GameTile gameTile;
	private HashMap<Integer, Hexagon> hexagons;
	
	public Crossing(int id) {
		this.id = id;
		hexagons = new HashMap<Integer, Hexagon>();
	}
	
	
	public int getId() {
		return id;
	}

	
	public GameTile getGameTile() {
		return gameTile;
	}
	public void setGameTile(GameTile gameTile) {
		this.gameTile = gameTile;
	}


	public HashMap<Integer, Hexagon> getHexagons() {
		return hexagons;
	}
	
}
