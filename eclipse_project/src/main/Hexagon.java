package main;

import java.util.HashMap;

public class Hexagon {
	
	private int id;
	private HexagonType type;
	private int numberChip;
	private boolean blocked;
	private HashMap<HexagonNeighbor, Hexagon> neighbors;
	private HashMap<HexagonCorners, Crossing> crossings;
	private HashMap<HexagonEdges, GameTile> edges;
	private EarningsCalculator calculator;
	private InitCrossing initCrossing;
	
	public Hexagon(int id, HexagonType type, int numberChip) {
		this.id = id;
		this.type = type;
		this.numberChip = numberChip;
		
		calculator = new EarningsCalculator(this);
		initCrossing = new InitCrossing(this);
		
		init();
	}
	
	
	public void placeCorner(HexagonCorners corner, GameTile gameTile) {
		Crossing crossing = crossings.get(corner);
		crossing.setGameTile(gameTile);
		crossings.put(corner, crossing);
	}
	
	
	public void removeCorner(HexagonCorners corner) {
		Crossing crossing = crossings.get(corner);
		crossing.setGameTile(null);
		crossings.put(corner, crossing);
	}
	
	
	public void placeEdge(HexagonEdges edge, GameTile gameTile) {
		edges.put(edge, gameTile);
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


	public HashMap<HexagonEdges, GameTile> getEdges() {
		return edges;
	}


	public EarningsCalculator getCalculator() {
		return calculator;
	}


	public InitCrossing getInitCrossing() {
		return initCrossing;
	}


	private void init() {
		neighbors = new HashMap<HexagonNeighbor, Hexagon>();
		neighbors.put(HexagonNeighbor.neighbor1, null);
		neighbors.put(HexagonNeighbor.neighbor2, null);
		neighbors.put(HexagonNeighbor.neighbor3, null);
		neighbors.put(HexagonNeighbor.neighbor4, null);
		neighbors.put(HexagonNeighbor.neighbor5, null);
		neighbors.put(HexagonNeighbor.neighbor6, null);
		
		crossings = new HashMap<HexagonCorners, Crossing>();
		
		edges = new HashMap<HexagonEdges, GameTile>();
		edges.put(HexagonEdges.edge1, null);
		edges.put(HexagonEdges.edge2, null);
		edges.put(HexagonEdges.edge3, null);
		edges.put(HexagonEdges.edge4, null);
		edges.put(HexagonEdges.edge5, null);
		edges.put(HexagonEdges.edge6, null);
	}
	
}
