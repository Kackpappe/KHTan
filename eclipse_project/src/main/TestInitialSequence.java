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
		Earning earning = new Earning(pList.get(0));
		earning.addResourceCount(ResourceType.Holz, 1);
		eList.add(earning);
		earning = new Earning(pList.get(1));
		earning.addResourceCount(ResourceType.Getreide, 1);
		eList.add(earning);
		
		InitialSequence init = new InitialSequence();
		Bank bank = init.main(pList);	// Bank befüllen
		bank.giveResourceCards(eList);  // Ertrag an Spieler übertragen
		
		for(int ip = 0; ip < pList.size(); ip++) {
			System.out.println("Spielerfarbe: " + pList.get(ip).getColor());
			System.out.println("Ressourcenkarten: ");
			for(int ipt = 0; ipt < pList.get(ip).getResourceCard().size(); ipt++) {
				System.out.println(pList.get(ip).getResourceCard().get(ipt).getResourceType());
			}
			System.out.println("Spielsteine: ");
			for(int ipg = 0; ipg < pList.get(ip).getGameTileList().size(); ipg++) {
				System.out.println(pList.get(ip).getGameTileList().get(ipg).getType());
			}
									
		}
	}
}
