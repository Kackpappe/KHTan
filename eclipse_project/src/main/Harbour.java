package main;

public class Harbour {
	private int geben;
	private int nehmen = 1; 	// Immer 1
	private main.ResourceType GivenResource;
	public int getGeben() {
		return geben;
	}
	public void setGeben(int geben) {
		this.geben = geben;
	}
	public int getNehmen() {
		return nehmen;
	}
	public void setNehmen(int nehmen) {
		this.nehmen = nehmen;
	}
	public main.ResourceType getGivenResource() {
		return GivenResource;
	}
	public void setGivenResource(main.ResourceType givenResource) {
		GivenResource = givenResource;
	}

	
}
