package tests;

import java.time.LocalDate;
import java.util.List;

import de.dernerdhaekelt.backend.Amigurumi;
import de.dernerdhaekelt.backend.AmigurumiDao;
import de.dernerdhaekelt.backend.AmigurumiDaoImplMitMaker;
import de.dernerdhaekelt.backend.AmigurumiMitDB;

public class AmigurumiDaoImplMitMakerTest {

	public static void main(String[] args) {
//		AmigurumiDao datenQuelle = new AmigurumiDaoImplMitMaker(5);
//		List<Amigurumi> ersterVersuch = datenQuelle.getAllAmigurumis();
//		ersterVersuch.forEach(tier->System.out.println(tier));
//		System.out.println("---------------------------");
//		Amigurumi neuesPet = new Amigurumi("Testname", "Testart", false, 11_11, LocalDate.of(2022, 10, 6));
//		datenQuelle.addAmigurumi(neuesPet);
//		List<Amigurumi> zweiterVersuch = datenQuelle.getAllAmigurumis();
//		zweiterVersuch.forEach(tier->System.out.println(tier));
//		System.out.println("---------------------------");
//		datenQuelle.deleteAmigurumi(neuesPet);
//		List<Amigurumi>dritterVeruch =datenQuelle.getAllAmigurumis();
//		dritterVeruch.forEach(System.out::println);//wie   .forEach(tier->System.out.println(tier));
//		System.out.println("---------------------------");
//		Amigurumi zuBillig = datenQuelle.getAllAmigurumis().get(0);
//		zuBillig.setPreis(1_000_000_00);
//		List<Amigurumi> vierterVersuch = datenQuelle.getAllAmigurumis();
//		vierterVersuch.forEach(System.out::println);
//		
		AmigurumiMitDB meinAmi = new AmigurumiMitDB();
		List<Amigurumi> allerAmi = meinAmi.getAllAmigurumis();
		allerAmi.forEach(System.out::println);
		
		Amigurumi neu = new Amigurumi("Kelly", "leichtGummi", false, 10, LocalDate.now());
		meinAmi.addAmigurumi(neu);
		
//		meinAmi.deleteAmigurumi("Hund");
		meinAmi.updateAmigurumi(null);
	}

}


