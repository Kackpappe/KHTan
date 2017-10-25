package main;

import java.util.ArrayList;

public class TestInitialSequence {

	public static void main(String[] args) {
		ArrayList<Earning> eList = new ArrayList<Earning>();
		ArrayList<Player> pList = new ArrayList<Player>();
		Player player = new Player();
		player.setColor(Color.Blau);
		pList.add(player);
		player = new Player();
		player.setColor(Color.Rot);
		pList.add(player);
		Earning earning = new Earning(player);
		earning.addResourceCount(ResourceType.Holz, 1);
		eList.add(earning);
		
		InitialSequence init = new InitialSequence();
		Bank bank = init.main(pList);
		bank.giveResourceCards(eList);
//		for(int i = 0; i < eList.size(); i++) {
//			System.out.println(player.getResourceCard().get(i).getResourceType());
//		}
		
		for(int ip = 0; ip < pList.size(); ip++) {
			System.out.println("Spielerfarbe: " + pList.get(ip).getColor());
			for(int ipg = 0; ipg < player.getGameTileList().size(); ipg++) {
				System.out.println(player.getGameTileList().get(ipg).getType());
			}
			
		}
	}
}
