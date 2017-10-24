package main;

import java.util.ArrayList;
import java.util.Collections;

public class InitialSequence {
	private ArrayList<ResourceCard> rList = new ArrayList<ResourceCard>();
	private ArrayList<DevelopmentCard> dList = new ArrayList<DevelopmentCard>();
	private ArrayList<SpecialCard> sList = new ArrayList<SpecialCard>();
	
	public Bank main(String[] args) {
		// Instanziieren der Karten
		createResCards();  // Ressourcenkarten
		createDevCards();  // Entwicklungskarten
		createSpecCards(); // Spezialkarten
		
		Collections.shuffle(dList);			
		// Bank auffüllen
		Bank bank = new Bank();
		bank.fillStock(rList,dList,sList);
		
		// TODO Verteilen der Rohstoffkarten
				
		// TODO Verteilen der Spielsteine
		createGameTiles();	
		// TODO Zum Schluss der Startsequenz Instanz löschen
		return bank;
	}
	
	private void createGameTiles() {
		// TODO Auto-generated method stub
		
	}

	private void createDevCards() {
	//TODO Schleifen verwenden
		
		DevelopmentCard devCard;
		devCard = new Knight(1);			
		dList.add(devCard);
		devCard = new Knight(1);			
		dList.add(devCard);
		devCard = new Knight(1);			
		dList.add(devCard);
		devCard = new Knight(1);			
		dList.add(devCard);
		devCard = new Knight(1);			
		dList.add(devCard);
		devCard = new Knight(1);			
		dList.add(devCard);
		devCard = new Knight(1);			
		dList.add(devCard);
		devCard = new Knight(1);			
		dList.add(devCard);
		devCard = new Knight(1);			
		dList.add(devCard);
		
		devCard = new Building(BuildingType.Parlament, 1);
		dList.add(devCard);
		devCard = new Building(BuildingType.Parlament, 1);
		dList.add(devCard);
		devCard = new Building(BuildingType.Universitaet, 1);
		dList.add(devCard);
		devCard = new Building(BuildingType.Universitaet, 1);
		dList.add(devCard);
		devCard = new Building(BuildingType.Bibliothek, 1);
		dList.add(devCard);
		devCard = new Building(BuildingType.Bibliothek, 1);
		dList.add(devCard);
		devCard = new Building(BuildingType.Kathedrale, 1);
		dList.add(devCard);
		devCard = new Building(BuildingType.Kathedrale, 1);
		dList.add(devCard);
		devCard = new Building(BuildingType.Marktplatz, 1);
		dList.add(devCard);
		devCard = new Building(BuildingType.Marktplatz, 1);
		dList.add(devCard);
		
		
		
		
		
		Progress progress = new Progress(ProgressType.Erfindung, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Erfindung, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Erfindung, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Erfindung, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Erfindung, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Erfindung, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Erfindung, 0);
		dList.add(progress);
		
		progress = new Progress(ProgressType.Monopol, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Monopol, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Monopol, 0);
		dList.add(progress);
		
		progress = new Progress(ProgressType.Strassenbau, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Strassenbau, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Strassenbau, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Strassenbau, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Strassenbau, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Strassenbau, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Strassenbau, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Strassenbau, 0);
		dList.add(progress);
		progress = new Progress(ProgressType.Strassenbau, 0);
		dList.add(progress);
	
		}
	
	private void createSpecCards() {
		SpecialCard specCard = new SpecialCard();
		sList.add(specCard);
	}
	
	private void createResCards() {
		// Holz
		ResourceCard rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Holz);
		rList.add(rCard);
		// Getreide
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Getreide);
		rList.add(rCard);
		// Lehm
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Lehm);
		rList.add(rCard);
		// Erz
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Erz);
		rList.add(rCard);
		// Wolle
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		rCard = new ResourceCard(ResourceType.Wolle);
		rList.add(rCard);
		
	}
	
}
