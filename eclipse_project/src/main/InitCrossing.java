package main;

import java.util.ArrayList;

public class InitCrossing {
	
	private Hexagon hexagon;
	private ArrayList<CrossingNeighbors> neighbors;
	
	public InitCrossing(Hexagon hexagon) {
		this.hexagon = hexagon;
		
		neighbors = new ArrayList<CrossingNeighbors>();
		neighbors.add(new CrossingNeighbors(HexagonCorners.corner1, HexagonNeighbor.neighbor6, HexagonNeighbor.neighbor1));
		neighbors.add(new CrossingNeighbors(HexagonCorners.corner2, HexagonNeighbor.neighbor1, HexagonNeighbor.neighbor2));
		neighbors.add(new CrossingNeighbors(HexagonCorners.corner3, HexagonNeighbor.neighbor2, HexagonNeighbor.neighbor3));
		neighbors.add(new CrossingNeighbors(HexagonCorners.corner4, HexagonNeighbor.neighbor3, HexagonNeighbor.neighbor4));
		neighbors.add(new CrossingNeighbors(HexagonCorners.corner5, HexagonNeighbor.neighbor4, HexagonNeighbor.neighbor5));
		neighbors.add(new CrossingNeighbors(HexagonCorners.corner6, HexagonNeighbor.neighbor5, HexagonNeighbor.neighbor6));
	}
	
	
	public void initializeCrossings() {
		CrossingProvider provider = CrossingProvider.getInstance();
		
		for (CrossingNeighbors cn : neighbors) {
			if (hexagon.getType() == HexagonType.Wasser) {
				boolean neighborsOk = checkNeighbors(cn.neighbor1, cn.neighbor2);
				
				if (neighborsOk == false) {
					continue;
				}
			}
			
			Crossing crossing = hexagon.getCrossings().get(cn.corner);
			
			if (crossing == null) {
				crossing = provider.provideCrossing();
				hexagon.getCrossings().put(cn.corner, crossing);
			}
			
			crossing.getHexagons().put(hexagon.getId(), hexagon);
			
			assignHexagonAndCorner(cn.corner, cn.neighbor1, crossing);
			assignHexagonAndCorner(cn.corner, cn.neighbor2, crossing);
		}
	}
	
	
	private HexagonCorners getHexagonCornerOfNeighbor(HexagonNeighbor neighbor, HexagonCorners myCorner) {
		switch (myCorner) {
			case corner1: {
				switch (neighbor) {
					case neighbor1: { return HexagonCorners.corner5; }
					case neighbor6: { return HexagonCorners.corner3; }
					default: return null;
				}
			}
			
			case corner2: {
				switch (neighbor) {
					case neighbor1: { return HexagonCorners.corner4; }
					case neighbor2: { return HexagonCorners.corner6; }
					default: return null;
				}
			}
			
			case corner3: {
				switch (neighbor) {
					case neighbor2: { return HexagonCorners.corner5; }
					case neighbor3: { return HexagonCorners.corner1; }
					default: return null;
				}
			}
			
			case corner4: {
				switch (neighbor) {
					case neighbor3: { return HexagonCorners.corner6; }
					case neighbor4: { return HexagonCorners.corner2; }
					default: return null;
				}
			}
			
			case corner5: {
				switch (neighbor) {
					case neighbor4: { return HexagonCorners.corner1; }
					case neighbor5: { return HexagonCorners.corner3; }
					default: return null;
				}
			}
			
			case corner6: {
				switch (neighbor) {
					case neighbor5: { return HexagonCorners.corner2; }
					case neighbor6: { return HexagonCorners.corner4; }
					default: return null;
				}
			}
			
			default: {
				return null;
			}
		}
	}
	
	
	private void assignHexagonAndCorner(HexagonCorners corner, HexagonNeighbor neighbor, Crossing crossing) {
		Hexagon hexNeighbor = hexagon.getNeighbors().get(neighbor);
		HexagonCorners neighborCorner = getHexagonCornerOfNeighbor(neighbor, corner);
		Crossing neighborCrossing = hexNeighbor.getCrossings().get(neighborCorner);
		
		if (neighborCrossing == null) {
			crossing.getHexagons().put(hexNeighbor.getId(), hexNeighbor);
			hexNeighbor.getCrossings().put(neighborCorner, crossing);
		} else {
			neighborCrossing.getHexagons().put(hexagon.getId(), hexagon);
			hexagon.getCrossings().put(corner, neighborCrossing);
		}
	}
	
	
	private boolean checkNeighbors(HexagonNeighbor neighbor1, HexagonNeighbor neighbor2) {
		Hexagon hexNeighbor1 = hexagon.getNeighbors().get(neighbor1);
		Hexagon hexNeighbor2 = hexagon.getNeighbors().get(neighbor2);
		
		if ((hexNeighbor1 == null) || (hexNeighbor2 == null)) {
			return false;
		}
		
		if ((hexNeighbor1.getType() == HexagonType.Wasser) && (hexNeighbor2.getType() == HexagonType.Wasser)) {
			return false;
		}
		
		return true;
	}
	
	
	private class CrossingNeighbors {
		public HexagonCorners corner;
		public HexagonNeighbor neighbor1;
		public HexagonNeighbor neighbor2;
		
		public CrossingNeighbors(HexagonCorners corner, HexagonNeighbor neighbor1, HexagonNeighbor neighbor2) {
			this.corner = corner;
			this.neighbor1 = neighbor1;
			this.neighbor2 = neighbor2;
		}
	}
	
}


