package main;

import java.util.ArrayList;

public class Player {
		private String Name;
		private Color Color;
		private int Winpooints;
		private ArrayList<ResourceCard> ResourceCardList = new ArrayList<ResourceCard>();
		private ArrayList<DevelopmentCard> DevCardList = new ArrayList<DevelopmentCard>();
		private ArrayList<GameTile> GameTileList = new ArrayList<GameTile>();
		private SpecialCardType KnightlyPower;
		private SpecialCardType TradingPower;
		//private main.   Baustatus

		public void AddResourceCard(ResourceCard card) {
			ResourceCardList.add(card);
		}

		public void AddDevCard(DevelopmentCard card) {
			DevCardList.add(card);
		}

		public String getName() {
			return Name;
		}
		public ArrayList<ResourceCard> getResourceCard() {
			return ResourceCardList;
		}

		public ArrayList<DevelopmentCard> getDevelopmentCards() {
			return DevCardList;
		}
		
		public void setName(String name) {
			Name = name;
		}

		public main.Color getColor() {
			return Color;
		}

		public void setColor(main.Color color) {
			Color = color;
		}

		public int getWinpoints() {
			return Winpooints;
		}

		public void setWinpoints(int winpooints) {
			Winpooints = winpooints;
		}
		public ResourceCard gatherResourceCard(ResourceType type) {
			//TODO Karte (zum bezhahlen) aus Stock entnehmen
			ResourceCard resCard = null;
			ResourceCard returnCard = null;
			for(int i = 0; i < ResourceCardList.size(); i++) {
				resCard = ResourceCardList.get(i);
				if(resCard.getResourceType() == type) {
					returnCard = resCard;
					ResourceCardList.remove(i);
				}
				
			}
			return returnCard;
			
			
		}

		public SpecialCardType getKnightlyPower() {
			return KnightlyPower;
		}

		public void setKnightlyPower(SpecialCardType knightlyPower) {
			KnightlyPower = knightlyPower;
		}

		public SpecialCardType getTradingPower() {
			return TradingPower;
		}

		public void setTradingPower(SpecialCardType tradingPower) {
			TradingPower = tradingPower;
		}

		public ArrayList<GameTile> getGameTileList() {
			return GameTileList;
		}

		public void setGameTileList(ArrayList<GameTile> gameTileList) {
			GameTileList = gameTileList;
		}
}
