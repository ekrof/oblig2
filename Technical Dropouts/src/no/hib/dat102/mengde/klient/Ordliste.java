package no.hib.dat102.mengde.klient;

import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.mengde.tabell.TabellMengde;

import java.util.Iterator;
import java.util.Scanner;

public class Ordliste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		KjedetMengde<String> ordListe1 = new KjedetMengde<String>();

		String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		Scanner tastatur = new Scanner(System.in);
		// Legger til ordene i mengden ordListe1

		for (int i = 0; i < ord.length; i++) {
			ordListe1.leggTil(ord[i]);
		}
		KjedetMengde<String> ordListe2 = new KjedetMengde<String>();

		System.out.print("Oppgi en streng, avslutt med zzz :");
		String streng = tastatur.nextLine();
		// Leser inn ord
		while (!streng.equals("zzz")) {

			//...Fyll ut
			if(!streng.equals("") && !streng.equals("zzz")) {
				if(!ordListe1.inneholder(streng) && 
						!ordListe2.inneholder(streng)) {
					ordListe2.leggTil(streng);
				} else {
					ordListe2.leggTil(streng);
					System.out.println("Ordet " + streng + " finnes allerede i ordlisten");
				}
			}
			
			System.out.print("Oppgi en streng, avslutt med zzz :");
			streng = tastatur.nextLine();
			
			
		} // while

		// Lager unionen av de to ordlistene
		KjedetMengde<String> ordListeBegge = new KjedetMengde<String>();
		ordListeBegge = (KjedetMengde<String>) ordListe1.union(ordListe2);
		System.out.println("Utskrift av unionen av begge ordlistene");
		
		Iterator it = ordListeBegge.oppramser();
 		while(it.hasNext() && ordListeBegge.antall() > 0) {
			System.out.println(ordListeBegge.fjernTilfeldig().toString());
		}
		
		
		// Lager snittet av de to ordlistene
		KjedetMengde<String> ordListeFelles = new KjedetMengde<String>();
		ordListeFelles = (KjedetMengde<String>) ordListe1.snitt(ordListe2);
		System.out.println("Utskrift av snittet av begge ordlistene");
		it = ordListeFelles.oppramser();
 		while(it.hasNext() && ordListeFelles.antall() > 0) {
			System.out.println(ordListeFelles.fjernTilfeldig().toString());
		}

		
		// Lager differansen av de to ordlistene
		KjedetMengde<String> ordListeDiff = new KjedetMengde<String>();
		ordListeDiff = (KjedetMengde<String>) ordListe1.differens(ordListe2);
		System.out.println("Utskrift av differansen av begge ordlistene");
		it = ordListeDiff.oppramser();
 		while(it.hasNext() && ordListeDiff.antall() > 0) {
			System.out.println(ordListeDiff.fjernTilfeldig().toString());
		}
		//....*/
	}

}
