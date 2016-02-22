package no.hib.dat102.mengde.klient;

import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.mengde.tabell.TabellMengde;

import java.util.Iterator;
import java.util.Scanner;

public class KlientOrdlisteTabell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TabellMengde<String> ordListe1 = new TabellMengde<String>();

		String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		Scanner tastatur = new Scanner(System.in);
		// Legger til ordene i mengden ordListe1

		for (int i = 0; i < ord.length; i++) {
			ordListe1.leggTil(ord[i]);
		}
		TabellMengde<String> ordListe2 = new TabellMengde<String>();

		System.out.print("Oppgi en streng, avslutt med zzz :");
		String streng = tastatur.nextLine();
		// Leser inn ord
		while (!streng.equals("zzz")) {

			//...Fyll ut
			if(!streng.equals("") && !streng.equals("zzz")) {
				if(!ordListe1.inneholder(streng) && 
						!ordListe2.inneholder(streng)) {
					ordListe2.leggTil(streng);
					streng = "";
				} else {
					System.out.println("Ordet " + streng + " finnes allerede i ordlisten");
				}
			}
			
			System.out.print("Oppgi en streng, avslutt med zzz :");
			streng = tastatur.nextLine();
			
			
		} // while

		// Lager unionen av de to ordlistene
		TabellMengde<String> ordListeBegge = new TabellMengde<String>();
		ordListeBegge = (TabellMengde<String>) ordListe1.union(ordListe2);
		System.out.println("Utskrift av unionen av begge ordlistene");
		
		Iterator it = ordListeBegge.oppramser();
 		while(it.hasNext() && ordListeBegge.antall() > 0) {
			System.out.println(ordListeBegge.fjernTilfeldig().toString());
		}
		
		/*
		// Lager snittet av de to ordlistene
		TabellMengde<String> ordListeFelles = new TabellMengde<String>();
		ordListeFelles = (TabellMengde<String>) ordListe1.snitt(ordListe2);
		System.out.println("Utskrift av snittet av begge ordlistene");
        //...Fyll ut

		// Lager differansen av de to ordlistene
		TabellMengde<String> ordListeDiff = new TabellMengde<String>();
		ordListeDiff = (TabellMengde<String>) ordListe1.differens(ordListe2);
		System.out.println("Utskrift av differansen av begge ordlistene");

		//....*/
	}

}
