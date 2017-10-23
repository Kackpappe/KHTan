package main;

public abstract class DevelopmentCard {
	
	private int winPoints;
	private int round;
	private boolean hidden;
	
	public DevelopmentCard(int winPoints, int round) {
		this.winPoints = winPoints;
		this.round = round;
		this.hidden = true;
	}
	
	
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	
	public int getWinPoints() {
		return winPoints;
	}
	
	
	public int getRound() {
		return round;
	}
	
}
