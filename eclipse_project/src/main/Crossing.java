package main;

import java.util.ArrayList;

public class Crossing {
	
	private int id;
	private GameTile gameTile;
	private ArrayList<Hexagon> hexagons;
	
	public Crossing(int id) {
		this.id = id;
		hexagons = new ArrayList<Hexagon>();
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


	public ArrayList<Hexagon> getHexagons() {
		return hexagons;
	}
	
}
