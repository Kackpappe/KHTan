package main;

import java.util.ArrayList;

public class TestGame {
		private static Player player = new Player();
		private static Bank bank = new Bank();
		private static ResourceCard resCard;
		private static DevelopmentCard devCard;
		private static SpecialCard specCard;
		
		public static void main(String[] args) {
			ArrayList<ResourceCard> ResList = new ArrayList<ResourceCard>();
			ArrayList<DevelopmentCard> DevList = new ArrayList<DevelopmentCard>();
			ArrayList<SpecialCard> SpecList = new ArrayList<SpecialCard>();
			
			resCard = new ResourceCard(ResourceType.Holz);
			ResList.add(resCard);
			resCard = new ResourceCard(ResourceType.Holz);
			ResList.add(resCard);
			resCard = new ResourceCard(ResourceType.Getreide);
			ResList.add(resCard);
			resCard = new ResourceCard(ResourceType.Getreide);
			ResList.add(resCard);
			resCard = new ResourceCard(ResourceType.Erz);
			ResList.add(resCard);
			resCard = new ResourceCard(ResourceType.Erz);
			ResList.add(resCard);
			resCard = new ResourceCard(ResourceType.Wolle);
			ResList.add(resCard);
			resCard = new ResourceCard(ResourceType.Wolle);
			ResList.add(resCard);
			resCard = new ResourceCard(ResourceType.Lehm);
			ResList.add(resCard);
			
			devCard = new Knight(1);			
			DevList.add(devCard);
			devCard = new Building(BuildingType.Parlament, 1);
			DevList.add(devCard);
			
			specCard = new SpecialCard();
			SpecList.add(specCard);
			
			bank.fillStock(ResList, DevList, SpecList);
			
			player.setName("Testspieler");
			player.setColor(Color.Rot);
			
			
			
			
		}
}
