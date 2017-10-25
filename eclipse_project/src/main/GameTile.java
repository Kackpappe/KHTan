package main;

public class GameTile {
	private main.GameTileType type;
	private Player player;
	private int winpoints;
	
	
	public int getWinpoints() {
		return winpoints;
	}
	public void setWinpoints(int winpoints) {
		this.winpoints = winpoints;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public main.GameTileType getType() {
		return type;
	}
	public void setType(main.GameTileType type) {
		this.type = type;
	}
}
