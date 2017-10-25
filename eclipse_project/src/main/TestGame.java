package main;

import java.util.ArrayList;

public class TestGame {
		private static Bank bank = new Bank();
		private static ResourceCard resCard;
		private static DevelopmentCard devCard;
		private static SpecialCard specCard;
		
		public static void main(String[] args) {
			ArrayList<Player> playerList = new ArrayList<Player>();
			Player player = new Player();
			player.setName("Testspieler 1");
			player.setColor(Color.Rot);
			playerList.add(player);
			
			player = new Player();
			player.setName("Testspieler 2");
			player.setColor(Color.Blau);
			playerList.add(player);
			
			Game game = new Game();
			game.main(playerList);
			
			
			System.out.println(playerList.get(0).getName());
			System.out.println(playerList.get(0).getColor());
			System.out.println(playerList.get(0).getWinpoints());
			System.out.println("");
			System.out.println(playerList.get(1).getName());
			System.out.println(playerList.get(1).getColor());
			System.out.println(playerList.get(1).getWinpoints());
			
			
			
						
		}
}
