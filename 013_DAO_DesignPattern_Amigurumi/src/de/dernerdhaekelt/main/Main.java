package de.dernerdhaekelt.main;

import de.dernerdhaekelt.backend.AmigurumiDao;
import de.dernerdhaekelt.frontend.KonsolenUi;
import de.dernerdhaekelt.middletier.AmigurumiService;

public class Main {

	public static void main(String[] args) {
		String quellArt;
		if(args.length == 1) {
			quellArt = args[0];
		}else {
			quellArt = "Maker";
		}
		
		AmigurumiDao quelle = AmigurumiDaoFactory.createAmigurumiDao(quellArt);
		
		if(quelle == null) {
			System.out.println("Bitte wenden Sie sich wegen eines Updates an update@dernerdhaekelt.de");
			System.exit(0);
		}
		
		AmigurumiService jeannie = new AmigurumiService(quelle);
		
		KonsolenUi interaktion = new KonsolenUi(jeannie);
		interaktion.launch();
	}

}
