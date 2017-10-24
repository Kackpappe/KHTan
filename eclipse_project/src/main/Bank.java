package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
	
	private Stock stock;
	
	
	public Bank() {
		stock = new Stock();
	}
	
	
	public void fillStock(ArrayList<ResourceCard> resources, ArrayList<DevelopmentCard> developmentCards) {
		stock.addDevelopmentCards(developmentCards);
		stock.addResourceCards(resources);
	}
	
	
	public void giveResourceCards(ArrayList<Earning> earnings) {
		for (Earning earning : earnings) {
			Player player = earning.getPlayer();
			HashMap<ResourceType, Integer> resources = earning.getResources();
			
			for (ResourceType type : resources.keySet()) {
				Integer count = resources.get(type);
				
				for (int i = 1; i <= count; i++) {
					try {
						player.AddResourceCard(stock.getResourceCard(type));
					} catch (NoMoreCardInStockException e) {
						break;
					}
				}
			}
		}
	}
	
	
	public void receiveResourceCards(Player player, HashMap<ResourceType, Integer> resources) throws NotEnoughResourcesException {
		ArrayList<ResourceCard> cards = new ArrayList<ResourceCard>();
		
		for (ResourceType type : resources.keySet()) {
			Integer count = resources.get(type);
			
			for (int i = 1; i <= count; i++) {
				ResourceCard card = player.gatherResourceCard(type);
				
				if (card == null) {
					addResourceCardsToPlayer(player, cards);
					throw new NotEnoughResourcesException();
				}
				
				cards.add(card);
			}
		}
	}
	
	
	public void giveDevelopmentCard(Player player) throws NotEnoughResourcesException {
		ArrayList<ResourceCard> cards = new ArrayList<ResourceCard>();
		
		ResourceCard grain = player.gatherResourceCard(ResourceType.Getreide);
		
		if (grain == null) {
			addResourceCardsToPlayer(player, cards);
			throw new NotEnoughResourcesException();
		} else {
			cards.add(grain);
		}
		
		ResourceCard wool = player.gatherResourceCard(ResourceType.Wolle);
		
		if (wool == null) {
			addResourceCardsToPlayer(player, cards);
			throw new NotEnoughResourcesException();
		} else {
			cards.add(wool);
		}
		
		ResourceCard ore = player.gatherResourceCard(ResourceType.Erz);
		
		if (ore == null) {
			addResourceCardsToPlayer(player, cards);
			throw new NotEnoughResourcesException();
		} else {
			cards.add(ore);
		}
		
		try {
			player.AddDevCard(stock.getDevelopmentCard());
			stock.addResourceCards(cards);
		} catch (NoMoreCardInStockException e) {
			addResourceCardsToPlayer(player, cards);
		}
	}
	
	
	private void addResourceCardsToPlayer(Player player, ArrayList<ResourceCard> cards) {
		if (cards.size() == 0) {
			return;
		}
		
		for (ResourceCard card : cards) {
			player.AddResourceCard(card);
		}
	}
	
}
