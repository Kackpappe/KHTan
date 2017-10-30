package main;

public class Path {
	
	private int id;
	private GameTile gameTile;
	
	public Path(int id) {
		this.id = id;
	}

	
	public GameTile getGameTile() {
		return gameTile;
	}
	public void setGameTile(GameTile gameTile) {
		this.gameTile = gameTile;
	}

	
	public int getId() {
		return id;
	}
	
}
