package main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Field {
	
	private HashMap<Integer, Hexagon> hexagons;
	
	
	
	
//	private ArrayList<Coordinate> coordinates;
//	private HashMap<Integer, Crossing> crossings;
	
	
	public Field() {
		hexagons = new HashMap<Integer, Hexagon>();
	}
	
	
	public void init() {
		Document doc = null;
		
		try {
			doc = loadXML("src/main/Spielfeld.xml");
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return;
		}
		
		NodeList hexList = doc.getElementsByTagName("hex");
		
		for (int i = 0; i < hexList.getLength(); i++) {
			Element hexElement = (Element) hexList.item(i);
			
			Hexagon hexagon = createHexagon(hexElement);
			hexagons.put(hexagon.getId(), hexagon);
			
			HashMap<HexagonNeighbor, Integer> neighbors = getNeighbors(hexElement);
			
			for (HexagonNeighbor hexNeighbor : neighbors.keySet()) {
				Integer hexId = neighbors.get(hexNeighbor);
				
				if (hexId != null) {
					Hexagon neighbor = hexagons.get(hexId);
					setNeighbor(hexagon, neighbor, hexNeighbor);
				}
			}
		}
	}
	
	
	private Document loadXML(String fileName) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File(fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		return dBuilder.parse(fXmlFile);
	}
	
	
	private Hexagon createHexagon(Element hexNode) {
		String id = hexNode.getAttribute("id");
		String type = hexNode.getAttribute("type");
		String number = hexNode.getAttribute("number");
		
		HexagonType hexType = null;
		
		switch (type) {
			case "0": { hexType = HexagonType.Wasser; break; }
			case "1": { hexType = HexagonType.Wolle; break; }
			case "2": { hexType = HexagonType.Lehm; break; }
			case "3": { hexType = HexagonType.Holz; break; }
			case "4": { hexType = HexagonType.Getreide; break; }
			case "5": { hexType = HexagonType.Erz; break; }
			case "6": { hexType = HexagonType.Wueste; break; }
		}
		
		return new Hexagon(Integer.valueOf(id), hexType, Integer.valueOf(number));
	}
	
	
	private HashMap<HexagonNeighbor, Integer> getNeighbors(Element hexElement) {
		HashMap<HexagonNeighbor, Integer> neighbors = new HashMap<HexagonNeighbor, Integer>();
		
		Element neighborsElement = (Element) hexElement.getElementsByTagName("neighbors").item(0);
		NodeList neighborList = neighborsElement.getElementsByTagName("neighbor");
		
		for (int i = 0; i < neighborList.getLength(); i++) {
			Element neighborElement = (Element) neighborList.item(i);
			
			String number = neighborElement.getAttribute("number");
			String id = neighborElement.getAttribute("id");
			
			Integer neighborId = null;
			HexagonNeighbor hexNeighbor = null;
			
			if (!id.equals("")) {
				neighborId = Integer.valueOf(id);
			}
			
			switch (number) {
				case "1": { 	hexNeighbor = HexagonNeighbor.neighbor1; break; }
				case "2": { 	hexNeighbor = HexagonNeighbor.neighbor2; break; }
				case "3": { 	hexNeighbor = HexagonNeighbor.neighbor3; break; }
				case "4": { 	hexNeighbor = HexagonNeighbor.neighbor4; break; }
				case "5": { 	hexNeighbor = HexagonNeighbor.neighbor5; break; }
				case "6": { 	hexNeighbor = HexagonNeighbor.neighbor6; break; }
			}
			
			neighbors.put(hexNeighbor, neighborId);
		}
		
		return neighbors;
	}
	
	
	private void setNeighbor(Hexagon hexagon, Hexagon neighbor, HexagonNeighbor hexNeighbor) {
		HexagonNeighbor hn = null;
		
		switch (hexNeighbor) {
			case neighbor1: { hn = HexagonNeighbor.neighbor4; break; } 
			case neighbor2: { hn = HexagonNeighbor.neighbor5; break; }
			case neighbor3: { hn = HexagonNeighbor.neighbor6; break; }
			case neighbor4: { hn = HexagonNeighbor.neighbor1; break; }
			case neighbor5: { hn = HexagonNeighbor.neighbor2; break; }
			case neighbor6: { hn = HexagonNeighbor.neighbor3; break; }
		}
		
		hexagon.getNeighbors().put(hexNeighbor, neighbor);
		
		if (neighbor != null) {
			neighbor.getNeighbors().put(hn, hexagon);
		}
	}
	
}
