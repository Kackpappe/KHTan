package main;

public class TestDice {

		private static main.Dice Dice;
	public static void main(String[] args) {
				
		Dice = new main.Dice();
		Dice = Dice.roll();
		System.out.print("Erster W�rfel = " + Dice.rolled_dice1);
		System.out.print("\nZweiter W�rfel = " + Dice.rolled_dice2);
		System.out.print("\nW�rfel Gesamt = " + Dice.rolled_dice_total);
	}

}
