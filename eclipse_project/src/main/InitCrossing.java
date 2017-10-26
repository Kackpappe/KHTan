package main;

import java.util.ArrayList;
import java.util.HashMap;

public class InitCrossing {
	
	private Hexagon hexagon;
	
	public InitCrossing(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	
	public void initCrossings() {
		HashMap<HexagonCorners, Crossing> crossings = hexagon.getCrossings();
		CrossingProvider provider = CrossingProvider.getInstance();
		
		if (hexagon.getType() == HexagonType.Wasser) {
			
		} else {
			ArrayList<CrossingNeighbors> neighbors = new ArrayList<CrossingNeighbors>();
			neighbors.add(new CrossingNeighbors(HexagonCorners.corner1, HexagonNeighbor.neighbor6, HexagonNeighbor.neighbor1));
			neighbors.add(new CrossingNeighbors(HexagonCorners.corner2, HexagonNeighbor.neighbor1, HexagonNeighbor.neighbor2));
			neighbors.add(new CrossingNeighbors(HexagonCorners.corner3, HexagonNeighbor.neighbor2, HexagonNeighbor.neighbor3));
			neighbors.add(new CrossingNeighbors(HexagonCorners.corner4, HexagonNeighbor.neighbor3, HexagonNeighbor.neighbor4));
			neighbors.add(new CrossingNeighbors(HexagonCorners.corner5, HexagonNeighbor.neighbor4, HexagonNeighbor.neighbor5));
			neighbors.add(new CrossingNeighbors(HexagonCorners.corner6, HexagonNeighbor.neighbor5, HexagonNeighbor.neighbor6));
			
			for (CrossingNeighbors cn : neighbors) {
				Crossing crossing = hexagon.getCrossings().get(cn.corner);
				
				if (crossing == null) {
					crossing = provider.provideCrossing();
					hexagon.getCrossings().put(cn.corner, crossing);
				}
				
				crossing.getHexagons().put(hexagon.getId(), hexagon);
				
				Hexagon neighbor = hexagon.getNeighbors().get(cn.neighbor1);
			}
			
			
//			Crossing crossing1 = provider.provideCrossing();
//			crossing1.getHexagons().add(hexagon);
			
			Hexagon neighbor6 = hexagon.getNeighbors().get(HexagonNeighbor.neighbor6);
			
			if (neighbor6 != null) {
				Crossing crossing = neighbor6.getCrossings().get(HexagonCorners.corner3);
				
				if (crossing == null) {
					crossing = provider.provideCrossing();
				}
				
				
			}
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


