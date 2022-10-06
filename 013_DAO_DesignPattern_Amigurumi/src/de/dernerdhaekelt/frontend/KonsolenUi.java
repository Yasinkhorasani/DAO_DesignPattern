package de.dernerdhaekelt.frontend;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import de.dernerdhaekelt.backend.Amigurumi;
import de.dernerdhaekelt.middletier.AmigurumiService;
import de.dernerdhaekelt.middletier.Kriteriums;

/**
 * Stellt die Schnittstelle zum Benutzer dar.
 * Verwendet den Amigurmi-Service, erstellt ihn abern nicht!
 * Hat keine Referenz auf die Datenhaltung!
 * 
 *
 */
public class KonsolenUi {
	/** Wird nach verabeiteten Daten gefrag*/
	private AmigurumiService jeannie;
	
	/**
	 * Dependency Injection: KonsolenUI bekommt Zugriff auf den Servic
	 * @param jeannie
	 */
	public KonsolenUi(AmigurumiService jeannie) {
		this.jeannie = jeannie;
	}
	
	/**
	 * Startet die Darstellung des Benutzerinterfaces
	 */
	public void launch() {
		System.out.println("******* Willkommen bei den häkelnden Nerds *********\n");
		navigieren();
	}

	/**
	 * Stellt das Benutzermenue zur Verfügung.
	 * Eine REKURSIVE Methode: ruft sich immer wieder selbst auf
	 * Muss definiert beendet werden: return beendet die Methode
	 */
	private void navigieren() {
		System.out.println("Bitte wähle:\n\t"
				+ "1: Anzeige einer Übersicht über unsere beliebtesten Amigurumis\n\t"
				+ "2: Anzeige der Arten, die wir aktuell im Programm haben\n\t"
				+ "3: Anzeige unserer wunderbaren Einhörner\n\t"
				+ "4: Hast du eine Wunschnamen? Hier gibt es alle Amigurumis diesen Namens\n\t"
				//----
				+ "\tBeenden mit jeder anderen Zahl");
		
		Scanner leser = new Scanner(System.in);
		//Dumme User Absicherung....
		int auswahl = leser.nextInt();
		
		switch(auswahl) {
		case 1:
			anzeigenUebersicht();
			break;
		case 2:
			anzeigenArten();
			break;
		case 3:
			anzeigenEinhoerner();
			break;
		case 4:
			anzeigenNachWunschname();
			break;
		default:
			System.out.println("Vielen Dank, bald gibt es neue, aufregende Amigurumis, komm bald wieder vorbei!");
			return;
			//definiertes Ende der Rekursion
		case 42:
			System.out.println("Dies ist ein Egg, ein EasterEgg");
			break;
		}
		navigieren();
	}

	@SuppressWarnings("resource")
	private void anzeigenNachWunschname() {
		System.out.println("Auch ganz individuell, wünsche dir dein persönliches Amigurumi!");
		System.out.println("Wie soll es denn heißen?");
		Scanner leser = new Scanner(System.in);
		String wunschname = leser.nextLine();
		List<Amigurumi> tierMitWunschnamen = jeannie.bereitstellenNachKriterium(Kriteriums.istWunschName(wunschname));
		if(tierMitWunschnamen.size()<1) {
			System.out.println("Eine phantastischer Name! Noch nicht im Programm, aber das werdn wir ändern");
			//jeannie.aufnehmenVonNanemVorschlaegen(wunschname),
		}else {
			for(int i = 0; i < tierMitWunschnamen.size(); i++) {
				System.out.println("Diese Amigurumi ist ein " 
								+ tierMitWunschnamen.get(i).getArt() + " und was ganz besonderes!" );
			}
		}
	}

	private void anzeigenEinhoerner() {
		List<Amigurumi> dieEinhoerner = jeannie.bereitstellenNachKriterium(Kriteriums.IST_EINHORN);
		dieEinhoerner.forEach(einhorn->
			System.out.println("Ein  wirklich zauberhaftes Einhorn ist " + einhorn.getName()));
	}

	private void anzeigenArten() {
		String[] werbetexte = {
			"Exotisch, aber sehr beliebt",  
			"Gehört in jedes Kinderzimmer",
			"Bedroht, deshalb s wichtig",
			"Ein Zeichen für Frieden",
			"Zeigt, wie lieb du jemanden hast"
		};
		
		Random wuerfel = new Random();
		Set<String> arten = jeannie.bereitstellenDerVerfuegbarenArten();
		System.out.println("Heute haben wir sage und schreibe " + arten.size() + " Arten im Programm");
		for(String art : arten) {
			int index = wuerfel.nextInt(werbetexte.length);
			System.out.println(art + ": " + werbetexte[index]);
		}
	}

	private void anzeigenUebersicht() {
		List<Amigurumi> dieZehnAmigurumis = jeannie.bereitstellenDerMaximal10BestenAmigurumis();
		for(Amigurumi tier : dieZehnAmigurumis) {
			System.out.println("Das Amigurumi " + tier.getName() + " ist ein " + tier.getArt());
		}
	}
}



