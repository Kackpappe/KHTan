package main;

import java.util.HashMap;

public class Hexagon {
	
	private int id;
	private HexagonType type;
	private int numberChip;
	private boolean blocked;
	private HashMap<HexagonNeighbor, Hexagon> neighbors;
	private HashMap<HexagonCorners, Crossing> crossings;
	private HashMap<HexagonNeighbor, Path> paths;
	private EarningsCalculator earningsCalc;
	private InitHexagon initHex;
	
	public Hexagon(int id, HexagonType type, int numberChip) {
		this.id = id;
		this.type = type;
		this.numberChip = numberChip;
		
		neighbors = new HashMap<HexagonNeighbor, Hexagon>();
		crossings = new HashMap<HexagonCorners, Crossing>();
		paths = new HashMap<HexagonNeighbor, Path>();
		
		earningsCalc = new EarningsCalculator(this);
		
		initHex = new InitHexagon(this);
		initHex.initializeHexagon();
	}
	
	
	public int getId() {
		return id;
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
	
	
	public HashMap<HexagonNeighbor, Hexagon> getNeighbors() {
		return neighbors;
	}


	public HashMap<HexagonCorners, Crossing> getCrossings() {
		return crossings;
	}


	public HashMap<HexagonNeighbor, Path> getPaths() {
		return paths;
	}


	public EarningsCalculator getEarningsCalc() {
		return earningsCalc;
	}
	
	
	public InitHexagon getInitHex() {
		return initHex;
	}
	
}
