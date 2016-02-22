import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.*;
import no.hib.dat102.mengde.tabell.TabellMengde;

public class MengdeADTtest {

	MengdeADT<String> kmengde1;
	MengdeADT<String> kmengde2;
	MengdeADT<String> tmengde1;
	MengdeADT<String> tmengde2;
	
	/**
	 * Create setup stuff
	 */
	@Before
	public void setUp() throws Exception {
		kmengde1 = new KjedetMengde<String>();
		kmengde2 = new KjedetMengde<String>();
		tmengde1 = new TabellMengde<String>();
		tmengde2 = new TabellMengde<String>();


		kmengde1.leggTil("Hei");
		kmengde1.leggTil("pa");
		kmengde1.leggTil("deg");

		kmengde2.leggTil("din");
		kmengde2.leggTil("gamle");
		kmengde2.leggTil("sei");
		
		tmengde1.leggTil("Dette");
		tmengde1.leggTil("er");
		tmengde1.leggTil("en");

		tmengde2.leggTil("test");
		tmengde2.leggTil("pa");
		tmengde2.leggTil("tabellmengde");
		

	}

	@Test
	public void testUnionKjedetMengde() {
		String[] svar = { "Hei", "pa", "deg", "din", "gamle", "sei" };

		MengdeADT<String> begge = new KjedetMengde<String>();
		for (int i = 0; i < svar.length; i++) {
			begge.leggTil(svar[i]);
		}

		MengdeADT<String> uni = kmengde1.union(kmengde2);

		assertTrue(begge.erLik(uni));
		//Disjunkt
		assertFalse(!(begge.erLik(uni)));
	}

	public void testUnionTabellMengde(){
		
		
	}
	
	
}
