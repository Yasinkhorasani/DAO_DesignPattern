package tests;

import de.dernerdhaekelt.backend.AmigurumiDao;
import de.dernerdhaekelt.backend.AmigurumiDaoImplMitMaker;
import de.dernerdhaekelt.frontend.KonsolenUi;
import de.dernerdhaekelt.middletier.AmigurumiService;

public class KonsolenUiTest {

	public static void main(String[] args) {
		AmigurumiDao quelle = new AmigurumiDaoImplMitMaker(15);
		AmigurumiService knecht = new AmigurumiService(quelle);
		KonsolenUi interaktion = new KonsolenUi(knecht);
		interaktion.launch();

	}

}
