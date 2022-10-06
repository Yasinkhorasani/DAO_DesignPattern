package de.dernerdhaekelt.backend;

import java.util.List;

/**
 * Beschafft die Daten aus dem AmigurumiMaker(andere Impls: zB Datenbank)
 * Implementiert das AmigurumiDao Interface: 
 * Dann braucht die Logik/Middletier/Services keine Kenntnisse dier Klasse zu haben
 * 
 *
 */
public class AmigurumiDaoImplMitMaker implements AmigurumiDao{
	
	private AmigurumiMaker datenHaltung;
	

	public AmigurumiDaoImplMitMaker() {
		datenHaltung = new AmigurumiMaker();
	}
	
	public AmigurumiDaoImplMitMaker(int anzahl) {
		datenHaltung = new AmigurumiMaker(anzahl);
	}
	
	
	@Override
	public List<Amigurumi> getAllAmigurumis() {
		List<Amigurumi> dieGelesenenAmigurumis = datenHaltung.getAllePets();
		return dieGelesenenAmigurumis;
	}

	@Override
	public void addAmigurumi(Amigurumi pet) {
		List<Amigurumi> dieGelesenenAmigurumis = datenHaltung.getAllePets();
		dieGelesenenAmigurumis.add(pet);
	}

	@Override
	public void deleteAmigurumi(Amigurumi pet) {
		List<Amigurumi> dieGelesenenAmigurumis = datenHaltung.getAllePets();
		//Hier ggf noch verbessern
		dieGelesenenAmigurumis.remove(pet);
	}

	@Override
	public void updateAmigurumi(Amigurumi pet) {
		//Keine Implementierung nötig
	}

}
