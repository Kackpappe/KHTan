package main;

import java.util.ArrayList;

public class TestPlayerResourceCard {
		private static main.Player player;
		private static main.ResourceCard resCard;
		private static main.ResourceCard returnCard;
	public static void main(String[] args) {
			ArrayList<ResourceCard> cardList = new ArrayList<ResourceCard>();
			player = new Player();
			resCard = new ResourceCard(ResourceType.Holz);
			player.AddResourceCard(resCard);
			
			resCard = new ResourceCard(ResourceType.Getreide);
			player.AddResourceCard(resCard);
			
			cardList = player.getResourceCard();
			System.out.println("Karten auf der Hand:");
			for(int i = 0; i < cardList.size(); i++) {
				returnCard = cardList.get(i);	
				System.out.println(returnCard.getResourceType());
			}
			
			player.gatherResourceCard(resCard.getResourceType());
			System.out.println("\nEine Karte wurde entfernt. Neue Kartenhand:");
			for(int i = 0; i < cardList.size(); i++) {
				returnCard = cardList.get(i);
				System.out.println(returnCard.getResourceType());
			}
	}

}
