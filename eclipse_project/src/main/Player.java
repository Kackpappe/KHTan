package main;

import java.util.ArrayList;

public class Player {
		private String Name;
		private main.Color Color;
		private int Winpooints;
		private ArrayList<ResourceCard> ResourceCardList;
		private ArrayList<DevelopmentCard> DevCardList;
		private main.SpecialCardType KnightlyPower;
		private main.SpecialCardType TradingPower;
		//private main.   Bustatus

		public void AddResourceCard(ResourceCard card) {
			ResourceCardList.add(card);
		}

		public void AddDevCard(DevelopmentCard card) {
			DevCardList.add(card);
		}

		public String getName() {
			return Name;
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

		public int getWinpooints() {
			return Winpooints;
		}

		public void setWinpooints(int winpooints) {
			Winpooints = winpooints;
		}
		public ResourceCard gatherResourceCard(ResourceCard card) {
			//TODO Karte (zum bezhahlen) aus Stock entnehmen
			ResourceCard resCard = null;
			ResourceCard returnCard = null;
			for(int i = 0; i < ResourceCardList.size(); i++) {
				resCard = ResourceCardList.get(i);
				if(resCard.getResourceType() == card.getResourceType()) {
					returnCard = resCard;
					ResourceCardList.remove(i);
				}
				
			}
			return returnCard;
			
			
		}
}
