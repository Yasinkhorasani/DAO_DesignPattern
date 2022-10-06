package de.dernerdhaekelt.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Erstellt eine Liste von Amigurumis : List<Amigurumi>.
 * 
 * Die Liste ist "Platzhalter" für eine echte Datenhaltung
 * Simmuliert zB die Datenbanl
 * 
 *
 */
public class AmigurumiMaker {

	/**
	 * wird gefuellt im Konstruktor
	 * Stellt die Simmulation der Datenhaltung dar
	 * Platzhalter während der Erstellung das Middletiers und Frontends
	 */
	private List<Amigurumi> allePets = new ArrayList<>();

	/**
	 * Enthält eine Array von Beispielnamen
	 * Enthält auch den Namen des Beispiel/Default/vergleichs-Objekt
	 */
	private String[] namen = {"Kurt","Rex","Donnerstag","Wisky", "Schokokuchen","Krümel","Fluuse", "Pumuckl",
			"Felix","Findus","Mika","Lilly","Maya","Keks","Paulchen","Teddy","Emmie","Leika"};
	
	/**
	 * Enthält Beispielarten
	 * Enthaält auch die Art des Beipiel/Default/Vergleichs-Objekt
	 */
	private String[]  arten = {"Hund", "Qualle", "Kobold", "Donnervogel", "Einhorn", "Alihorn", "Pegasus", "Debug Duck",
				"Maulwurf", "Katze", "Fliegenpilz", "Eichhörnchen", "Giraffe","Zentaure","Troll","Fee"};
	
	/**
	 * Enthält Preise als Integer. Das Preis-Attribut hat den Datentyp int:
	 * Beispiel für Boxing/Unboxing
	 */
	private Integer[] preise = {30_00, 140_00, 7_00, 9_99, 40_00, 5_22, 8_11, 12_12, 31_10 };
	
	/**
	 * Einige Objekte für die Verfügbarkeit
	 */
	private LocalDate[] verfuegbarkeiten = {
			LocalDate.of(2022, 12, 24),
			LocalDate.of(2030, 1, 1),
			LocalDate.of(2022, 10, 17),
			LocalDate.of(2024,10,31),
			LocalDate.now(),
			LocalDate.of(2020, 2, 20),
			LocalDate.of(2000, 1, 1),
			LocalDate.of(2012, 8, 31),
			LocalDate.of(1900, 1, 1)
	};
	
	/**
	 * Erstellt eine zufaellige Anzahl zufaelliger Amigurumi-Objekten aus
	 * den Beispiel-Daten
	 * 
	 * Erstellt in einer Endlos-Schleife solange Amigurumi-Objekte, bis ein
	 * Objekt erstellt wird, das zum Beispiel/Default/Vergleichs-Objekt aequivalent ist 
	 * (equals -> true )
	 */
	public AmigurumiMaker() {
		Amigurumi vergleichsObjekt = new Amigurumi();
		for(;;) {
			String name = namen[new Random().nextInt(namen.length)];
			String art = arten[new Random().nextInt(arten.length)];
			int preis = preise[new Random().nextInt(preise.length)];
			LocalDate verfuegbarAb = verfuegbarkeiten[new Random().nextInt(verfuegbarkeiten.length)];
			
			allePets.add(new Amigurumi(name, art, new Random().nextBoolean(), preis, verfuegbarAb));
			
			// ist das Vergleichsobjekt zugefügt worden? Sann Abbruch
			if(allePets.get(allePets.size()-1).equals(vergleichsObjekt)) {
				break;
			}
			
//			//Alternative
//			if(allePets.contains(vergleichsObjekt)) {
//				break;
//			}
		}
	}
	
	/** 
	 * Überladung des Konstruktors
	 * Erstellt eine vorgegebene Anzahl von Amigurumi-Objekten
	 * @param anzahl
	 */
	public AmigurumiMaker(int anzahl) {
		Random wuerfel = new Random();
		for(int i =0; i < anzahl; i++) {
			String name = namen[wuerfel.nextInt(namen.length)];
			String art = arten[wuerfel.nextInt(arten.length)];
			boolean kleinkindGeeignet = wuerfel.nextBoolean();
			int preis = preise[wuerfel.nextInt(preise.length)];
			LocalDate verfuegbarAb = verfuegbarkeiten[wuerfel.nextInt(verfuegbarkeiten.length)];
			
			Amigurumi neuesPet = new Amigurumi(name, art, kleinkindGeeignet, preis, verfuegbarAb);
			allePets.add(neuesPet);
		}
	}
	
	
	/**
	 * @return the allePets
	 */
	public List<Amigurumi> getAllePets() {
		return allePets;
	}
	
	
	
	
	
}
