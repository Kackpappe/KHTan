package main;

public class TestDice {

		private static main.Dice Dice;
	public static void main(String[] args) {
				
		Dice = new main.Dice();
		Dice = Dice.roll();
		System.out.print("Erster Würfel = " + Dice.rolled_dice1);
		System.out.print("\nZweiter Würfel = " + Dice.rolled_dice2);
		System.out.print("\nWürfel Gesamt = " + Dice.rolled_dice_total);
	}

}
