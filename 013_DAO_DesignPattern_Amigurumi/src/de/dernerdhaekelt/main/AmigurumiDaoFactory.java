package de.dernerdhaekelt.main;

import java.util.Scanner;

import de.dernerdhaekelt.backend.AmigurumiDao;
import de.dernerdhaekelt.backend.AmigurumiDaoImplMitMaker;

/**
 * Erstellt anhand eines String ein AmigurumiDaoImpl Objekt
 * Factory Design Pattern
 *
 */
public class AmigurumiDaoFactory {

	/**
	 * Erstellt eine AmigurumiDao Objekt
	 * @param quellArt 
	 * @return das Objekt der Implementierung des AmigurumiDaos oder null, wenn keine passende Implementierung
	 * gefunden wurde
	 */
	public static AmigurumiDao createAmigurumiDao(String quellArt) {
		int anzahl = 0;
		Scanner pruefer = new Scanner(quellArt);
		if(pruefer.hasNextInt()) {
			anzahl = pruefer.nextInt();
			quellArt = "Maker mit Anzahl";
		}
		
		switch(quellArt) {
		case "Maker mit Anzahl":
			return new AmigurumiDaoImplMitMaker(anzahl);
		case "Maker":
			return new AmigurumiDaoImplMitMaker();
		case "MySQL":
			System.out.println("Noch nicht implementiert");
			return null;
		case "JSON":
			System.out.println("Noch nicht implementiert");
			return null;
		case "Datenbank":
			System.out.println("Noch nicht implementiert");
			return null;
		case "Datenbank mit schnellem Zugriff":
			System.out.println("Noch nicht implementiert");
			return null;
		default:
			return null;
		}
	}   
}
