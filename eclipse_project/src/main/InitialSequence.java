package main;

import java.util.ArrayList;
import java.util.Collections;

public class InitialSequence {
	private ArrayList<ResourceCard> rList = new ArrayList<ResourceCard>();
	private ArrayList<DevelopmentCard> dList = new ArrayList<DevelopmentCard>();
	private ArrayList<SpecialCard> sList = new ArrayList<SpecialCard>();
	
	public Bank main(ArrayList<Player> player) {
		// Instanziieren der Karten
		createResCards();  // Ressourcenkarten
		createDevCards();  // Entwicklungskarten
		createSpecCards(); // Spezialkarten
		
		Collections.shuffle(dList);			
		// Bank auffüllen
		Bank bank = new Bank();
		bank.fillStock(rList,dList,sList);
		
		// Häfen initialisieren
		ArrayList<Harbour> harbours = new ArrayList<Harbour>();
		InitHarbour inith = new InitHarbour();
		harbours = inith.InitHarbour();
		
		//TODO Häfen an Spielfeld übertragen
		
		// TODO Verteilen der Rohstoffkarten
				
		// TODO Verteilen der Spielsteine
		createGameTiles(player);	
		// TODO Zum Schluss der Startsequenz Instanz löschen
		return bank;
	}
	
	private void createGameTiles(ArrayList<Player> player) {
		// TODO Auto-generated method stub
		
		GameTile gTile;
		//gTile.setType(GameTileType.Raeuber);
		//gameTiles.add(gTile);
		
		for(int i = 0; i < player.size(); i++) {
			ArrayList<GameTile> gameTiles = new ArrayList<GameTile>();
			for(int is = 0; is < 5; is++) {
				gTile = new GameTile();
				gTile.setType(GameTileType.Siedlung);
				gTile.setWinpoints(1);
				gTile.setColor(player.get(i).getColor());
				gameTiles.add(gTile);
			}
			
			for(int is = 0; is < 4; is++) {
				gTile = new GameTile();
				gTile.setType(GameTileType.Stadt);
				gTile.setWinpoints(2);
				gTile.setColor(player.get(i).getColor());
				gameTiles.add(gTile);
			}
			
			for(int is = 0; is < 15; is++) {
				gTile = new GameTile();
				gTile.setType(GameTileType.Strasse);
				gTile.setWinpoints(0);
				gTile.setColor(player.get(i).getColor());
				gameTiles.add(gTile);
				

			}
			player.get(i).setGameTileList(gameTiles);
			
		}
		
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
		ResourceCard rCard;
		
		for(int ih = 0; ih < 30; ih++) {
			rCard = new ResourceCard(ResourceType.Holz);
			rList.add(rCard);	
		}
		
		for(int ih = 0; ih < 30; ih++) {
			rCard = new ResourceCard(ResourceType.Wolle);
			rList.add(rCard);	
		}
		
		for(int ih = 0; ih < 30; ih++) {
			rCard = new ResourceCard(ResourceType.Getreide);
			rList.add(rCard);	
		}
		
		for(int ih = 0; ih < 30; ih++) {
			rCard = new ResourceCard(ResourceType.Lehm);
			rList.add(rCard);	
		}
		
		for(int ih = 0; ih < 30; ih++) {
			rCard = new ResourceCard(ResourceType.Erz);
			rList.add(rCard);	
		}
			
	}
	
}
