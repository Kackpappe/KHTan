package main;

import java.util.HashMap;

public class PathProvider {
	
	private static PathProvider instance;
	
	private int counter;
	private HashMap<Integer, Path> paths;
	
	public static PathProvider getInstance() {
		if (instance == null) {
			instance = new PathProvider();
		}
		
		return instance;
	}
	
	
	public Path providePath() {
		Path path = new Path(counter);
		paths.put(path.getId(), path);
		counter++;
		return path;
	}
	
	
	public HashMap<Integer, Path> getAllPaths() {
		return paths;
	}
	
	
	private PathProvider() {
		paths = new HashMap<Integer, Path>();
		counter = 0;
	}
	
}
