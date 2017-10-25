package main;

public class Dice {
		public int rolled_dice1;
		public int rolled_dice2;
		public int rolled_dice_total;
		
		private int roll_dice() {
			int zufallszahl; 
			zufallszahl = (int)(Math.random() * 5) + 1;
		    return zufallszahl;
		}
		
		private void roll_dice1() {
			int zufallszahl;
			zufallszahl = roll_dice();
		    rolled_dice1 = zufallszahl;
		}
		
		private void roll_dice2() {
			int zufallszahl;
			zufallszahl = roll_dice();
		    rolled_dice2 = zufallszahl;
		}
		
		public Dice roll() {
			roll_dice1();
			roll_dice2();
			this.rolled_dice_total = this.rolled_dice1 + this.rolled_dice2;
			return this;
			
		}
		
	}

