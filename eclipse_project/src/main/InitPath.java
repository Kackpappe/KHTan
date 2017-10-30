package main;

public class InitPath {
	
	private Hexagon hexagon;
	
	public InitPath(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	
	public void initializePaths() {
		PathProvider provider = PathProvider.getInstance();
		
		for (HexagonNeighbor hexNeighbor : hexagon.getNeighbors().keySet()) {
			Hexagon neighbor = hexagon.getNeighbors().get(hexNeighbor);
			
			if (neighbor == null) {
				continue;
			}
			
			if ((hexagon.getType() == HexagonType.Wasser) && (neighbor.getType() == HexagonType.Wasser)) {
				continue;
			}
			
			Path path = hexagon.getPaths().get(hexNeighbor);
			
			if (path == null) {
				path = provider.providePath();
				hexagon.getPaths().put(hexNeighbor, path);
			}
			
			HexagonNeighbor opposite = getOppositeSide(hexNeighbor);
			Path neighborPath = neighbor.getPaths().get(opposite);
			
			if (neighborPath == null) {
				neighbor.getPaths().put(opposite, path);
			}
		}
	}
	
	
	private HexagonNeighbor getOppositeSide(HexagonNeighbor mySide) {
		HexagonNeighbor side = null;
		
		switch (mySide) {
			case neighbor1: { side = HexagonNeighbor.neighbor4; break; }
			case neighbor2: { side = HexagonNeighbor.neighbor5; break; }
			case neighbor3: { side = HexagonNeighbor.neighbor6; break; }
			case neighbor4: { side = HexagonNeighbor.neighbor1; break; }
			case neighbor5: { side = HexagonNeighbor.neighbor2; break; }
			case neighbor6: { side = HexagonNeighbor.neighbor3; break; }
		}
		
		return side;
	}
	
}
