package de.dernerdhaekelt.middletier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import de.dernerdhaekelt.backend.Amigurumi;
import de.dernerdhaekelt.backend.AmigurumiDao;
//import de.dernerdhaekelt.backend.AmigurumiDaoImplMitMaker;

/**
 * Verarbeitung 
 * 
 * Logik der Anwendung
 * 
 * Berechnung, Auswahl, Filtern der Daten
 *
 */
public class AmigurumiService {
	
	private List<Amigurumi> pets;
	
	private AmigurumiDao quelle;
	
	/**
	 * "Lose Koppelung" zwischen Datenquelle und Service
	 * Dependency Injection: Initialisierung des Datenzugriffsobjekts nicht hier
	 * @param datenquelle
	 */
	public AmigurumiService(AmigurumiDao datenquelle) {
		quelle = datenquelle;
		pets = quelle.getAllAmigurumis();
	}

	/**
	 * Erstellt eine Liste mit max 10 Amigurumis, für eine Darstellung für den Benutzer
	 * @return
	 */
	public List<Amigurumi> bereitstellenDerMaximal10BestenAmigurumis(){
		List<Amigurumi> auswahl = new ArrayList<>();
		if(pets.size() > 10) {
			for(int i =0; i< 10; i++) {
				auswahl.add(pets.get(i));
			}
		}else{
			auswahl = pets;
		}
		return auswahl;
	}
	
	public Set<String> bereitstellenDerVerfuegbarenNamen(){
		Set<String> namen = new HashSet<>();
		for(Amigurumi tier : pets) {
			namen.add(tier.getName());
		}
		return namen;
	}
	
	
	public Set<String>bereitstellenDerVerfuegbarenArten(){
		Set<String> arten = new HashSet<>();
		for(Amigurumi tier : pets) {
			arten.add(tier.getArt());
		}
		return arten;
	}
	
	public List<Amigurumi> bereitstellenAllerEinhoerner(){
		List<Amigurumi> auswahl = new ArrayList<>();
		for(Amigurumi tier : pets) {
			if(tier.getArt().equals("Einhorn")) {
				auswahl.add(tier);
			}
		}
		return auswahl;
	}
	
	
	
	public List<Amigurumi> bereitstellenAllerKurts(){
		List<Amigurumi> auswahl = new ArrayList<>();
		for(Amigurumi tier : pets) {
			if(tier.getName().equals("Kurt")) {
				auswahl.add(tier);
			}
		}
		return auswahl;
	}
	
	/**Luxus-Amigurumi kostet mehr als 10 Euro*/
	public List<Amigurumi> bereitstellenAllerLuxusAmigurumis(){
		List<Amigurumi> auswahl = new ArrayList<>();
		for(Amigurumi tier : pets) {
			if(tier.getPreis() > 1000) {
				auswahl.add(tier);
			}
		}
		return auswahl;
	}
	
	/**Kleinkind geeignete Amigurumis*/
	public List<Amigurumi> bereitstellenAllerPetsFuerKids(){
		List<Amigurumi> auswahl = new ArrayList<>();
		for(Amigurumi tier : pets) {
			if(tier.isKleinkindGeeignet()) {
				auswahl.add(tier);
			}
		}
		return auswahl;
	}
	
	/**Alle Petsa die Kurt heissen und Katzen sinds*/
	public List<Amigurumi> bereitstellenKurtKatzen(){
		List<Amigurumi> auswahl = new ArrayList<>();
		for(Amigurumi tier : pets) {
			if(tier.getName().equals("Kurt")&&tier.getArt().equals("Katze")) {
				auswahl.add(tier);
			}
		}
		return auswahl;
	}
	
	
	//Wunschmethode
	public List<Amigurumi> bereitstellenNachKriterium(Predicate<Amigurumi> kriterium){
		List<Amigurumi> auswahl = new ArrayList<>();
		for(Amigurumi tier : pets) {
			if(kriterium.test(tier)) {
				auswahl.add(tier);
			}
		}
		return auswahl;
	}
	
	/**
	 * Kurzform der bereitstellenNachKriterium(Predicate<Amigurumi> kriterium)-Methode
	 * Benutzt die Standard-Methoden: stream(), und filter
	 * @param kriterium
	 * @return
	 */
	public List<Amigurumi> auswaehlenKurz(Predicate<Amigurumi> kriterium){
		return pets.stream().filter(kriterium).collect(Collectors.toList());
	}
	
	
	public void sortierenNachPreis() {
		pets.sort((pet1, pet2)->Integer.valueOf(pet1.getPreis()).compareTo(pet2.getPreis()));
	}
	
	public void sortierenNachName() {
		pets.sort((pet1, pet2) -> pet1.getName().compareTo(pet2.getName()));
	}
	
	public void sortierenNachDatum() {
		pets.sort((pet1, pet2) -> pet1.getVerfuegbarAb().compareTo(pet2.getVerfuegbarAb()));
	}
	
	public void sortieren(Comparator<Amigurumi> sortierKriterium) {
		pets.sort(sortierKriterium);
	}
	
	public void mischen() {
		Collections.shuffle(pets);
	}
	
	
	
}
