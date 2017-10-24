package main;

import java.util.ArrayList;

public class TestInitialSequence {

	public static void main(String[] args) {
		ArrayList<Earning> eList = new ArrayList<Earning>();
		
		Player player = new Player();
		
		Earning earning = new Earning(player);
		earning.addResourceCount(ResourceType.Holz, 1);
		eList.add(earning);
		
		InitialSequence init = new InitialSequence();
		Bank bank = init.main(null);
		bank.giveResourceCards(eList);
		for(int i = 0; i < eList.size(); i++) {
			System.out.println(player.getResourceCard().get(i).getResourceType());
		}
	}
}
