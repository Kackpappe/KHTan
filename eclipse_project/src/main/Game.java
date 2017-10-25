package main;

import java.util.ArrayList;

public class Game {
		private int CurrentRound; //aktuelle Spielrunde
		private int CurrentMove;  //aktueller Spielzug
		private int CurrentPhase; // aktuelle Spielphase
		private ArrayList<Player> playerList = new ArrayList<Player>();  //Liste der Spieler
		
		public void main(ArrayList<Player> player) {
			//Spielfeld und Karten initialisieren
			InitialSequence init = new InitialSequence();
			Bank bank = init.main(player);
			
			// Spielzug
			for(int i = 0; i < player.size(); i++) {
									
				// 1. Würfeln
				Dice dice = new Dice().roll();
				// 2. Rohstoffe verteilen oder Räuber
				if (dice.rolled_dice_total == 7) {
					// Räuber!
				}
				else {
					// Prüfen, welche Spieler betroffen sind
				}
	
		}
		}
}
