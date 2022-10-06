package tests;

import java.util.List;

import de.dernerdhaekelt.backend.Amigurumi;
import de.dernerdhaekelt.backend.AmigurumiMaker;

public class AmigurumiMakerTest {

	public static void main(String[] args) {
//		AmigurumiMaker datenHaltung = new AmigurumiMaker(10);
		AmigurumiMaker datenHaltung = new AmigurumiMaker();

		List<Amigurumi> diePets = datenHaltung.getAllePets();
		diePets.forEach(pet -> System.out.println(pet));
	}

}
