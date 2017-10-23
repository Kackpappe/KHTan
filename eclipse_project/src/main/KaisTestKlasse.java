package main;

public class KaisTestKlasse {

		private static main.Dice Dice;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dice = new main.Dice();
		Dice = Dice.roll();
		System.out.print("Erster Würfel = " + Dice.rolled_dice1);
		System.out.print("\nZweiter Würfel = " + Dice.rolled_dice2);
		System.out.print("\nWürfel Gesamt = " + Dice.rolled_dice_total);
	}

}
