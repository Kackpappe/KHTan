package main;

public class InitHarbour {
	// Alle H�fen isntanziieren
	// Die Anzahl der H�fen basiert auf einer Tabelle
	// LOOP Tabelle
	
	public void InitHarbour() {
		Harbour hafen = new Harbour();
		hafen.setGeben(3); //Zahl wird aus Tabelle gelesen
		hafen.setNehmen(1);
		ResourceType givenResource = ResourceType.Holz; //Typ wird aus Tabelle gelesen
		hafen.setGivenResource(givenResource);
	}
	
	
	
	

}
