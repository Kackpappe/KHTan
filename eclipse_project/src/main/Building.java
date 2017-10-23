package main;

public class Building extends DevelopmentCard {

	private BuildingType type;
	
	public Building(BuildingType type, int round) {
		super(1, round);
		this.type = type;
	}

	
	public BuildingType getType() {
		return type;
	}

}
