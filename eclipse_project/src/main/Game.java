package main;

import java.util.ArrayList;

public class Game {
		private int CurrentRound; //aktuelle Spielrunde
		private int CurrentMove;  //aktueller Spielzug
		private int CurrentPhase; // aktuelle Spielphase
		private ArrayList<Player> playerList = new ArrayList<Player>();  //Liste der Spieler
		
		public static void main(ArrayList<Player> player) {
			//Spielfeld und Karten initialisieren
			InitialSequence init = new InitialSequence();
			Bank bank = init.main(null);
			
			for(int i = 0; player.get(i).getWinpoints() < 10; i++) {
				
			}
			
			
			
			
			// 1. Würfeln
			Dice dice = new Dice().roll();
			int diceTotal = dice.rolled_dice_total;
			// 2. Rohstoffe verteilen oder Räuber
			if (diceTotal == 7) {
				// Räuber!
			}
			else {
				// Prüfen, welche Spieler betroffen sind
			}
	
		}
}
