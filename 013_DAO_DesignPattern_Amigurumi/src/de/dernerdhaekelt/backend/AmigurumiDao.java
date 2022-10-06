package de.dernerdhaekelt.backend;

import java.util.List;

/**
 * Bestandteil des Dao-Design Patterns
 * 
 * Gibt die Signatur der Objekte, die auf die Datenhaltung zugreifen vor
 * 
 * Ziel: Die Logik-Schicht/Middletier/Services haben keine Kenntisse über die Datenhaltung
 * 
 * Dao-Design Pattern stammt aus JavaEE: Ursprünglich gedacht umd die Datenbank abzutrennen
 * 
 *
 */
public interface AmigurumiDao {

	/**
	 * List die Liste der Amigurumi-Objekte aus der Datenhaltung aus
	 * Falls mit Datenbank gearbeitet wird: SELECT
	 * @return alle Amigurumis
	 */
	List<Amigurumi> getAllAmigurumis(); 
	
	/**
	 * Fügt der Datenhaltung ein Amigurumi-Objekt zu
	 * Datenbank: INSERT
	 * @param pet neu zu speichernde Amigurumi
	 */
	void addAmigurumi(Amigurumi pet);
	
	/**
	 * Entfernt das Objekt ais der Datenhaltung
	 * Datenbank: DELETE
	 * @param pet
	 */
	void deleteAmigurumi(Amigurumi pet);
	
	/**
	 * Aktualisiert die Daten eines Objekts, das in der Datenhaltung zu exisitert
	 * Datenbank: UPDATE
	 * @param pet
	 */
	void updateAmigurumi(Amigurumi pet);
	
//	/**
//	 * Kein Bestandteil des Design Patterns
//	 * Trotzdem manchmal praktisch...
//	 * @param id
//	 * @return
//	 */
//	Amigurumi getAmigurumiById(long id);
}




