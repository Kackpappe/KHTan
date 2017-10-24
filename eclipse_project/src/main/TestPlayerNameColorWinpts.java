package main;
		
public class TestPlayerNameColorWinpts {
		private static main.Player player;
	
	public static void main(String[] args) {
		player = new Player();
		player.setName("Kackpappe");
		player.setColor(Color.Blau);
		player.setWinpoints(3);
		
		System.out.println("Name: " + player.getName());
		System.out.println("Farbe: " + player.getColor());
		System.out.println("Siegpunkte: " + player.getWinpoints());
	}
}
