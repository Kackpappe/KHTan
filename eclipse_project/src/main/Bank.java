package main;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.NoMoreCardInStockException;
import exceptions.NotEnoughResourcesException;

public class Bank {
	
	private Stock stock;
	
	
	public Bank() {
		stock = new Stock();
	}
	
	
	public void fillStock(ArrayList<ResourceCard> resources,
						  ArrayList<DevelopmentCard> developmentCards,
						  ArrayList<SpecialCard> specialCards) {
		stock.addDevelopmentCards(developmentCards);
		stock.addResourceCards(resources);
		stock.addSpecialCards(specialCards);
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
		
		stock.addResourceCards(cards);
	}
	
	
	public void giveDevelopmentCard(Player player) throws NotEnoughResourcesException {
		DevelopmentCard card = null;
		
		try {
			card = stock.getDevelopmentCard();
		} catch (NoMoreCardInStockException e) {
			return;
		}
		
		HashMap<ResourceType, Integer> resources = new HashMap<ResourceType, Integer>();
		resources.put(ResourceType.Getreide, 1);
		resources.put(ResourceType.Wolle, 1);
		resources.put(ResourceType.Erz, 1);
		
		receiveResourceCards(player, resources);
		player.AddDevCard(card);
	}
	
	
	public void giveSpecialCard(Player player, SpecialCardType type) {
		SpecialCard card = stock.getSpecialCard(type);
		
		if (card != null) {
			// TODO
		}
	}
	
	
	public void receiveSpecialCard(Player player, SpecialCardType type) {
		SpecialCard card = null;		// TODO player.getSpecialCard(type);
		
		if (card != null) {
			stock.addSpecialCard(card);
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
