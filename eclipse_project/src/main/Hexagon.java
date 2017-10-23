package main;

public class Hexagon {
	
	private HexagonType type;
	private int numberChip;
	private boolean blocked;
	
	public Hexagon(HexagonType type, int numberChip) {
		this.type = type;
		this.numberChip = numberChip;
	}

	
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	
	public HexagonType getType() {
		return type;
	}

	
	public int getNumberChip() {
		return numberChip;
	}
	
}
