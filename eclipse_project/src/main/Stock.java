package main;

import java.util.ArrayList;

import exceptions.NoMoreCardInStockException;

public class Stock {
	
	private ArrayList<ResourceCard> wood;
	private ArrayList<ResourceCard> wool;
	private ArrayList<ResourceCard> clay;
	private ArrayList<ResourceCard> grain;
	private ArrayList<ResourceCard> ore;
	private ArrayList<DevelopmentCard> developmentCards;
	
	public Stock() {
		wood = new ArrayList<ResourceCard>();
		wool = new ArrayList<ResourceCard>();
		clay = new ArrayList<ResourceCard>();
		grain = new ArrayList<ResourceCard>();
		ore = new ArrayList<ResourceCard>();
		developmentCards = new ArrayList<DevelopmentCard>();
	}
	
	
	public void addResourceCard(ResourceCard card) {
		ArrayList<ResourceCard> cards = null;
		
		switch (card.getResourceType()) {
			case Wolle: { cards = wool; break; }
			case Erz: { cards = ore; break; }
			case Getreide: { cards = grain; break; }
			case Holz: { cards = wood; break; }
			case Lehm: { cards = clay; break; }
			default: { return; }
		}
		
		cards.add(card);
	}
	
	
	public void addResourceCards(ArrayList<ResourceCard> cards) {
		for (ResourceCard card : cards) {
			addResourceCard(card);
		}
	}
	
	
	public void addDevelopmentCards(ArrayList<DevelopmentCard> developmentCards) {
		this.developmentCards.addAll(developmentCards);
	}
	
	
	public ResourceCard getResourceCard(ResourceType type) throws NoMoreCardInStockException {
		ArrayList<ResourceCard> cards = null;
		
		switch (type) {
			case Wolle: { cards = wool; break; }
			case Erz: { cards = ore; break; }
			case Getreide: { cards = grain; break; }
			case Holz: { cards = wood; break; }
			case Lehm: { cards = clay; break; }
			default: { return null; }
		}
		
		checkStock(cards);
		return pullResourceCard(cards);
	}
	
	
	public DevelopmentCard getDevelopmentCard() throws NoMoreCardInStockException {
		if (developmentCards.size() == 0) {
			throw new NoMoreCardInStockException();
		}
		
		DevelopmentCard card = developmentCards.get(0);
		developmentCards.remove(0);
		return card;
	}
	
	
	private void checkStock(ArrayList<ResourceCard> cards) throws NoMoreCardInStockException {
		if (cards.size() == 0) {
			throw new NoMoreCardInStockException();
		}
	}
	
	
	private ResourceCard pullResourceCard(ArrayList<ResourceCard> cards) {
		ResourceCard card = cards.get(0);
		cards.remove(0);
		return card;
	}
	
}
