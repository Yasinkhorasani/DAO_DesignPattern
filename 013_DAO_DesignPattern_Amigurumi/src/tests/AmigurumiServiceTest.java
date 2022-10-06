package tests;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import de.dernerdhaekelt.backend.Amigurumi;
import de.dernerdhaekelt.backend.AmigurumiDao;
import de.dernerdhaekelt.backend.AmigurumiDaoImplMitMaker;
import de.dernerdhaekelt.middletier.AmigurumiService;
import de.dernerdhaekelt.middletier.Kriteriums;

public class AmigurumiServiceTest {

	public static void main(String[] args) {
		AmigurumiDao quelle = new AmigurumiDaoImplMitMaker(10);
		AmigurumiService jeannie = new AmigurumiService(quelle);
		List<Amigurumi> zehnPets = jeannie.bereitstellenDerMaximal10BestenAmigurumis();
		zehnPets.forEach(System.out::println);
		System.out.println("-----------------------------");
		System.out.println(jeannie.bereitstellenDerVerfuegbarenNamen());
		System.out.println("-----------------------------");
		System.out.println(jeannie.bereitstellenDerVerfuegbarenArten());
		System.out.println("-----------------------------");
		List<Amigurumi> petsFuerKids = jeannie.bereitstellenAllerPetsFuerKids();
		petsFuerKids.forEach(System.out::println);
		System.out.println("-----------------------------");
		Predicate<Amigurumi> kriterium = pet -> pet.isKleinkindGeeignet();
		List<Amigurumi> kontrollListe = jeannie.bereitstellenNachKriterium(kriterium);
		kontrollListe.forEach(System.out::println);
		
		System.out.println("\n__________________________________________");
		List<Amigurumi> luxusTiere = jeannie.bereitstellenNachKriterium(Kriteriums.IST_LUXUS);
		luxusTiere.forEach(System.out::println);
		
		System.out.println("Welche Namen willst du sehen?");
		Scanner leser = new Scanner(System.in);
		String wunschname = leser.nextLine();
		Predicate<Amigurumi> auswahlKriterium = Kriteriums.istWunschName(wunschname);
		List<Amigurumi> personalisierteAuswahl = jeannie.bereitstellenNachKriterium(auswahlKriterium);
		personalisierteAuswahl.forEach(System.out::println);
		
	}

}
