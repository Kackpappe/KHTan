package main;

public class ResourceCard {
	
	private ResourceType type;
	
	private ResourceCard(ResourceType type) {
		this.type = type;
	}
	
	public ResourceType getResourceType() {
		return this.type;
	}
	
}
