import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.mengde.tabell.TabellMengde;

public class TestSnitt {

	KjedetMengde<String> kmengde1;
	KjedetMengde<String> kmengde2;

	TabellMengde<String> tmengde1;
	TabellMengde<String> tmengde2;

	@Before
	public void setUp() throws Exception {
		kmengde1 = new KjedetMengde<String>();
		kmengde2 = new KjedetMengde<String>();
		tmengde1 = new TabellMengde<String>();
		tmengde2 = new TabellMengde<String>();

		kmengde1.leggTil("Test");
		kmengde1.leggTil("for");
		kmengde1.leggTil("snitt");

		kmengde2.leggTil("i");
		kmengde2.leggTil("en");
		kmengde2.leggTil("Test");

		tmengde1.leggTil("Test");
		tmengde1.leggTil("for");
		tmengde1.leggTil("snitt");

		tmengde2.leggTil("i");
		tmengde2.leggTil("en");
		tmengde2.leggTil("Test");
	}

	@Test
	public void testSnittKjedetMengde() {
		String[] fasit = { "Test" };

		MengdeADT<String> begge = new KjedetMengde<String>();
		for (int i = 0; i < fasit.length; i++) {
			begge.leggTil(fasit[i]);
		}
		MengdeADT<String> kSnitt = kmengde1.snitt(kmengde2);

		assertTrue(begge.erLik(kSnitt));
	}

	@Test
	public void testSnittTabellMengde() {
		String[] fasit = { "Test" };

		MengdeADT<String> begge = new TabellMengde<String>();
		for (int i = 0; i < fasit.length; i++) {
			begge.leggTil(fasit[i]);
		}
		MengdeADT<String> tSnitt = tmengde1.snitt(tmengde2);

		assertTrue(begge.erLik(tSnitt));
	}

}
