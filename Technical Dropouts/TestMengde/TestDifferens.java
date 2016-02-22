import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.mengde.tabell.TabellMengde;

public class TestDifferens {

	KjedetMengde<String> kmengde1;
	KjedetMengde<String> kmengde2;
	TabellMengde<String> tmengde1;
	TabellMengde<String> tmengde2;

	KjedetMengde<String>fasit;
	@Before
	public void setUp() throws Exception {
		kmengde1 = new KjedetMengde<String>();
		kmengde2 = new KjedetMengde<String>();
		tmengde1 = new TabellMengde<String>();
		tmengde2 = new TabellMengde<String>();
		fasit = new KjedetMengde<String>();
		
		kmengde1.leggTil("Disse");
		kmengde1.leggTil("strengene");
		kmengde1.leggTil("er");
		
		kmengde2.leggTil("ulike");
		kmengde2.leggTil("fra");
		kmengde2.leggTil("hverandre");
		
		tmengde1.leggTil("Disse");
		tmengde1.leggTil("elementene");
		tmengde1.leggTil("skiller");

		tmengde2.leggTil("seg");
		tmengde2.leggTil("ut");
		tmengde2.leggTil("yo");
		
		fasit.leggTil("Disse");
		fasit.leggTil("strengene");
		fasit.leggTil("er");
	}

		
	@Test
	public void testDifferensKjedetMengde(){
	
		
		/*MengdeADT<String> begge = new KjedetMengde<String>();
		for(int i = 0; i<fasit.length; i++){
			begge.leggTil(fasit[i]);
		}*/
		MengdeADT<String> diff = kmengde1.differens(kmengde2);
		
		assertTrue(diff.erLik(fasit));
	}
	@Test
	public void testDifferensTabellMengde(){
		
	}
}
