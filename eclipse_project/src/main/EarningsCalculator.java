package main;

import java.util.ArrayList;

public class EarningsCalculator {
	
	private Hexagon hexagon;
	
	public EarningsCalculator(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	
	public ArrayList<Earning> getEarnings() {
		ArrayList<Earning> earnings = new ArrayList<Earning>();
		
		if ((hexagon.getType() == HexagonType.Wasser) || (hexagon.getType() == HexagonType.Wueste)) {
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
		
		Crossing crossing = hexagon.getCrossings().get(corner);
		
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
		
		switch (hexagon.getType()) {
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
