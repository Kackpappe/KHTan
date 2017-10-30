package main;

public class InitHexagon {
	
	private Hexagon hexagon;
	private InitCrossing initCrossing;
	private InitPath initPath;
	
	public InitHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
		
		initCrossing = new InitCrossing(hexagon);
		initPath = new InitPath(hexagon);
	}
	
	
	public void initializeHexagon() {
		hexagon.getNeighbors().clear();
		hexagon.getNeighbors().put(HexagonNeighbor.neighbor1, null);
		hexagon.getNeighbors().put(HexagonNeighbor.neighbor2, null);
		hexagon.getNeighbors().put(HexagonNeighbor.neighbor3, null);
		hexagon.getNeighbors().put(HexagonNeighbor.neighbor4, null);
		hexagon.getNeighbors().put(HexagonNeighbor.neighbor5, null);
		hexagon.getNeighbors().put(HexagonNeighbor.neighbor6, null);
		
		hexagon.getCrossings().clear();
		hexagon.getCrossings().put(HexagonCorners.corner1, null);
		hexagon.getCrossings().put(HexagonCorners.corner2, null);
		hexagon.getCrossings().put(HexagonCorners.corner3, null);
		hexagon.getCrossings().put(HexagonCorners.corner4, null);
		hexagon.getCrossings().put(HexagonCorners.corner5, null);
		hexagon.getCrossings().put(HexagonCorners.corner6, null);
		
		hexagon.getPaths().clear();
		hexagon.getPaths().put(HexagonNeighbor.neighbor1, null);
		hexagon.getPaths().put(HexagonNeighbor.neighbor2, null);
		hexagon.getPaths().put(HexagonNeighbor.neighbor3, null);
		hexagon.getPaths().put(HexagonNeighbor.neighbor4, null);
		hexagon.getPaths().put(HexagonNeighbor.neighbor5, null);
		hexagon.getPaths().put(HexagonNeighbor.neighbor6, null);
	}
	
	
	public InitCrossing getInitCrossing() {
		return initCrossing;
	}
	
	
	public InitPath getInitPath() {
		return initPath;
	}
	
	
	public Hexagon getHexagon() {
		return hexagon;
	}
	
}
