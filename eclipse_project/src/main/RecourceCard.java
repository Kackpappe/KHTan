package main;

public class RecourceCard {
	
	private ResourceType type;
	
	private RecourceCard(ResourceType type) {
		this.type = type;
	}
	
	public ResourceType getRecourceType() {
		return this.type;
	}
	
}
