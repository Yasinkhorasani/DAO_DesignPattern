package de.dernerdhaekelt.middletier;

import java.util.function.Predicate;

import de.dernerdhaekelt.backend.Amigurumi;

/**
 * Genereiert einige Predicate<Amigurumi> Objekte
 * Diese können mit Kriteriums. aufgerufen werden: static
 *
 */
public class Kriteriums {
	
	/**
	 *	 Vorlage für  die Bedingung, dass ein Amigurumi teuer ist: mehr 10 € kostet
	 * @author Alfa
	 *
	 */
	public static class InnerLuxus implements Predicate<Amigurumi>{
		@Override
		public boolean test(Amigurumi guru) {
			boolean istAusgewaehlt = guru.getPreis() > 1000;
			return istAusgewaehlt;
		}
	}
	
	public static final InnerLuxus IST_LUXUS = new InnerLuxus();
	
	public static final Predicate<Amigurumi> IST_FUER_KIDS = new Predicate<Amigurumi>() {
		
		@Override
		public boolean test(Amigurumi pet) {
			return pet.isKleinkindGeeignet();
		}	
	};
	
	public static final Predicate<Amigurumi> IST_EINHORN = pet->pet.getArt().equals("Einhorn");
	public static final Predicate<Amigurumi> IST_KRUEMEL = pet->pet.getName().equals("Krümel");
	
	public static final Predicate<Amigurumi> IST_EINHORN_NAMENS_KRUEMEL = IST_EINHORN.and(IST_KRUEMEL);
	public static final Predicate<Amigurumi> IST_GUENSTIG = IST_LUXUS.negate();
	
	public static final Predicate<Amigurumi> istWunschName(String wunschname){
		return pet -> pet.getName().equals(wunschname);
	} 
	
	public static final Predicate<Amigurumi> istWunschTier(String wunschname, String wunschart){
		return pet -> pet.getName().equals(wunschname) && pet.getArt().equals(wunschart); 
	}
} 



