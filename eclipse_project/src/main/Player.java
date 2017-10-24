package main;

import java.util.ArrayList;

public class Player {
		private String Name;
		private main.Color Color;
		private int Winpooints;
		private ArrayList<ResourceCard> ResourceCardList;
		//private main.   Entwicklunskarte
		private main.SpecialCardType KnightlyPower;
		private main.SpecialCardType TradingPower;
		//private main.   Bustatus

		public void AddResourceCard(ResourceCard card) {
			ResourceCardList.add(card);
		}

}
