package main;

public class InitHarbour {
	// Alle Häfen isntanziieren
	// Die Anzahl der Häfen basiert auf einer Tabelle
	// LOOP Tabelle
	
	public void InitHarbour() {
		Harbour hafen = new Harbour();
		hafen.setGeben(2); //Zahl wird aus Tabelle gelesen
		hafen.setNehmen(1);
		ResourceType givenResource = ResourceType.Holz; //Typ wird aus Tabelle gelesen
		hafen.setGivenResource(givenResource);
		
		//Anschließend ins Spielfeld übertragen
	}
	
	
	
	

}
