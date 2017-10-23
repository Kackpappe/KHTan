package main;

public class GameTile {
	private main.GameTileType type;
	private main.Color color;
	private int winpoints;
	
	
	public int getWinpoints() {
		return winpoints;
	}
	public void setWinpoints(int winpoints) {
		this.winpoints = winpoints;
	}
	public main.Color getColor() {
		return color;
	}
	public void setColor(main.Color color) {
		this.color = color;
	}
	public main.GameTileType getType() {
		return type;
	}
	public void setType(main.GameTileType type) {
		this.type = type;
	}
}
