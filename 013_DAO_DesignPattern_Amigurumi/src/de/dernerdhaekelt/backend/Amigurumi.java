package de.dernerdhaekelt.backend;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Stellt die Daten eines Haekeltiers/Amigurumis zusammen.
 * 
 * POJO: Plain Old Java Objecs
 * Value-Klasse: Nur Eingenschaften, keine Fähigkeiten
 * 
 * 
 * Hier: DTO: Data Transfer Object: Sammelt die Daten eines Amigurumis und transportiert sie durch das Projekt
 * 
 * DTO: Aus dem DAO Design Pattern
 * DAO: Data Access Object: Objekte, die auf die Datenhalten zugreifen und ein gemeinsames Interface 
 * 	implementieren: Hier das AmigurumiDao
 * 
 * Häufig sind Value/POJO/DTO Klassen die ersten die in einem Projekt erstellt werden
 * 
 *
 *	Besonderheit der Amigurumi-Klasse: Amigurmis werden vielleicht auch in Datenbanken gespeichert
 *	Attribut für den Primaerschluessel
 */
public class Amigurumi {
	
	/** Wird von der Datenbank vergeben */
	private long primaerSchluessel;
	
	/** Enthaelt den Namen des Amigurumis zb Bello, Charlie, Fritz */
	private final String name;
	
	/** Enthaelt die Art des Amugurumis zb Einhorn, Maus, Qualle, Kobold*/
	private final String art;
	
	/** Gib an, ob das Amigurumi verschluckbare Kleinteile enthaelt*/
	private final boolean kleinkindGeeignet;
	
	/** Preis in Cent*/
	private int preis;
	
	/**
	 * Zeigt an, ob ein Anigurumi verkauft werden kann
	 * Kann sich zb durch Lieferverzoegerungen aendern
	 */
	private LocalDate verfuegbarAb;
	
	/**
	 * Erstellt ein einfaches Objekt, um schnell Beispielobjekte zu erstellen
	 * Auch um ein Vergleichsobjekt zu haben, zb zum Testen
	 * 
	 * name = "Kurt"
	 * art = "Hund"
	 * kleinkundGeeignet = true
	 * preis = 700
	 * verfuegbarAb = 1.1.2010
	 */
	public Amigurumi() {
		name = "Kurt";
		art = "Hund";
		kleinkindGeeignet = true;
		preis = 700;
		verfuegbarAb = LocalDate.of(2010, 1, 1);	
	}

	/**
	 * @param name
	 * @param art
	 * @param kleinkindGeeignet
	 * @param preis
	 * @param verfuegbarAb
	 */
	public Amigurumi(String name, String art, boolean kleinkindGeeignet, int preis, LocalDate verfuegbarAb) {
		this.name = name;
		this.art = art;
		this.kleinkindGeeignet = kleinkindGeeignet;
		this.preis = preis;
		this.verfuegbarAb = verfuegbarAb;
	}

	/**
	 * @return the primaerSchluessel
	 */
	public long getPrimaerSchluessel() {
		return primaerSchluessel;
	}

	/**
	 * @param primaerSchluessel the primaerSchluessel to set
	 */
	public void setPrimaerSchluessel(long primaerSchluessel) {
		if( primaerSchluessel == 0) {
			System.out.println("Exeption!");
			System.exit(-1);
		} 
		if(this.primaerSchluessel != 0) {
			System.out.println("Schlüssel schon gesetzt Exception");
			System.exit(-1);
		}
		
		this.primaerSchluessel = primaerSchluessel;
	}

	/**
	 * @return the preis
	 */
	public int getPreis() {
		return preis;
	}

	/**
	 * @param preis the preis to set
	 */
	public void setPreis(int preis) {
		this.preis = preis;
	}

	/**
	 * @return the verfuegbarAb
	 */
	public LocalDate getVerfuegbarAb() {
		return verfuegbarAb;
	}

	/**
	 * @param verfuegbarAb the verfuegbarAb to set
	 */
	public void setVerfuegbarAb(LocalDate verfuegbarAb) {
		this.verfuegbarAb = verfuegbarAb;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the art
	 */
	public String getArt() {
		return art;
	}

	/**
	 * @return the kleinkindGeeignet
	 */
	public boolean isKleinkindGeeignet() {
		return kleinkindGeeignet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(art, kleinkindGeeignet, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Amigurumi other = (Amigurumi) obj;
		return Objects.equals(art, other.art) && kleinkindGeeignet == other.kleinkindGeeignet
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Amigurumi [primaerSchluessel=" + primaerSchluessel + ", name=" + name + ", art=" + art
				+ ", kleinkindGeeignet=" + kleinkindGeeignet + ", preis=" + preis + ", verfuegbarAb=" + verfuegbarAb
				+ "]";
	}
	
	
}
