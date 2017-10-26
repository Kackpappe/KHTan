package main;

import java.util.HashMap;

public class CrossingProvider {
	
	private static CrossingProvider instance;
	
	private int counter;
	private HashMap<Integer, Crossing> crossings;
	
	public static CrossingProvider getInstance() {
		if (instance == null) {
			instance = new CrossingProvider();
		}
		
		return instance;
	}
	
	
	public Crossing provideCrossing() {
		Crossing crossing = new Crossing(counter);
		crossings.put(crossing.getId(), crossing);
		counter++;
		return crossing;
	}
	
	
	public HashMap<Integer, Crossing> getAllCrossings() {
		return crossings;
	}
	
	
	private CrossingProvider() {
		crossings = new HashMap<Integer, Crossing>();
		counter = 0;
	}
	
}
