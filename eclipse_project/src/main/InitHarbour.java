package main;

import java.util.ArrayList;

public class InitHarbour {
	// Alle H�fen isntanziieren
	// Die Anzahl der H�fen basiert auf einer Tabelle
	// LOOP Tabelle
	
	public ArrayList<Harbour> InitHarbour() {
		ArrayList<Harbour> harbours = new ArrayList<Harbour>();
		Harbour hafen = new Harbour();
		hafen.setGeben(2); //Zahl wird aus Tabelle gelesen
		hafen.setNehmen(1);
		ResourceType givenResource = ResourceType.Holz; //Typ wird aus Tabelle gelesen
		hafen.setGivenResource(givenResource);
		harbours.add(hafen);
		//TODO Anschlie�end ins Spielfeld �bertragen
		return harbours;
	}
	
	
	
	

}
