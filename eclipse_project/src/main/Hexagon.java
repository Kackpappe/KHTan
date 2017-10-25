package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Hexagon {
	
	private int id;
	private HexagonType type;
	private int numberChip;
	private boolean blocked;
	private HashMap<HexagonNeighbor, Hexagon> neighbors;
	private HashMap<HexagonCorners, Crossing> corners;
	private HashMap<HexagonEdges, GameTile> edges;
	
	public Hexagon(int id, HexagonType type, int numberChip) {
		this.id = id;
		this.type = type;
		this.numberChip = numberChip;
		
		init();
	}
	
	
	public ArrayList<Earning> getEarnings() {
		ArrayList<Earning> earnings = new ArrayList<Earning>();
		
		if ((type == HexagonType.Wasser) || (type == HexagonType.Wueste)) {
			return earnings;
		}
		
		ArrayList<Earning> earningList = getEarningList();
		
		for (Earning earning : earningList) {
			Earning gesEarning = getEarningForPlayer(earnings, earning.getPlayer());
			
			if (gesEarning == null) {
				gesEarning = new Earning(earning.getPlayer());
				earnings.add(gesEarning);
			}
			
			for (ResourceType resType : earning.getResources().keySet()) {
				gesEarning.addResourceCount(resType, earning.getResources().get(resType));
			}
		}
		
		return earnings;
	}
	
	
	public void placeCorner(HexagonCorners corner, GameTile gameTile) {
		Crossing crossing = corners.get(corner);
		crossing.setGameTile(gameTile);
		corners.put(corner, crossing);
	}
	
	
	public void removeCorner(HexagonCorners corner) {
		Crossing crossing = corners.get(corner);
		crossing.setGameTile(null);
		corners.put(corner, crossing);
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


	public HashMap<HexagonCorners, Crossing> getCorners() {
		return corners;
	}


	private void init() {
		neighbors = new HashMap<HexagonNeighbor, Hexagon>();
		neighbors.put(HexagonNeighbor.neighbor1, null);
		neighbors.put(HexagonNeighbor.neighbor2, null);
		neighbors.put(HexagonNeighbor.neighbor3, null);
		neighbors.put(HexagonNeighbor.neighbor4, null);
		neighbors.put(HexagonNeighbor.neighbor5, null);
		neighbors.put(HexagonNeighbor.neighbor6, null);
		
		corners = new HashMap<HexagonCorners, Crossing>();
//		corners.put(HexagonCorners.corner1, null);
//		corners.put(HexagonCorners.corner2, null);
//		corners.put(HexagonCorners.corner3, null);
//		corners.put(HexagonCorners.corner4, null);
//		corners.put(HexagonCorners.corner5, null);
//		corners.put(HexagonCorners.corner6, null);
		
		edges = new HashMap<HexagonEdges, GameTile>();
		edges.put(HexagonEdges.edge1, null);
		edges.put(HexagonEdges.edge2, null);
		edges.put(HexagonEdges.edge3, null);
		edges.put(HexagonEdges.edge4, null);
		edges.put(HexagonEdges.edge5, null);
		edges.put(HexagonEdges.edge6, null);
	}
	
	
	private ArrayList<Earning> getEarningList() {
		ArrayList<Earning> earningList = new ArrayList<Earning>();
		
		appendEarning(earningList, HexagonCorners.corner1);
		appendEarning(earningList, HexagonCorners.corner2);
		appendEarning(earningList, HexagonCorners.corner3);
		appendEarning(earningList, HexagonCorners.corner4);
		appendEarning(earningList, HexagonCorners.corner5);
		appendEarning(earningList, HexagonCorners.corner6);
		
		return earningList;
	}
	
	
	private void appendEarning(ArrayList<Earning> earningList, HexagonCorners corner) {
		Earning earning = getEarningFromCorner(corner);
		
		if (earning != null) {
			earningList.add(earning);
		}
	}
	
	
	private Earning getEarningFromCorner(HexagonCorners corner) {
		Earning earning = null;
		int count = 0;
		
		Crossing crossing = corners.get(corner);
		
		if (crossing == null) {
			return earning;
		}
		
		GameTile tile = crossing.getGameTile();
		
		if (tile == null) {
			return earning;
		}
		
		switch (tile.getType()) {
			case Siedlung: { count = 1; break; }
			case Stadt: { count = 2; break; }
			default: { return earning; }
		}
		
		earning = new Earning(tile.getPlayer());
		earning.addResourceCount(getResourceType(), count);
		
		return earning;
	}
	
	
	private ResourceType getResourceType() {
		ResourceType resType = null;
		
		switch (type) {
			case Erz: { resType = ResourceType.Erz; break; }
			case Getreide: { resType = ResourceType.Getreide; break; }
			case Holz: { resType = ResourceType.Holz; break; }
			case Lehm: { resType = ResourceType.Lehm; break; }
			case Wolle: { resType = ResourceType.Wolle; break; }
			default: { return resType; }
		}
		
		return resType;
	}
	
	
	private Earning getEarningForPlayer(ArrayList<Earning> earnings, Player player) {
		Earning earning = null;
		
		for (Earning element : earnings) {
			if (element.getPlayer().equals(player)) {
				earning = element;
			}
		}
		
		return earning;
	}
	
}
