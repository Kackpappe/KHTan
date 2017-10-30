package main;

import java.util.ArrayList;

public class TestHexagon {

	public static void main(String[] args) {
		Field field = new Field();
		field.init();
		
		Player frank = new Player();
		frank.setColor(main.Color.Rot);
		frank.setName("Frank");
		
		GameTile siedlung = new GameTile();
		siedlung.setPlayer(frank);
		siedlung.setType(GameTileType.Siedlung);
		siedlung.setWinpoints(1);
		
		field.placeGameTileOnCrossing(3, siedlung);
		
		GameTile stadt = new GameTile();
		stadt.setPlayer(frank);
		stadt.setType(GameTileType.Stadt);
		stadt.setWinpoints(2);
		
		field.placeGameTileOnCrossing(9, stadt);
		
		ArrayList<Earning> earnings = field.getEarnings(5);
		earnings.clear();
	}

}
