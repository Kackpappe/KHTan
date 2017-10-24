package main;

import java.util.HashMap;

public class Earning {
	
	private Player player;
	private HashMap<ResourceType, Integer> resources;
	
	public Earning(Player player) {
		this.player = player;
		resources = new HashMap<ResourceType, Integer>();
	}
	
	
	public void addResourceCount(ResourceType type, int count) {
		Integer resCount = resources.get(type);
		
		if (resCount != null) {
			resCount = resCount + count;
		} else {
			resources.put(type, count);
		}
	}
	
	public Player getPlayer() {
		return player;
	}


	public HashMap<ResourceType, Integer> getResources() {
		return resources;
	}
	
}
