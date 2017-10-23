package main;

public class Progress extends DevelopmentCard {

	private ProgressType type;
	
	public Progress(ProgressType type, int round) {
		super(0, round);
		this.type = type;
	}

	public ProgressType getType() {
		return type;
	}
	
}
